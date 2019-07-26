package com.vir.demo.drug.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.vir.demo.drug.constants.DrugConstants;
import com.vir.demo.drug.constants.ErrorCodes;
import com.vir.demo.drug.constants.SQLConstants;
import com.vir.demo.drug.entity.DrugDetails;
import com.vir.demo.drug.entity.PharmacyDetails;
import com.vir.demo.drug.entity.PharmacyDrugMaster;
import com.vir.demo.drug.entity.UserLoginDetails;
import com.vir.demo.drug.exception.DrugMapperValidationException;
import com.vir.demo.drug.exception.LoginValidationException;
import com.vir.demo.drug.model.DrugManageDetails;
import com.vir.demo.drug.model.DrugPharmacyMapper;
import com.vir.demo.drug.model.DrugSearch;
import com.vir.demo.drug.model.PharmacyManageDetails;

/**
 * @author Sreeni
 *
 */
@Repository
@Transactional
public class DrugDAO implements IDrugDAO {

	@PersistenceContext
	private EntityManager entity;

	/**
	 * Retrieve the corresponding user details and validate the credentials
	 * 
	 * @param userName
	 * @param password
	 * @return UserLoginDetails
	 */
	@Override
	public UserLoginDetails doLogin(String userName, String password) {
		UserLoginDetails UserLoginDetails = null;
		try {
			Query query = entity.createQuery(SQLConstants.LOGIN_SQL);
			query.setParameter(SQLConstants.USER_NAME, userName);
			UserLoginDetails = (UserLoginDetails) query.getSingleResult();
		} catch (NoResultException exe) {
			throw new LoginValidationException(DrugConstants.IN_VALID_USER_ID,
					ErrorCodes.USER_ID_VALIDATION_ERROR_CODE);
		}
		return UserLoginDetails;
	}

	/**
	 * Fetch the details of the pharmacy
	 * 
	 * @return PharmacyDetails
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PharmacyDetails> getPharmacyDetails(String area) {
		List<PharmacyDetails> pharmacyList = null;
		Query query = null;
		try {
			if (!DrugConstants.ALL.equals(area)) {
				query = entity.createQuery(SQLConstants.GET_PHARMACY_SQL);
				query.setParameter(SQLConstants.AREA, area);
			} else {
				query = entity.createQuery(SQLConstants.GET_ALL_PHARMACY_SQL);
			}
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
	@Override
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
	@Override
	public List<DrugSearch> getDrugListMaster(List<String> pharmacyId, List<String> drugNameList) {
		List<DrugSearch> drugListMaster = null;
		try {
			Query query = entity.createQuery(SQLConstants.DRUG_SEARCH_SQL);
			query.setParameter(SQLConstants.PHARMACY_ID, pharmacyId);
			query.setParameter(SQLConstants.DRUG_NAME, drugNameList);
			drugListMaster = query.getResultList();
		} catch (Exception exe) {
			throw new DrugMapperValidationException(DrugConstants.SERVICE_ERROR_MSG, ErrorCodes.SERVICE_ERROR_CODE);
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
	@Override
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

	public String saveDrug(DrugDetails drugDetails) {
		entity.persist(drugDetails);
		return "Drug Saved Successgully";
	}

	public String getLatestDrugId() {
		Query query = entity.createQuery(SQLConstants.LATEST_DRUG_ID);
		return query.getResultList().get(0).toString();
	}
	@Override
	public void savePharmcayDrugMapper(List<PharmacyDrugMaster> pharDrugMasterList) {
		pharDrugMasterList.forEach(pharMaster -> entity.persist(pharMaster));
		System.out.println("Saved successfully...!");
	}

	/**
	 * @param drugManagementObj
	 * @return
	 */
	@Override
	public String updateDrugDetails(DrugManageDetails drug) {
		String responseMsg = "Drug Details Successfully Updated";
		try {
			Query query = entity.createQuery(SQLConstants.DRUG_UPDATE);
			query.setParameter("isActive", drug.getIsActive());
			query.setParameter("drugName", drug.getDrugName());
			query.executeUpdate();
		} catch (Exception exe) {
			exe.printStackTrace();
			responseMsg = "Error Occoured While Update";
		}
		return responseMsg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PharmacyDetails> getPharmacyArea() {
		Query query = entity.createQuery(SQLConstants.GET_PHARMACY_AREA_SQL);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DrugManageDetails> getDrugNameStatusInfo() {
		Query query = entity.createQuery(SQLConstants.DRUG_NAME_STATUS_SQL);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PharmacyManageDetails> getPharmacyStatus(String pharmacyName) {
		Query query = entity.createQuery(SQLConstants.PHARMACY_STATUS_SQL);
		query.setParameter("pharmacyName", pharmacyName);
		return query.getResultList();
	}

	/**
	 * @param pharmacyManageDetailsObj
	 * @return
	 */
	@Override
	public String updatePharmacyDetails(PharmacyManageDetails pharmacy) {
		String responseMsg = "Pharmacy Details Updated Successfully";
		try {
			Query query = entity.createQuery(SQLConstants.PHARMACY_UPDATE);
			query.setParameter("isRegistered", pharmacy.getIsRegistered());
			query.setParameter("pharmacyName", pharmacy.getPharmacyName());
			query.setParameter("area", pharmacy.getArea());
			query.executeUpdate();
		} catch (Exception exe) {
			exe.printStackTrace();
			responseMsg = "Error Occoured While Update";
		}
		return responseMsg;
	}
	

	@SuppressWarnings("unchecked")
	public List<PharmacyDetails> getPharmacyList() {
		Query query = entity.createQuery(SQLConstants.GET_PHARMACY_LIST_SQL);
		return query.getResultList();
	}
	
	public DrugPharmacyMapper  getDrugIsAvailableInPharmacy(DrugPharmacyMapper drugPharmacyMapper){
		Query query = entity.createQuery(SQLConstants.GET_DRUG_PHARMACY_AVAIL_SQL);
		query.setParameter("pharmacyName", drugPharmacyMapper.getPharmacyName());
		query.setParameter("area", drugPharmacyMapper.getArea());
		query.setParameter("drugName", drugPharmacyMapper.getDrugName());
		return (DrugPharmacyMapper) query.getSingleResult();
	}

	public String drugStatusUpdate(DrugPharmacyMapper drugPharmacyMapper){
		String responseMsg = "Drug Details Successfully Updated";
		try {
			Query query = entity.createQuery(SQLConstants.UPDATE_PHARMACY_DRUG_MASTER_SQL);
			query.setParameter("isAvailable",drugPharmacyMapper.getIsAvailable());
			query.setParameter("mappingId",drugPharmacyMapper.getMappingId());
			query.executeUpdate();
		} catch (Exception exe) {
			exe.printStackTrace();
			responseMsg = "Error Occoured While Update";
		}
		return responseMsg;
	}

}
