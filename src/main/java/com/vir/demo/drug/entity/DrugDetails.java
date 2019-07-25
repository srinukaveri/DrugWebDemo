package com.vir.demo.drug.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sreeni
 *
 */
@Entity
@Table(name="DRUG_DETAILS")
public class DrugDetails implements Serializable{
	
	private static final long serialVersionUID = 8125389399525055138L;

	@Id
	@Column(name="DRUG_ID")
	private String drugId;
	
	@Column(name="DRUG_NAME")
	private String drugName;
	
	@Column(name="IS_ACTIVE")
	private String isActive;



	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
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
