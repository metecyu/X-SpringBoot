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
public class MonthclassEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long monthclassid;
	//期数编号
	private Integer termid;
	//班级编号
	private Integer classid;
	//
	private Date createtime;
	//
	private Date updatetime;
	//
	private Integer iseff;

	// 非本表字段
	private String classname;

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
	// end 非本表字段

	/**
	 * 设置：
	 */
	public void setMonthclassid(Long monthclassid) {
		this.monthclassid = monthclassid;
	}
	/**
	 * 获取：
	 */
	public Long getMonthclassid() {
		return monthclassid;
	}
	/**
	 * 设置：期数编号
	 */
	public void setTermid(Integer termid) {
		this.termid = termid;
	}
	/**
	 * 获取：期数编号
	 */
	public Integer getTermid() {
		return termid;
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
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：
	 */
	public void setIseff(Integer iseff) {
		this.iseff = iseff;
	}
	/**
	 * 获取：
	 */
	public Integer getIseff() {
		return iseff;
	}
}
