package com.tech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VaccinationCenter {

	@Id
	private Integer id;
	private String centerName;
	private String centerAddress;
	public VaccinationCenter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VaccinationCenter(Integer id, String centerName, String centerAddress) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerAddress = centerAddress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	@Override
	public String toString() {
		return "VaccinationCenter [id=" + id + ", centerName=" + centerName + ", centerAddress=" + centerAddress + "]";
	}
	
}
