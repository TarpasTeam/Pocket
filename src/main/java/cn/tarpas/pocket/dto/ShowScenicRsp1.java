package cn.tarpas.pocket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShowScenicRsp1 {
	@JsonProperty(value="slideshow")
	private String slideshow; //轮播图url
	
	@JsonProperty(value="hotCity_name")
	private String hotCity_name; //热门城市名称
	
	@JsonProperty(value="hotCity_url")
	private String hotCity_url;	//热门城市图片url
	
	@JsonProperty(value="ad_url")
	private String ad_url;	//广告图片url
	
	@JsonProperty(value="ad_link")
	private String ad_link;	//广告链接
	
	@JsonProperty(value="hotSenic_url")
	private String hotSenic_url;	//热门景点图片url
	
	@JsonProperty(value="hotSenic_name")
	private String hotSenic_name;	//热门景点名称
	
	public String getSlideshow() {
		return slideshow;
	}
	public void setSlideshow(String slideshow) {
		this.slideshow = slideshow;
	}
	public String getHotCity_name() {
		return hotCity_name;
	}
	public void setHotCity_name(String hotCity_name) {
		this.hotCity_name = hotCity_name;
	}
	public String getHotCity_url() {
		return hotCity_url;
	}
	public void setHotCity_url(String hotCity_url) {
		this.hotCity_url = hotCity_url;
	}
	public String getAd_url() {
		return ad_url;
	}
	public void setAd_url(String ad_url) {
		this.ad_url = ad_url;
	}
	public String getAd_link() {
		return ad_link;
	}
	public void setAd_link(String ad_link) {
		this.ad_link = ad_link;
	}
	public String getHotSenic_url() {
		return hotSenic_url;
	}
	public void setHotSenic_url(String hotSenic_url) {
		this.hotSenic_url = hotSenic_url;
	}
	public String getHotSenic_name() {
		return hotSenic_name;
	}
	public void setHotSenic_name(String hotSenic_name) {
		this.hotSenic_name = hotSenic_name;
	}
}
