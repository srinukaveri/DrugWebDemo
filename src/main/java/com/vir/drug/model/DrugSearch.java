package com.vir.drug.model;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Sreeni
 *
 */

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class DrugSearch {

	

	private String pharmacyMasterId;
	
	@JsonIgnore
	private String drugId;
	@JsonIgnore
	private String drugName;
	@JsonIgnore
	private String isActive;

	private String mappingId;
	private String isAvailable;
	private Double drugPriceEach;
	private String currency;

	public DrugSearch() {
	}

	@JsonIgnore
	public DrugSearch(String pharmacyMasterId, String drugId, String drugName, String isActive, String mappingId,
			String isAvailable, Double drugPriceEach, String currency) {
		this.pharmacyMasterId = pharmacyMasterId;
		this.drugId = drugId;
		this.drugName = drugName;
		this.isActive = isActive;
		this.mappingId = mappingId;
		this.isAvailable = isAvailable;
		this.drugPriceEach = drugPriceEach;
		this.currency = currency;

	}

	@JsonIgnore
	public String getPharmacyMasterId() {
		return pharmacyMasterId;
	}
	@JsonIgnore
	public void setPharmacyMasterId(String pharmacyMasterId) {
		this.pharmacyMasterId = pharmacyMasterId;
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
	@JsonIgnore
	public String getMappingId() {
		return mappingId;
	}
	@JsonIgnore
	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}
	@JsonIgnore
	public String getIsAvailable() {
		return isAvailable;
	}
	@JsonIgnore
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	@JsonIgnore
	public Double getDrugPriceEach() {
		return drugPriceEach;
	}
	@JsonIgnore
	public void setDrugPriceEach(Double drugPriceEach) {
		this.drugPriceEach = drugPriceEach;
	}
	@JsonIgnore
	public String getCurrency() {
		return currency;
	}
	@JsonIgnore
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@JsonIgnore
	public String getDrugId() {
		return drugId;
	}
	@JsonIgnore
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

}
