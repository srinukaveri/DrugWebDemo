package com.vir.demo.drug.model;

import org.springframework.stereotype.Component;

//@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * @author Sreeni
 *
 */
@Component
public class DrugSearch {
	
	
	private String pharmacyMasterId;

	
	private String drugId;
	private String drugName;
	private String isActive;
	
	private String mappingId;
	private String isAvailable;
	private Double drugPriceEach;
	private String currency;
	
	public DrugSearch(){}
		
	public DrugSearch(String pharmacyMasterId,String drugId,String drugName,String isActive,String mappingId,String isAvailable,Double drugPriceEach,String currency){
		this.pharmacyMasterId=pharmacyMasterId;
		this.drugId=drugId;
		this.drugName =drugName;
		this.isActive=isActive;
		this.mappingId=mappingId;
		this.isAvailable=isAvailable;
        this.drugPriceEach=drugPriceEach;
        this.currency=currency;
		
	}
	
	
	
	
	public String getPharmacyMasterId() {
		return pharmacyMasterId;
	}
	public void setPharmacyMasterId(String pharmacyMasterId) {
		this.pharmacyMasterId = pharmacyMasterId;
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
	public String getMappingId() {
		return mappingId;
	}
	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
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
	public String getDrugId() {
		return drugId;
	}
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}
	
	
	

}
