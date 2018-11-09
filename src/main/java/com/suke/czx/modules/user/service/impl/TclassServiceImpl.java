package com.suke.czx.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.user.dao.TclassDao;
import com.suke.czx.modules.user.entity.TclassEntity;
import com.suke.czx.modules.user.service.TclassService;



@Service("tclassService")
public class TclassServiceImpl implements TclassService {
	@Autowired
	private TclassDao tclassDao;
	
	@Override
	public TclassEntity queryObject(Long classid){
		return tclassDao.queryObject(classid);
	}
	
	@Override
	public List<TclassEntity> queryList(Map<String, Object> map){
		return tclassDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tclassDao.queryTotal(map);
	}
	
	@Override
	public void save(TclassEntity tclass){
		tclassDao.save(tclass);
	}
	
	@Override
	public void update(TclassEntity tclass){
		tclassDao.update(tclass);
	}
	
	@Override
	public void delete(Long classid){
		tclassDao.delete(classid);
	}
	
	@Override
	public void deleteBatch(Long[] classids){
		tclassDao.deleteBatch(classids);
	}
	
}
