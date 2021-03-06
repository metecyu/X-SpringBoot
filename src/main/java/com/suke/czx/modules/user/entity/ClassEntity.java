package com.suke.czx.modules.user.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
public class ClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long classid;
	//班级名称
	private Integer classname;
	//11:AF, 12:CF, 21:免费短训,22:收费短训
	private Integer classtype;
	//
	private Date createtime;
	//
	private Date updatetime;
	//
	private Integer iseff;

	/**
	 * 设置：
	 */
	public void setClassid(Long classid) {
		this.classid = classid;
	}
	/**
	 * 获取：
	 */
	public Long getClassid() {
		return classid;
	}
	/**
	 * 设置：班级名称
	 */
	public void setClassname(Integer classname) {
		this.classname = classname;
	}
	/**
	 * 获取：班级名称
	 */
	public Integer getClassname() {
		return classname;
	}
	/**
	 * 设置：11:AF, 12:CF, 21:免费短训,22:收费短训
	 */
	public void setClasstype(Integer classtype) {
		this.classtype = classtype;
	}
	/**
	 * 获取：11:AF, 12:CF, 21:免费短训,22:收费短训
	 */
	public Integer getClasstype() {
		return classtype;
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
