package com.vir.drug.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * @author Sreeni
 *
 */
@Entity
@Table(name = "DRUG_DETAILS")
@JsonIgnoreProperties(value={"drugId", "drugName", "isActive"},allowSetters= true, allowGetters= true)
public class DrugDetails implements Serializable {

	private static final long serialVersionUID = 2797681336780870561L;

	@Id
	@Column(name = "DRUG_ID")
	@JsonProperty("drugId")
	private String drugId;

	@Column(name = "DRUG_NAME")
	@JsonProperty("drugName")
	private String drugName;
	
	@JsonProperty("isActive")
	@Column(name = "IS_ACTIVE")
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
