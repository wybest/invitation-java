package com.wndxf.invitation.persistence.model;
import java.io.Serializable;


public class WyPower implements Serializable {
	private Integer id;
	private String adminName;
	private String adminPassword;
	private Integer price;

	public Integer getId() {
 		return this.id;
	}
	
	public void setId(Integer id) {
 		this.id = id;
	}

	public String getAdminName() {
 		return this.adminName;
	}
	
	public void setAdminName(String adminName) {
 		this.adminName = adminName;
	}

	public String getAdminPassword() {
 		return this.adminPassword;
	}
	
	public void setAdminPassword(String adminPassword) {
 		this.adminPassword = adminPassword;
	}

	public Integer getPrice() {
 		return this.price;
	}
	
	public void setPrice(Integer price) {
 		this.price = price;
	}
}
