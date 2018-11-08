package com.suke.czx.modules.user.service;

import com.suke.czx.modules.user.entity.TermEntity;

import java.util.List;
import java.util.Map;

/**
 * 期数表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-08 15:55:35
 */
public interface TermService {
	
	TermEntity queryObject(Long termid);
	
	List<TermEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TermEntity term);
	
	void update(TermEntity term);
	
	void delete(Long termid);
	
	void deleteBatch(Long[] termids);
}
