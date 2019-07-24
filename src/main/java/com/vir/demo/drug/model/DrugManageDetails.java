/**
 * 
 */
package com.vir.demo.drug.model;

import org.springframework.stereotype.Component;

/**
 * @author C-PN16
 *
 */

public class DrugManageDetails {
	private String drugName;
	private String isActive;
	
	
	public DrugManageDetails(String drugName,String isActive){
		this.drugName=drugName;
		this.isActive=isActive;
	}
	
	/**
	 * @return the drugName
	 */
	public String getDrugName() {
		return drugName;
	}
	/**
	 * @param drugName the drugName to set
	 */
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	

}
