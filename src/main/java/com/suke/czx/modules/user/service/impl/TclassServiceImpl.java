package com.suke.czx.modules.user.service.impl;

import com.suke.czx.modules.sys.entity.SysMenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

	@Override
	public List<Integer> getExistYearList() {
		return tclassDao.getExistYearList();
	}

	@Override
	public List<TclassEntity> queryListByYearClassType(int year, int classtype) {
		TclassEntity obj =new TclassEntity();
		obj.setYear(year);
		obj.setClasstype(classtype);
		return tclassDao.queryListByYearClassType(obj);
	}
	// @Override

	/**
	 * 获得班级菜单
	 * @param year  年度
	 * @param classtypeGroup 班级类型 10面授  20 短训
	 * @return
	 */
	public List<SysMenuEntity> getClassMenuList(int year, int classtypeGroup) {
		List<SysMenuEntity> outList = new ArrayList();
		List<Integer> years = tclassDao.getExistYearList();
		for (Integer yearOne: years) {
			SysMenuEntity parent = new SysMenuEntity();
			parent.setMenuId(yearOne.longValue());
			parent.setName(yearOne+"");
			parent.setParentId(-1l);
			outList.add(parent);
			if (classtypeGroup==10){
				List<TclassEntity> tclassEntityList = queryListByYearClassType(yearOne, 11);
				for (TclassEntity entity:tclassEntityList ) {
					SysMenuEntity menu = new SysMenuEntity();
					menu.setMenuId(entity.getClassid());
					menu.setName(entity.getClassname());
					menu.setParentId(parent.getMenuId());
					outList.add(menu);
				}
			}else{

			}
		}
		return outList;
	}



}
