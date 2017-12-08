package cn.tarpas.pocket.service.im;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarpas.pocket.mapper.ScenicSpotMapper;
import cn.tarpas.pocket.po.City;
import cn.tarpas.pocket.po.ScenicSpot;
import cn.tarpas.pocket.service.ScenicSpotService;

@Service
public class ScenicSpotServiceImpl extends BaseServiceImpl<ScenicSpot> implements ScenicSpotService{
	
	@Autowired
	private ScenicSpotMapper scenicSpotMapper; 
	
	@Autowired
	private CityServiceImpl cityServiceImpl;

	
	/**
	 * @return 返回的map中含有两个键，一个为city 表示搜索到的城市记录 一个为scenicSpotsList，表示搜索到的景点list集合
	 */
	@Override
	public Map<String, Object> search(int cityId, String keyword) {
		List<ScenicSpot> scenicSpotList = null;
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(keyword != null && !"".equals(keyword)) {
			City city = new City();
			city.setName(keyword);
			city = cityServiceImpl.selectOne(city);
			/*** 若搜索的关键字与城市名完全匹配，则返回该城市下的热门景点列表,并按照热度降序排好序 */
			if(city != null) {
				ScenicSpot scenicSpot = new ScenicSpot();
				scenicSpot.setCityId(city.getId());
				/** city不为null，查询出该城市的热门景点 */
				scenicSpot.setIsPopular(true);
				
				scenicSpotList = selectList(scenicSpot,"heat desc");
				map.put("city", city);
				map.put("scenicSpotsList", scenicSpotList);
				
				return map;
			}
		}
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("cityId", cityId);
		if(keyword != null && !"".equals(keyword)) {
			param.put("keyword", "%"+keyword+"%");
		}
		scenicSpotList = scenicSpotMapper.search(param);
		map.put("scenicSpotList", scenicSpotList);
		map.put("city", null);
		return map;
	}
	
}
