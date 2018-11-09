package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.ClassDao;
import com.suke.czx.modules.user.entity.ClassEntity;
import com.suke.czx.modules.user.service.ClassService;



@Service("classService")
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassDao classDao;
	
	@Override
	public ClassEntity queryObject(Long classid){
		return classDao.queryObject(classid);
	}
	
	@Override
	public List<ClassEntity> queryList(Map<String, Object> map){
		return classDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return classDao.queryTotal(map);
	}
	
	@Override
	public void save(ClassEntity classObj){
		classDao.save(classObj);
	}
	
	@Override
	public void update(ClassEntity classObj){
		classDao.update(classObj);
	}
	
	@Override
	public void delete(Long classid){
		classDao.delete(classid);
	}
	
	@Override
	public void deleteBatch(Long[] classids){
		classDao.deleteBatch(classids);
	}
	
}
