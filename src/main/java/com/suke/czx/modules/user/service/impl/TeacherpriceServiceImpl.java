package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.TeacherpriceDao;
import com.suke.czx.modules.user.entity.TeacherpriceEntity;
import com.suke.czx.modules.user.service.TeacherpriceService;



@Service("teacherpriceService")
public class TeacherpriceServiceImpl implements TeacherpriceService {
	@Autowired
	private TeacherpriceDao teacherpriceDao;
	
	@Override
	public TeacherpriceEntity queryObject(Long teacherid){
		return teacherpriceDao.queryObject(teacherid);
	}
	
	@Override
	public List<TeacherpriceEntity> queryList(Map<String, Object> map){
		return teacherpriceDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return teacherpriceDao.queryTotal(map);
	}
	
	@Override
	public void save(TeacherpriceEntity teacherprice){
		teacherpriceDao.save(teacherprice);
	}
	
	@Override
	public void update(TeacherpriceEntity teacherprice){
		teacherpriceDao.update(teacherprice);
	}
	
	@Override
	public void delete(Long teacherid){
		teacherpriceDao.delete(teacherid);
	}
	
	@Override
	public void deleteBatch(Long[] teacherids){
		teacherpriceDao.deleteBatch(teacherids);
	}
	
}
