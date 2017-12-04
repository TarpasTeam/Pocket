package cn.tarpas.pocket.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tarpas.pocket.common.dto.ErrorStatus;
import cn.tarpas.pocket.common.dto.WebMessage;
import cn.tarpas.pocket.dto.ShowScenicReq;
import cn.tarpas.pocket.dto.ShowScenicRsp;
import cn.tarpas.pocket.po.Advertising;
import cn.tarpas.pocket.po.City;
import cn.tarpas.pocket.po.ScenicSpot;
import cn.tarpas.pocket.service.AdvertisingService;
import cn.tarpas.pocket.service.CityService;
import cn.tarpas.pocket.service.ScenicSpotService;
import cn.tarpas.pocket.util.JsonMapper;

@Controller
public class ShowScenicAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);
	private static final JsonMapper JSON_MAPPER = new JsonMapper();
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private ScenicSpotService scenicSoptSerice;
	
	@Autowired
	private AdvertisingService advertisingService;
	
	@RequestMapping(value="/showScenic",method=RequestMethod.POST)
	public @ResponseBody WebMessage<ShowScenicRsp> showSenic(
			@RequestBody String requestBody,
			HttpServletRequest httpRequest,
			HttpServletResponse httpResponse
			){
		
		ShowScenicReq showSenicReq=JSON_MAPPER.fromJson(requestBody, ShowScenicReq.class);
		WebMessage<ShowScenicRsp> response = new WebMessage<ShowScenicRsp>();
		ShowScenicRsp showScenicRsp=new ShowScenicRsp();
		
		//TODO 从redis取得最近更新日期判断是否返回更新数据，否则返回无更新数据信号
		
		//获取热门城市列表
		City city=new City();
		city.setId(showSenicReq.getCityId());
		city.setIsPopular(true);
		List<City> cityList=cityService.selectList(city);
		
		//获取广告实体(列表)
		List<Advertising> advertisingList=advertisingService.selectList();
		
		//获取热门景点列表
		ScenicSpot scenicSpot=new ScenicSpot();
		scenicSpot.setCityId(showSenicReq.getCityId());
		scenicSpot.setIsPopular(true);
		List<ScenicSpot> scenicSpotList=scenicSoptSerice.selectList(scenicSpot);
		
		
		//将以上信息综合到showScenicRsp中
		
		List<HashMap<String,String>> hotCityMapList=new ArrayList<>();
		for(City element:cityList){
			HashMap<String,String> map=new HashMap<>();
			map.put("hotCity_name", element.getName());
			map.put("hotCity_picture", element.getPicture());
			hotCityMapList.add(map);
		}
					
		//广告信息		
		List<HashMap<String,String>> advertstingMapList =new ArrayList<>();
		for(Advertising element:advertisingList){
			HashMap<String,String> map=new HashMap<>();
			map.put("ad_picture", element.getPicture());
			map.put("ad_link", element.getLink());
			advertstingMapList.add(map);
		}
		
		//热门景点信息、轮播图  轮播图出处待定	
		List<HashMap<String,String>> hotScenicSpotMapList =new ArrayList<>();
		for(ScenicSpot element:scenicSpotList){
			HashMap<String,String> map=new HashMap<>();
			map.put("hotScenic_picture", element.getPicture());
			map.put("hotScenic_name", element.getScenicName());
			map.put("slideshow", element.getPicture());
			hotScenicSpotMapList.add(map);
		}
		
		showScenicRsp.setAdvertisingList(advertstingMapList);
		showScenicRsp.setCityList(hotCityMapList);
		showScenicRsp.setSenicSpotList(hotScenicSpotMapList);
		
		//System.out.println(JSON_MAPPER.beanToString(showScenicRsp));
		
		//包装成WebMessage并返回给客户端
		response.setErrorCode(ErrorStatus.SUCCESS);
		response.setResult(showScenicRsp);
		
		return response;
	}
}
