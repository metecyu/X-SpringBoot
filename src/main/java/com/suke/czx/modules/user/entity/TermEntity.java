package com.suke.czx.modules.user.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 期数表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-08 15:55:35
 */
public class TermEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long termid;
	//
	private Integer year;
	//
	private Integer month;
	//
	private Integer termtype;
	//
	private Date createtime;
	//
	private Date updatetime;
	//
	private Integer iseff;
	// 非数据库字段
	private String termtypeCN;

	public String getTermtypeCN() {
		if(termtype.intValue()==1) {
			return "面授";
		}else if(termtype.intValue()==2){
			return "短训";
		}
		return "异常";
	}

	public void setTermtypeCN(String termtypeCN) {
		this.termtypeCN = termtypeCN;
	}

	/**
	 * 设置：
	 */
	public void setTermid(Long termid) {
		this.termid = termid;
	}
	/**
	 * 获取：
	 */
	public Long getTermid() {
		return termid;
	}
	/**
	 * 设置：
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}
	/**
	 * 获取：
	 */
	public Integer getMonth() {
		return month;
	}
	/**
	 * 设置：
	 */
	public void setTermtype(Integer termtype) {
		this.termtype = termtype;
	}
	/**
	 * 获取：
	 */
	public Integer getTermtype() {
		return termtype;
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
