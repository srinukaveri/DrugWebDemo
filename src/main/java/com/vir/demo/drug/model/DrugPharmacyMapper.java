package com.vir.demo.drug.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DrugPharmacyMapper implements Serializable {

	private static final long serialVersionUID = 2160776883401812664L;
	
	@JsonInclude(Include.NON_NULL)	
	private String pharmacyName;
	@JsonInclude(Include.NON_NULL)	
	private String area;
	@JsonInclude(Include.NON_NULL)	
	private String drugName;
	@JsonInclude(Include.NON_NULL)	
	private String isAvailable;
	@JsonInclude(Include.NON_NULL)	
	private String mappingId;

	 public DrugPharmacyMapper(){}
	 
	 public DrugPharmacyMapper(String mappingId,String isAvailable){
		this.mappingId=mappingId;
		this.isAvailable=isAvailable;
	 }

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getMappingId() {
		return mappingId;
	}

	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}
	 
	 
	
}
