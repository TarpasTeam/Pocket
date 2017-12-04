package cn.tarpas.pocket.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ShowScenicReq {
	@JsonProperty(value = "cityId")
	private int cityId;
	
	@JsonProperty(value = "update_time")
	private Date update_time;

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

	@Override
	public String toString() {
		return "[cityId:+"+getCityId()+",update_Time:"+getUpdate_time()+"]";
	}
	
}
