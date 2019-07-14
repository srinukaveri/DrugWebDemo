package com.vir.demo.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.vir.demo.main.constants.DrugConstants;
import com.vir.demo.main.constants.ErrorCodes;
import com.vir.demo.main.constants.SQLConstants;
import com.vir.demo.main.entity.DrugDetails;
import com.vir.demo.main.entity.DrugSearch;
import com.vir.demo.main.entity.PharmacyDetails;
import com.vir.demo.main.entity.UserLoginDetails;
import com.vir.demo.main.exception.LoginValidationException;

/**
 * @author Sreeni
 *
 */
@Repository
public class DrugDAO {
	
	@PersistenceContext
	private EntityManager entity;

	/**
	 * Retrieve  the corresponding user details and validate the credentials
	 * @param userName
	 * @param password
	 * @return UserLoginDetails
	 */
	public UserLoginDetails doLogin(String userName, String password){
		UserLoginDetails UserLoginDetails = null;
		try{
			Query query = entity.createQuery(SQLConstants.LOGIN_SQL);
			query.setParameter(SQLConstants.USER_NAME, userName);
			UserLoginDetails = (UserLoginDetails) query.getSingleResult();
		}catch(NoResultException exe){
			throw new LoginValidationException(DrugConstants.IN_VALID_USER_ID, ErrorCodes.USER_ID_VALIDATION_ERROR_CODE);
		}
		return UserLoginDetails;
	}
	
	
	/**
	 * Fetch the details of the pharmacy
	 * @return PharmacyDetails
	 */
	@SuppressWarnings("unchecked")
	public List<PharmacyDetails> getPharmacyDetails(String area){
		List<PharmacyDetails> pharmacyList = null;
		try{
			Query query = entity.createQuery(SQLConstants.GET_PHARMACY_SQL);
			query.setParameter(SQLConstants.AREA,area);
			pharmacyList =  query.getResultList();
		}catch(Exception exe){
			exe.printStackTrace();
		}
		return pharmacyList;
	}
	
	/**
	 * fetch the drugdetails
	 * @return DrugDetails
	 */
	@SuppressWarnings("unchecked")
	public List<DrugDetails> getDrugDetails(){
		List<DrugDetails> drugList = null;
		try{
			Query query = entity.createQuery(SQLConstants.GET_DRUG_SQL);
			drugList =  query.getResultList();
		}catch(Exception exe){
			exe.printStackTrace();
		}
		return drugList;
	}
	
	/**
	 * fetch the master details of the pharmacy
	 * @return PharmacyDrugMaster
	 */
	@SuppressWarnings("unchecked")
	public List<DrugSearch>  getDrugListMaster(List<String> pharmacyId,List<String> drugNameList){
		List<DrugSearch> drugListMaster = null;
		try{
			Query query = entity.createQuery(SQLConstants.DRUG_SEARCH_SQL);
			query.setParameter(SQLConstants.PHARMACY_ID,pharmacyId);
			query.setParameter(SQLConstants.DRUG_NAME,drugNameList);
			drugListMaster =  query.getResultList();
		}catch(Exception exe){
			exe.printStackTrace();
		}
		return drugListMaster;
	}
	
	
	/**
	 * fetch the pharmacy details of the drug which i s available
	 * @param drugName
	 * @return DrugSearch
	 */
	@SuppressWarnings("unchecked")
	public List<DrugSearch> getPharmacyDrugDetails(String drugName){
		List<DrugSearch> pharmacyDrugList = null;
		try{
			Query query = entity.createQuery(SQLConstants.DRUG_SEARCH_SQL);
			query.setParameter(SQLConstants.DRUG_NAME,drugName);
			pharmacyDrugList =  query.getResultList();
		}catch(Exception exe){
			exe.printStackTrace();
		}
		return pharmacyDrugList;
	}

}
