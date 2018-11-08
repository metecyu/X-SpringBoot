package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.TeacherpriceEntity;

import java.util.List;
import java.util.Map;

/**
 * 教师
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-08 15:55:35
 */
public interface TeacherpriceService {
	
	TeacherpriceEntity queryObject(Long teacherid);
	
	List<TeacherpriceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TeacherpriceEntity teacherprice);
	
	void update(TeacherpriceEntity teacherprice);
	
	void delete(Long teacherid);
	
	void deleteBatch(Long[] teacherids);
}
