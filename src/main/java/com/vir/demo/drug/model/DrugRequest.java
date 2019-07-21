package com.vir.demo.drug.model;

import java.util.List;

public class DrugRequest {
	
	
	private String area;
	private List<String> drugName;
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the drugName
	 */
	public List<String> getDrugName() {
		return drugName;
	}
	/**
	 * @param drugName the drugName to set
	 */
	public void setDrugName(List<String> drugName) {
		this.drugName = drugName;
	}

}
