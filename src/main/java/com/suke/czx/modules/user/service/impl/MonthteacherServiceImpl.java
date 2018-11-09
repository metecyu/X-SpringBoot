package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.MonthteacherDao;
import com.suke.czx.modules.user.entity.MonthteacherEntity;
import com.suke.czx.modules.user.service.MonthteacherService;



@Service("monthteacherService")
public class MonthteacherServiceImpl implements MonthteacherService {
	@Autowired
	private MonthteacherDao monthteacherDao;
	
	@Override
	public MonthteacherEntity queryObject(Long monthteacherid){
		return monthteacherDao.queryObject(monthteacherid);
	}
	
	@Override
	public List<MonthteacherEntity> queryList(Map<String, Object> map){
		return monthteacherDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return monthteacherDao.queryTotal(map);
	}
	
	@Override
	public void save(MonthteacherEntity monthteacher){
		monthteacherDao.save(monthteacher);
	}
	
	@Override
	public void update(MonthteacherEntity monthteacher){
		monthteacherDao.update(monthteacher);
	}
	
	@Override
	public void delete(Long monthteacherid){
		monthteacherDao.delete(monthteacherid);
	}
	
	@Override
	public void deleteBatch(Long[] monthteacherids){
		monthteacherDao.deleteBatch(monthteacherids);
	}
	
}
