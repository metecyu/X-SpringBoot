package com.suke.czx.modules.user.service;

import com.suke.czx.modules.sys.entity.SysMenuEntity;
import com.suke.czx.modules.user.entity.TclassEntity;

import java.util.List;
import java.util.Map;

/**
 * 班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 16:06:21
 */
public interface TclassService {
	
	TclassEntity queryObject(Long classid);
	
	List<TclassEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TclassEntity tclass);
	
	void update(TclassEntity tclass);
	
	void delete(Long classid);
	
	void deleteBatch(Long[] classids);

	List<Integer> getExistYearList();
	List<TclassEntity> queryListByYearClassType(int year,int classtype);
	public List<SysMenuEntity> getClassMenuList(int year, int classtypeGroup);
}
