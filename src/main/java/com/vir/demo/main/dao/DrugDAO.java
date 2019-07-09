package com.vir.demo.main.dao;

import java.util.List;
import java.util.Map;

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
import com.vir.demo.main.entity.PharmacyDrugMaster;
import com.vir.demo.main.entity.UserLoginDetails;
import com.vir.demo.main.exception.LoginValidationException;

@Repository
public class DrugDAO {
	
	@PersistenceContext
	private EntityManager entity;

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
	
	
	@SuppressWarnings("unchecked")
	public List<PharmacyDetails> getPharmacyDetails(){
		List<PharmacyDetails> pharmacyList = null;
		try{
			Query query = entity.createQuery(SQLConstants.GET_PHARMACY_SQL);
			pharmacyList =  query.getResultList();
		}catch(Exception exe){
			exe.printStackTrace();
		}
		return pharmacyList;
	}
	
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
	
	@SuppressWarnings("unchecked")
	public List<PharmacyDrugMaster> getPharmacyDrugMasterDetails(){
		List<PharmacyDrugMaster> pharmacyDrugList = null;
		try{
			String selectSQL = " from PharmacyDrugMaster";
			Query query = entity.createQuery(selectSQL);
			pharmacyDrugList =  query.getResultList();
		}catch(Exception exe){
			exe.printStackTrace();
		}
		return pharmacyDrugList;
	}
	
	
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
