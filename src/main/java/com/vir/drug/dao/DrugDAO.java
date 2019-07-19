package com.vir.drug.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.vir.drug.constants.SQLConstants;
import com.vir.drug.entity.DrugDetails;
import com.vir.drug.entity.PharmacyDetails;
import com.vir.drug.model.DrugSearch;

/**
 * @author Sreeni
 *
 */
@Repository
public class DrugDAO implements IDrugDAO {

	@PersistenceContext
	private EntityManager entity;

	/**
	 * Fetch the details of the pharmacy
	 * 
	 * @return PharmacyDetails
	 */
	@SuppressWarnings("unchecked")
	public List<PharmacyDetails> getPharmacyDetails(String area) {
		List<PharmacyDetails> pharmacyList = null;
		try {
			Query query = entity.createQuery(SQLConstants.GET_PHARMACY_SQL);
			query.setParameter(SQLConstants.AREA, area);
			pharmacyList = query.getResultList();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return pharmacyList;
	}

	/**
	 * fetch the drugdetails
	 * 
	 * @return DrugDetails
	 */
	@SuppressWarnings("unchecked")
	public List<DrugDetails> getDrugDetails() {
		List<DrugDetails> drugList = null;
		try {
			Query query = entity.createQuery(SQLConstants.GET_DRUG_SQL);
			drugList = query.getResultList();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return drugList;
	}

	/**
	 * fetch the master details of the pharmacy
	 * 
	 * @return PharmacyDrugMaster
	 */
	@SuppressWarnings("unchecked")
	public List<DrugSearch> getDrugListMaster(List<String> pharmacyId, List<String> drugNameList) {
		List<DrugSearch> drugListMaster = null;
		try {
			Query query = entity.createQuery(SQLConstants.DRUG_SEARCH_SQL);
			query.setParameter(SQLConstants.PHARMACY_ID, pharmacyId);
			query.setParameter(SQLConstants.DRUG_NAME, drugNameList);
			drugListMaster = query.getResultList();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return drugListMaster;
	}

	/**
	 * fetch the pharmacy details of the drug which i s available
	 * 
	 * @param drugName
	 * @return DrugSearch
	 */
	@SuppressWarnings("unchecked")
	public List<DrugSearch> getPharmacyDrugDetails(String drugName) {
		List<DrugSearch> pharmacyDrugList = null;
		try {
			Query query = entity.createQuery(SQLConstants.DRUG_SEARCH_SQL);
			query.setParameter(SQLConstants.DRUG_NAME, drugName);
			pharmacyDrugList = query.getResultList();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		return pharmacyDrugList;
	}

}
