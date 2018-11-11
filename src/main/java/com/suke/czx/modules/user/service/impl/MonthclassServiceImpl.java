package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.MonthclassDao;
import com.suke.czx.modules.user.entity.MonthclassEntity;
import com.suke.czx.modules.user.service.MonthclassService;



@Service("monthclassService")
public class MonthclassServiceImpl implements MonthclassService {
	@Autowired
	private MonthclassDao monthclassDao;
	
	@Override
	public MonthclassEntity queryObject(Long monthclassid){
		return monthclassDao.queryObject(monthclassid);
	}
	
	@Override
	public List<MonthclassEntity> queryList(Map<String, Object> map){
		return monthclassDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return monthclassDao.queryTotal(map);
	}
	
	@Override
	public void save(MonthclassEntity monthclass){
		monthclassDao.save(monthclass);
	}
	
	@Override
	public void update(MonthclassEntity monthclass){
		monthclassDao.update(monthclass);
	}
	
	@Override
	public void delete(Long monthclassid){
		monthclassDao.delete(monthclassid);
	}
	
	@Override
	public void deleteBatch(Long[] monthclassids){
		monthclassDao.deleteBatch(monthclassids);
	}
	@Override
	public List<MonthclassEntity> queryListByTermid(Long termid){
		return monthclassDao.queryListByTermid(termid);
	}
	
}
