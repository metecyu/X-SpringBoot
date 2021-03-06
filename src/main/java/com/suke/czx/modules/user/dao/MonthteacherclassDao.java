package com.suke.czx.modules.user.dao;

import com.suke.czx.modules.user.entity.MonthclassEntity;
import com.suke.czx.modules.user.entity.MonthteacherclassEntity;
import com.suke.czx.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 月度班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
@Mapper
public interface MonthteacherclassDao extends BaseDao<MonthteacherclassEntity> {
    List<MonthteacherclassEntity> queryListByMonthteacherid(Long monthteacherid);
}
