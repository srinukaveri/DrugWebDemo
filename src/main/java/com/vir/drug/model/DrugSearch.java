package com.vir.drug.model;


import org.springframework.stereotype.Component;

/**
 * @author Sreeni
 *
 */

@Component
//@JsonInclude(Include.NON_EMPTY)
//@JsonIgnoreProperties(value={"drugId", "drugName", "isActive"},allowSetters= true, allowGetters= true)
public class DrugSearch {

	

	private String pharmacyMasterId;
	
	//@JsonProperty("drugId")
	private String drugId;
	
	//@JsonProperty("drugName")
	private String drugName;
	
	//@JsonProperty("isActive")
	private String isActive;

	private String mappingId;
	private String isAvailable;
	private Double drugPriceEach;
	private String currency;

	public DrugSearch() {
	}

	
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

	//@JsonIgnore
	public String getPharmacyMasterId() {
		return pharmacyMasterId;
	}
	//@JsonIgnore
	public void setPharmacyMasterId(String pharmacyMasterId) {
		this.pharmacyMasterId = pharmacyMasterId;
	}
	//@JsonIgnore
	public String getDrugName() {
		return drugName;
	}
	//@JsonIgnore
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	//@JsonIgnore
	public String getIsActive() {
		return isActive;
	}
	//@JsonIgnore
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	//@JsonIgnore
	public String getMappingId() {
		return mappingId;
	}
	//@JsonIgnore
	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}
	//@JsonIgnore
	public String getIsAvailable() {
		return isAvailable;
	}
	//@JsonIgnore
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	//@JsonIgnore
	public Double getDrugPriceEach() {
		return drugPriceEach;
	}
	//@JsonIgnore
	public void setDrugPriceEach(Double drugPriceEach) {
		this.drugPriceEach = drugPriceEach;
	}
	//@JsonIgnore
	public String getCurrency() {
		return currency;
	}
	//@JsonIgnore
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	//@JsonIgnore
	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

}
