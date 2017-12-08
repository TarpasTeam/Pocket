package cn.tarpas.pocket.service;

import java.util.Map;

import cn.tarpas.pocket.po.ScenicSpot;


public interface ScenicSpotService extends BaseService<ScenicSpot> {
	
	Map<String,Object> search(int cityId, String keyword);
}
