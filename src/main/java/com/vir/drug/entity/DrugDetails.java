package com.vir.drug.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;



/**
 * @author Sreeni
 *
 */
@Entity
@Table(name = "DRUG_DETAILS")
public class DrugDetails implements Serializable {

	private static final long serialVersionUID = 2797681336780870561L;

	@Id
	@Column(name = "DRUG_ID")
	private String drugId;

	@Column(name = "DRUG_NAME")
	private String drugName;

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
