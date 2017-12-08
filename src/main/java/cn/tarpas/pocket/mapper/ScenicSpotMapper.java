package cn.tarpas.pocket.mapper;

import java.util.List;
import java.util.Map;

import cn.tarpas.pocket.po.ScenicSpot;

public interface ScenicSpotMapper extends IMapper<ScenicSpot> {
	
	List<ScenicSpot> search(Map<String,Object> map);
	
} 