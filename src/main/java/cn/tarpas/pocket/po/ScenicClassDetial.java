package cn.tarpas.pocket.po;

public class ScenicClassDetial {
    private Integer scenicClassDetialId;

    private String scenicClassDetialName;

    private Integer scenicClassId;

    private Boolean isDeleted;

    public Integer getScenicClassDetialId() {
        return scenicClassDetialId;
    }

    public void setScenicClassDetialId(Integer scenicClassDetialId) {
        this.scenicClassDetialId = scenicClassDetialId;
    }

    public String getScenicClassDetialName() {
        return scenicClassDetialName;
    }

    public void setScenicClassDetialName(String scenicClassDetialName) {
        this.scenicClassDetialName = scenicClassDetialName == null ? null : scenicClassDetialName.trim();
    }

    public Integer getScenicClassId() {
        return scenicClassId;
    }

    public void setScenicClassId(Integer scenicClassId) {
        this.scenicClassId = scenicClassId;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}