package com.vir.demo.main.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Sreeni
 *
 */
@Entity
@Table(name="PHARMACY_DETAILS")
public class PharmacyDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHARMACY_MASTER_ID")
	private String pharmacyMasterId;
	
	@Column(name="PHARMACY_NAME")
	private String pharmacyName;
	
	@Column(name="IS_REGISTERED")
	private String isRegistered;
	
	@Column(name="ADDRESS_LINE")
	private String addressLine;
	
	@Column(name="AREA")
	private String area;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="LATITUDE")
	private String latitude;
	
	@Column(name="LONGITUDE")
	private String longtitude;
	
	@Column(name="OPEN_TIME")
	private String openTime;
	
	@Column(name="CLOSED_TIME")
	private String closedTime;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="WEBSITE")
	private String webSite;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

}
