package com.suke.czx.modules.user.dao;

import com.suke.czx.modules.user.entity.TclassEntity;
import com.suke.czx.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 16:06:21
 */
@Mapper
public interface TclassDao extends BaseDao<TclassEntity> {

    List<Integer> getExistYearList();


    List<TclassEntity> queryListByYearClassType(TclassEntity tclassEntity);
	
}
