package com.suke.czx.modules.user.dao;

import com.suke.czx.modules.user.entity.MonthteacherEntity;
import com.suke.czx.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
@Mapper
public interface MonthteacherDao extends BaseDao<MonthteacherEntity> {

    List<MonthteacherEntity> queryListView(Map<String, Object> map);

	
}
