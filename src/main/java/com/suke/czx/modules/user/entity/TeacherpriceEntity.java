package com.suke.czx.modules.user.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 教师
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-08 15:55:35
 */
public class TeacherpriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long teacherid;
	//
	private String teachername;
	//
	private Integer unitprice;
	//
	private Integer sumprice;
	//
	private Integer iscompany;
	//
	private String companyname;
	//
	private String sfz;
	//
	private String bankname;
	//
	private String bankno;
	//
	private String memo;
	//
	private Date createtime;
	//
	private Date updatetime;
	//
	private Integer iseff;
	// 非数据库字段

	private String iscompanyCN;

	public String getIscompanyCN() {
		String str="异常";
		if(iscompany ==null){
			return str;
		}
		if(iscompany.intValue()==0) {
			return "个人";
		}else if(iscompany.intValue()==1){
			return "公司";
		}
		return str;
	}

	public void setIscompanyCN(String iscompanyCN) {
		this.iscompanyCN = iscompanyCN;
	}

	/**
	 * 设置：
	 */
	public void setTeacherid(Long teacherid) {
		this.teacherid = teacherid;
	}
	/**
	 * 获取：
	 */
	public Long getTeacherid() {
		return teacherid;
	}
	/**
	 * 设置：
	 */
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	/**
	 * 获取：
	 */
	public String getTeachername() {
		return teachername;
	}
	/**
	 * 设置：
	 */
	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}
	/**
	 * 获取：
	 */
	public Integer getUnitprice() {
		return unitprice;
	}
	/**
	 * 设置：
	 */
	public void setSumprice(Integer sumprice) {
		this.sumprice = sumprice;
	}
	/**
	 * 获取：
	 */
	public Integer getSumprice() {
		return sumprice;
	}
	/**
	 * 设置：
	 */
	public void setIscompany(Integer iscompany) {
		this.iscompany = iscompany;
	}
	/**
	 * 获取：
	 */
	public Integer getIscompany() {
		return iscompany;
	}
	/**
	 * 设置：
	 */
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	/**
	 * 获取：
	 */
	public String getCompanyname() {
		return companyname;
	}
	/**
	 * 设置：
	 */
	public void setSfz(String sfz) {
		this.sfz = sfz;
	}
	/**
	 * 获取：
	 */
	public String getSfz() {
		return sfz;
	}
	/**
	 * 设置：
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	/**
	 * 获取：
	 */
	public String getBankname() {
		return bankname;
	}
	/**
	 * 设置：
	 */
	public void setBankno(String bankno) {
		this.bankno = bankno;
	}
	/**
	 * 获取：
	 */
	public String getBankno() {
		return bankno;
	}
	/**
	 * 设置：
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：
	 */
	public String getMemo() {
		return memo;
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
