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
@Table(name="PHARMACY_DRUG_MASTER")
public class PharmacyDrugMaster implements Serializable{
	
	private static final long serialVersionUID = -1984768982853176528L;

	public String getMappingId() {
		return mappingId;
	}

	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}

	

	@Id
	@Column(name="MAPPING_ID")
	private String mappingId;
	
	@Column(name="PHARMACY_MASTER_ID")
	private String pharmacyMasterId;
	
	@Column(name="DRUG_ID")
	private String drugId;
	
	@Column(name="IS_AVAILABLE")
	private String isAvailable;
	
	@Column(name="DRUG_PRICE_EACH")
	private Double drugPriceEach;
	
	@Column(name="CURRENCY")
	private String currency;

	
	
	public String getPharmacyMasterId() {
		return pharmacyMasterId;
	}

	public void setPharmacyMasterId(String pharmacyMasterId) {
		this.pharmacyMasterId = pharmacyMasterId;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Double getDrugPriceEach() {
		return drugPriceEach;
	}

	public void setDrugPriceEach(Double drugPriceEach) {
		this.drugPriceEach = drugPriceEach;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
}
