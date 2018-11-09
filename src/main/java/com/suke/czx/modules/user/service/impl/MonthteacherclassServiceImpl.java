package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.MonthteacherclassDao;
import com.suke.czx.modules.user.entity.MonthteacherclassEntity;
import com.suke.czx.modules.user.service.MonthteacherclassService;



@Service("monthteacherclassService")
public class MonthteacherclassServiceImpl implements MonthteacherclassService {
	@Autowired
	private MonthteacherclassDao monthteacherclassDao;
	
	@Override
	public MonthteacherclassEntity queryObject(Long mtmcid){
		return monthteacherclassDao.queryObject(mtmcid);
	}
	
	@Override
	public List<MonthteacherclassEntity> queryList(Map<String, Object> map){
		return monthteacherclassDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return monthteacherclassDao.queryTotal(map);
	}
	
	@Override
	public void save(MonthteacherclassEntity monthteacherclass){
		monthteacherclassDao.save(monthteacherclass);
	}
	
	@Override
	public void update(MonthteacherclassEntity monthteacherclass){
		monthteacherclassDao.update(monthteacherclass);
	}
	
	@Override
	public void delete(Long mtmcid){
		monthteacherclassDao.delete(mtmcid);
	}
	
	@Override
	public void deleteBatch(Long[] mtmcids){
		monthteacherclassDao.deleteBatch(mtmcids);
	}
	
}
