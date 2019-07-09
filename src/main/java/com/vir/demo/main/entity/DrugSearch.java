package com.vir.demo.main.entity;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class DrugSearch {
	
	
	private String pharmacyMasterId;
	private String pharmacyName;
	private String isRegistered;
	private String addressLine;
	private String area;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String latitude;
	private String longtitude;
	private String openTime;
	private String closedTime;
	
	private String drugId;
	private String drugName;
	private String isActive;
	
	private String mappingId;
	private String isAvailable;
	private Double drugPriceEach;
	private String currency;
	
	
	
	public String getPharmacyMasterId() {
		return pharmacyMasterId;
	}
	public void setPharmacyMasterId(String pharmacyMasterId) {
		this.pharmacyMasterId = pharmacyMasterId;
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
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getClosedTime() {
		return closedTime;
	}
	public void setClosedTime(String closedTime) {
		this.closedTime = closedTime;
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
