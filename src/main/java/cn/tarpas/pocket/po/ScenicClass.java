package cn.tarpas.pocket.po;

public class ScenicClass {
    private Integer scenicClassId;

    private String scenicClssName;

    private Boolean isDeleted;

    public Integer getScenicClassId() {
        return scenicClassId;
    }

    public void setScenicClassId(Integer scenicClassId) {
        this.scenicClassId = scenicClassId;
    }

    public String getScenicClssName() {
        return scenicClssName;
    }

    public void setScenicClssName(String scenicClssName) {
        this.scenicClssName = scenicClssName == null ? null : scenicClssName.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}