package com.suke.czx.modules.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
public class MonthteacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long monthteacherid;
	//期数编号
	private Integer termid;
	//11:AF, 12:CF, 21:免费短训,22:收费短训
	private Integer teacherid;
	//
	private BigDecimal unitprice;
	//
	private Integer sumhour;
	//
	private BigDecimal sumprice;
	//
	private Date createtime;
	//
	private Date updatetime;
	//
	private Integer iseff;
	//
	private BigDecimal sumfactprice;

	// 非数据库
	private String teachername;

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	/**
	 * 设置：
	 */
	public void setMonthteacherid(Long monthteacherid) {
		this.monthteacherid = monthteacherid;
	}
	/**
	 * 获取：
	 */
	public Long getMonthteacherid() {
		return monthteacherid;
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
	 * 设置：11:AF, 12:CF, 21:免费短训,22:收费短训
	 */
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}
	/**
	 * 获取：11:AF, 12:CF, 21:免费短训,22:收费短训
	 */
	public Integer getTeacherid() {
		return teacherid;
	}
	/**
	 * 设置：
	 */
	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getUnitprice() {
		return unitprice;
	}
	/**
	 * 设置：
	 */
	public void setSumhour(Integer sumhour) {
		this.sumhour = sumhour;
	}
	/**
	 * 获取：
	 */
	public Integer getSumhour() {
		return sumhour;
	}
	/**
	 * 设置：
	 */
	public void setSumprice(BigDecimal sumprice) {
		this.sumprice = sumprice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getSumprice() {
		return sumprice;
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

	public BigDecimal getSumfactprice() {
		return sumfactprice;
	}

	public void setSumfactprice(BigDecimal sumfactprice) {
		this.sumfactprice = sumfactprice;
	}

}
