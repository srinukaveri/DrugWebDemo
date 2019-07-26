package com.vir.demo.drug.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sreeni
 *
 */
@Entity
@Table(name="PHARMACY_DRUG_MASTER")
@Embeddable
public class PharmacyDrugMaster implements Serializable {

	private static final long serialVersionUID = -1984768982853176528L;

	@Id
	@Column(name = "MAPPING_ID")
	private String mappingId;

	@Column(name = "PHARMACY_MASTER_ID")
	private String pharmacyMasterId;

	@Column(name = "DRUG_ID")
	private String drugId;

	@Column(name = "IS_AVAILABLE")
	private String isAvailable;

	@Column(name = "DRUG_PRICE_EACH")
	private Double drugPriceEach;

	@Column(name = "CURRENCY")
	private String currency;
	
	
	public PharmacyDrugMaster(){}
	
	public PharmacyDrugMaster(String mappingId,String pharmacyMasterId,String drugId,String isAvailable,
			Double drugPriceEach,String currency){
		this.mappingId = mappingId;
		this.pharmacyMasterId = pharmacyMasterId;
		this.drugId =  drugId;
		this.isAvailable = isAvailable;
		this.drugPriceEach = drugPriceEach;
		this.currency = currency;
	}

	/**
	 * @return the mappingId
	 */
	public String getMappingId() {
		return mappingId;
	}

	/**
	 * @param mappingId the mappingId to set
	 */
	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}

	/**
	 * @return the pharmacyMasterId
	 */
	public String getPharmacyMasterId() {
		return pharmacyMasterId;
	}

	/**
	 * @param pharmacyMasterId the pharmacyMasterId to set
	 */
	public void setPharmacyMasterId(String pharmacyMasterId) {
		this.pharmacyMasterId = pharmacyMasterId;
	}

	/**
	 * @return the drugId
	 */
	public String getDrugId() {
		return drugId;
	}

	/**
	 * @param drugId the drugId to set
	 */
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	/**
	 * @return the isAvailable
	 */
	public String getIsAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * @return the drugPriceEach
	 */
	public Double getDrugPriceEach() {
		return drugPriceEach;
	}

	/**
	 * @param drugPriceEach the drugPriceEach to set
	 */
	public void setDrugPriceEach(Double drugPriceEach) {
		this.drugPriceEach = drugPriceEach;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
	@Override
    public String toString() {
        return "PharmacyDrugMaster{" +
        		" mappingId='" + mappingId + '\'' +
                ", pharmacyMasterId='" + pharmacyMasterId + '\'' +
                ", drugId='" + drugId + '\'' +
                ", isAvailable='" + isAvailable + '\'' +
                ", drugPriceEach=" + drugPriceEach +
                ", currency='" + currency + '\'' +
                '}';
    }
	
}
