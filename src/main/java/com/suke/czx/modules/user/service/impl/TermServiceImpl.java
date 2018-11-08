package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.TermDao;
import com.suke.czx.modules.user.entity.TermEntity;
import com.suke.czx.modules.user.service.TermService;



@Service("termService")
public class TermServiceImpl implements TermService {
	@Autowired
	private TermDao termDao;
	
	@Override
	public TermEntity queryObject(Long termid){
		return termDao.queryObject(termid);
	}
	
	@Override
	public List<TermEntity> queryList(Map<String, Object> map){
		return termDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return termDao.queryTotal(map);
	}
	
	@Override
	public void save(TermEntity term){
		termDao.save(term);
	}
	
	@Override
	public void update(TermEntity term){
		termDao.update(term);
	}
	
	@Override
	public void delete(Long termid){
		termDao.delete(termid);
	}
	
	@Override
	public void deleteBatch(Long[] termids){
		termDao.deleteBatch(termids);
	}
	
}
