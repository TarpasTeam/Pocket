package cn.tarpas.pocket.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.tarpas.pocket.util.JsonMapper;

public class ShowScenicRsp {
	
	@JsonProperty("hotCityList")
	List<HashMap<String,String>> cityList;
	
	@JsonProperty("senicSpotList")
	List<HashMap<String,String>> senicSpotList;
	
	@JsonProperty("advertisingList")
	List<HashMap<String,String>> advertisingList;

	public List<HashMap<String, String>> getCityList() {
		return cityList;
	}

	public void setCityList(List<HashMap<String, String>> cityList) {
		this.cityList = cityList;
	}

	public List<HashMap<String, String>> getSenicSpotList() {
		return senicSpotList;
	}

	public void setSenicSpotList(List<HashMap<String, String>> senicSpotList) {
		this.senicSpotList = senicSpotList;
	}

	public List<HashMap<String, String>> getAdvertisingList() {
		return advertisingList;
	}

	public void setAdvertisingList(List<HashMap<String, String>> advertisingList) {
		this.advertisingList = advertisingList;
	}
	
	public static void main(String[] args) {
		JsonMapper json=new JsonMapper();
		ShowScenicRsp resp=new ShowScenicRsp();
		HashMap<String, String> map=new HashMap<>();
		map.put("test", "value1");
		map.put("test", "value2");
		List<HashMap<String,String>> cityList=new ArrayList<>();
		List<HashMap<String,String>> senicSpotList=new ArrayList<>();
		List<HashMap<String,String>> advertisingList=new ArrayList<>();
		cityList.add(map);
		cityList.add(map);
		cityList.add(map);
		senicSpotList.add(map);
		senicSpotList.add(map);
		advertisingList.add(map);
		advertisingList.add(map);
		advertisingList.add(map);
		resp.setAdvertisingList(advertisingList);
		resp.setCityList(cityList);
		resp.setSenicSpotList(senicSpotList);
		System.out.println(json.beanToString(resp));
		
	}
	
}
