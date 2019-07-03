package com.vir.demo.main.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DRUG_DETAILS")
public class DrugDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_ID")
	private String drugid;
	
	@Column(name="DRUG_NAME")
	private String drugName;
	
	@Column(name="IS_ACTIVE")
	private String isActive;

	public String getDrugid() {
		return drugid;
	}

	public void setDrugid(String drugid) {
		this.drugid = drugid;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	

}
