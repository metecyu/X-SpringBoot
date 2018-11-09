package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.ClassEntity;

import java.util.List;
import java.util.Map;

/**
 * 班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
public interface ClassService {
	
	ClassEntity queryObject(Long classid);
	
	List<ClassEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ClassEntity classObj);
	
	void update(ClassEntity classObj);
	
	void delete(Long classid);
	
	void deleteBatch(Long[] classids);
}
