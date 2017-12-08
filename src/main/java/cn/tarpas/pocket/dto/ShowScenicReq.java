package cn.tarpas.pocket.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ShowScenicReq {
	@JsonProperty(value = "cityId")
	private int cityId;
	
	@JsonProperty(value = "update_time")
	private Date update_time;
	
	@JsonProperty(value = "keyword")
	private String keyword;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


	
	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "[cityId=" + cityId + ", update_time=" + update_time + ", keyword=" + keyword + "]";
	}
	
}
