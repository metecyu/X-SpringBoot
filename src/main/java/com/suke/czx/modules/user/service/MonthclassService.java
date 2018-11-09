package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.MonthclassEntity;

import java.util.List;
import java.util.Map;

/**
 * 月度班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
public interface MonthclassService {
	
	MonthclassEntity queryObject(Long monthclassid);
	
	List<MonthclassEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MonthclassEntity monthclass);
	
	void update(MonthclassEntity monthclass);
	
	void delete(Long monthclassid);
	
	void deleteBatch(Long[] monthclassids);
}
