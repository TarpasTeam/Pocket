package cn.tarpas.pocket.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScenicSpotResp {
	
/*	@JsonProperty(value="scenicName")
	private String scenicName;
	
	@JsonProperty(value="head")
	private String head;
	
	@JsonProperty(value="price")
	private String price;
	
	@JsonProperty(value="address")
	private String address;
	
	@JsonProperty(value="grade")
	private String grade;
	
	@JsonProperty(value="heat")
	private String heat;*/
	
	/** 景点列表  */
	@JsonProperty(value="spotList")
	private List<HashMap<String,String>> spotList;
	
	/** 以下字段 
	 *  若搜索的为城市，则需要返回该城市的城市名及城市id 
	 * 	若搜索的不为城市，则返回null
	 * */
	@JsonProperty(value="cityId")
	private String cityId;
	
	@JsonProperty(value="cityName")
	private String cityName;
	
	@JsonProperty(value="cityPicture")
	private String cityPicture;

	public List<HashMap<String, String>> getSpotList() {
		return spotList;
	}

	public void setSpotList(List<HashMap<String, String>> spotList) {
		this.spotList = spotList;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityPicture() {
		return cityPicture;
	}

	public void setCityPicture(String cityPicture) {
		this.cityPicture = cityPicture;
	}
	

}
