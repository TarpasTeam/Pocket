package cn.tarpas.pocket.po;

public class ScenicSpot {
   

	private Integer scenicId;

    private String scenicName;

    private String head;

    private String detailImage;

    private String intro;

    private Integer price;

    private String address;

    private String detailAddress;

    private String phone;

    private Float grade;

    private Long heat;

    private Integer cityId;

    private Integer scenicClassDetialId;

    private Boolean isPopular;

    private String picture;

    private Boolean isDeleted;

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }


    public String getScenicName() {
		return scenicName;
	}

	public void setScenicName(String scenicName) {
		this.scenicName = scenicName;
	}

	public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public String getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(String detailImage) {
        this.detailImage = detailImage == null ? null : detailImage.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Long getHeat() {
        return heat;
    }

    public void setHeat(Long heat) {
        this.heat = heat;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getScenicClassDetialId() {
        return scenicClassDetialId;
    }

    public void setScenicClassDetialId(Integer scenicClassDetialId) {
        this.scenicClassDetialId = scenicClassDetialId;
    }

    public Boolean getIsPopular() {
        return isPopular;
    }

    public void setIsPopular(Boolean isPopular) {
        this.isPopular = isPopular;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    @Override
   	public String toString() {
   		return "ScenicSpot [scenicId=" + scenicId + ", scenicName=" + scenicName + ", head=" + head + ", detailImage="
   				+ detailImage + ", intro=" + intro + ", price=" + price + ", address=" + address + ", detailAddress="
   				+ detailAddress + ", phone=" + phone + ", grade=" + grade + ", heat=" + heat + ", cityId=" + cityId
   				+ ", scenicClassDetialId=" + scenicClassDetialId + ", isPopular=" + isPopular + ", picture=" + picture
   				+ ", isDeleted=" + isDeleted + "]";
   	}
}