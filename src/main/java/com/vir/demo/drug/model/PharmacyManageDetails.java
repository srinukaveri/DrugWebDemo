package com.vir.demo.drug.model;

import java.io.Serializable;

public class PharmacyManageDetails implements Serializable{
	
	
	private static final long serialVersionUID = 7785160023675675490L;
	
	private String pharmacyName;
	private String isRegistered;
	private String area;
	
	public PharmacyManageDetails() {}
	
	
	public PharmacyManageDetails(String pharmacyName,String isRegistered,String area){
		this.pharmacyName=pharmacyName;
		this.isRegistered=isRegistered;
		this.area=area;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}


	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}


	public String getIsRegistered() {
		return isRegistered;
	}


	public void setIsRegistered(String isRegistered) {
		this.isRegistered = isRegistered;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}
	
	
	
}
