package com.suke.czx.modules.user.dao;

import com.suke.czx.modules.user.entity.TermEntity;
import com.suke.czx.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 期数表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-08 15:55:35
 */
@Mapper
public interface TermDao extends BaseDao<TermEntity> {
	
}
