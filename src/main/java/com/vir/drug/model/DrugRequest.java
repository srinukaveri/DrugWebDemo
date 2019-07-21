package com.vir.drug.model;

import java.util.List;


public class DrugRequest  {

	private String area;
	private List<String> drugName;
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public List<String> getDrugName() {
		return drugName;
	}
	public void setDrugName(List<String> drugName) {
		this.drugName = drugName;
	}
	
	

	}
