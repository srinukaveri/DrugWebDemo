package com.vir.drug.model;

import java.io.Serializable;
import java.util.List;


public class DrugRequest  {

	//private static final long serialVersionUID = 1548102846183592891L;
	private String pharmacyArea;
	private List<String> drugNameInput;
	
	public String getPharmacyArea() {
		return pharmacyArea;
	}
	public void setPharmacyArea(String pharmacyArea) {
		this.pharmacyArea = pharmacyArea;
	}
	public List<String> getDrugNameInput() {
		return drugNameInput;
	}
	public void setDrugNameInput(List<String> drugNameInput) {
		this.drugNameInput = drugNameInput;
	}
	
	

	}
