package com.wndxf.invitation.persistence.model;

import java.util.Date;
import java.io.Serializable;


public class Blessing implements Serializable {
	private Integer id;
	private String name;
	private String pnum;
	private String blessStr;
	private Date time;
	private Integer userId;

	public Integer getId() {
 		return this.id;
	}
	
	public void setId(Integer id) {
 		this.id = id;
	}

	public String getName() {
 		return this.name;
	}
	
	public void setName(String name) {
 		this.name = name;
	}

	public String getPnum() {
 		return this.pnum;
	}
	
	public void setPnum(String pnum) {
 		this.pnum = pnum;
	}

	public String getBlessStr() {
 		return this.blessStr;
	}
	
	public void setBlessStr(String blessStr) {
 		this.blessStr = blessStr;
	}

	public Date getTime() {
 		return this.time;
	}
	
	public void setTime(Date time) {
 		this.time = time;
	}

	public Integer getUserId() {
 		return this.userId;
	}
	
	public void setUserId(Integer userId) {
 		this.userId = userId;
	}
}
