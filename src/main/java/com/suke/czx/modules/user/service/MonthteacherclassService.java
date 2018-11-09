package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.MonthteacherclassEntity;

import java.util.List;
import java.util.Map;

/**
 * 月度班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
public interface MonthteacherclassService {
	
	MonthteacherclassEntity queryObject(Long mtmcid);
	
	List<MonthteacherclassEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MonthteacherclassEntity monthteacherclass);
	
	void update(MonthteacherclassEntity monthteacherclass);
	
	void delete(Long mtmcid);
	
	void deleteBatch(Long[] mtmcids);
}
