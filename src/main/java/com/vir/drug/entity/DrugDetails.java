package com.vir.drug.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sreeni
 *
 */
@Entity
@Table(name = "DRUG_DETAILS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DrugDetails implements Serializable {

	private static final long serialVersionUID = 2797681336780870561L;

	@Id
	@Column(name = "DRUG_ID")
	@JsonIgnore
	private String drugId;

	@Column(name = "DRUG_NAME")
	@JsonIgnore
	private String drugName;

	@Column(name = "IS_ACTIVE")
	@JsonIgnore
	private String isActive;
	
	@JsonIgnore
	public String getDrugId() {
		return drugId;
	}
	@JsonIgnore
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}
	@JsonIgnore
	public String getDrugName() {
		return drugName;
	}
	@JsonIgnore
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	@JsonIgnore
	public String getIsActive() {
		return isActive;
	}
	
	@JsonIgnore
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
