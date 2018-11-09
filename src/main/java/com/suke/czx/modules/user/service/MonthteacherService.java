package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.MonthteacherEntity;

import java.util.List;
import java.util.Map;

/**
 * 班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
public interface MonthteacherService {
	
	MonthteacherEntity queryObject(Long monthteacherid);
	
	List<MonthteacherEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MonthteacherEntity monthteacher);
	
	void update(MonthteacherEntity monthteacher);
	
	void delete(Long monthteacherid);
	
	void deleteBatch(Long[] monthteacherids);
}
