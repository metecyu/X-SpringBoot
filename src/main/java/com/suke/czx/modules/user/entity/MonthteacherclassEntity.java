package com.suke.czx.modules.user.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 月度班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
public class MonthteacherclassEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long mtmcid;
	//月度教师课时主表id
	private Integer monthteacherid;
	//班级编号
	private Integer classid;
	//
	private Integer classhour;

	/**
	 * 设置：
	 */
	public void setMtmcid(Long mtmcid) {
		this.mtmcid = mtmcid;
	}
	/**
	 * 获取：
	 */
	public Long getMtmcid() {
		return mtmcid;
	}
	/**
	 * 设置：月度教师课时主表id
	 */
	public void setMonthteacherid(Integer monthteacherid) {
		this.monthteacherid = monthteacherid;
	}
	/**
	 * 获取：月度教师课时主表id
	 */
	public Integer getMonthteacherid() {
		return monthteacherid;
	}
	/**
	 * 设置：班级编号
	 */
	public void setClassid(Integer classid) {
		this.classid = classid;
	}
	/**
	 * 获取：班级编号
	 */
	public Integer getClassid() {
		return classid;
	}
	/**
	 * 设置：
	 */
	public void setClasshour(Integer classhour) {
		this.classhour = classhour;
	}
	/**
	 * 获取：
	 */
	public Integer getClasshour() {
		return classhour;
	}
}
