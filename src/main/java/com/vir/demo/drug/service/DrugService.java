package com.vir.demo.drug.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vir.demo.drug.constants.DrugConstants;
import com.vir.demo.drug.constants.ErrorCodes;
import com.vir.demo.drug.dao.IDrugDAO;
import com.vir.demo.drug.entity.DrugDetails;
import com.vir.demo.drug.entity.PharmacyDetails;
import com.vir.demo.drug.entity.PharmacyDrugMaster;
import com.vir.demo.drug.entity.UserLoginDetails;
import com.vir.demo.drug.exception.DrugMapperValidationException;
import com.vir.demo.drug.exception.LoginValidationException;
import com.vir.demo.drug.model.DrugManageDetails;
import com.vir.demo.drug.model.DrugPharmacyMapper;
import com.vir.demo.drug.model.DrugRequest;
import com.vir.demo.drug.model.DrugSearch;
import com.vir.demo.drug.model.PharmacyManageDetails;
import com.vir.demo.drug.util.DrugUtil;

/**
 * @author Sreeni
 *
 */
@Service
@Transactional
public class DrugService implements IDrugService {

	@Autowired
	private IDrugDAO drugDAO;

	/**
	 * for the login valiidation
	 * 
	 * @param userName
	 * @param password
	 * @return response msg
	 */
	@Override
	public String doLogin(String userName, String password) {
		String responseMsg = null;
		if (!StringUtils.isBlank(userName) && !StringUtils.isBlank(password)) {
			UserLoginDetails userInfo = drugDAO.doLogin(userName, password);
			if (userInfo != null) {
				if (userInfo.getUserName().equals(userName) && userInfo.getUserPassword().equals(password)) {
					responseMsg = DrugConstants.LOGIN_SUCCESS_MSG;
				} else if (!userInfo.getUserPassword().equals(password)) {
					responseMsg = DrugConstants.IN_VALID_USER_PASSWORD;
				} else {
					responseMsg = DrugConstants.INVALID_LOGIN_CREDENTIALS;
				}
			} else {
				responseMsg = DrugConstants.NO_RECORD_FOUND;
			}
		} else {
			throw new LoginValidationException(DrugConstants.INVALID_LOGIN_CREDENTIALS,
					ErrorCodes.LOGIN_VALIDATION_ERROR_CODE);
		}
		return responseMsg;
	}

	/**
	 * fetch the detailed information about the drug
	 * 
	 * @return drugdetails
	 */
	@Override
	public Map<String, List<String>> getDrugDetails() {
		List<DrugDetails> drugList = drugDAO.getDrugDetails();
		List<String> drugNames = null;
		Map<String, List<String>> finalResponse = new HashMap<String, List<String>>();
		if (drugList != null && drugList.size() > 0 && !drugList.isEmpty()) {
			drugNames = new ArrayList<String>();
			for (DrugDetails durgDetails : drugList) {
				drugNames.add(durgDetails.getDrugName());
			}
			Collections.sort(drugNames);
		}
		finalResponse.put(DrugConstants.DRUG_LIST_LOWER, drugNames);
		return finalResponse;
	}

	/**
	 * @param drugName
	 * @return pharmacy master details
	 */
	@Override
	public List<DrugSearch> getPharmacyDrugMasterDetails(String drugName) {
		return drugDAO.getPharmacyDrugDetails(drugName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vir.demo.drug.service.IDrugService#fetchPharmacyDrugDetails(com.vir.
	 * demo.drug.model.DrugRequest)
	 */
	@Override
	public List<Object> fetchPharmacyDrugDetails(DrugRequest drugDetails) {
		String area = drugDetails.getArea();
		List<String> drugList = drugDetails.getDrugName();
		List<PharmacyDetails> pharmacyList = drugDAO.getPharmacyDetails(area);
		List<DrugSearch> drugResultList = drugDAO.getDrugListMaster(getPharmacyID(pharmacyList), drugList);
		if (org.apache.commons.collections4.CollectionUtils.isEmpty(drugResultList)) {
			throw new DrugMapperValidationException(DrugConstants.SERVICE_ERROR_MSG, ErrorCodes.SERVICE_ERROR_CODE);
		}
		return mappingPharmacyDrug(pharmacyList, drugResultList);
	}

	/**
	 * @param pharmacyList
	 * @return
	 */
	private List<String> getPharmacyID(List<PharmacyDetails> pharmacyList) {
		List<String> pharmacyIdList = new ArrayList<String>();
		if (pharmacyList != null && !pharmacyList.isEmpty()) {
			for (PharmacyDetails pharmcayDetails : pharmacyList) {
				pharmacyIdList.add(pharmcayDetails.getPharmacyMasterId());
			}
		}
		return pharmacyIdList;
	}

	/**
	 * @param pharmacyList
	 * @param drugResultList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Object> mappingPharmacyDrug(List<PharmacyDetails> pharmacyList, List<DrugSearch> drugResultList) {
		Map<Object, Object> pharmacyFinalResponse = new HashMap<Object, Object>();
		List<Object> finalResponse = new ArrayList<Object>();
		for (PharmacyDetails pharmacyDTO : pharmacyList) {
			List<DrugSearch> drugRes = new ArrayList<DrugSearch>();
			pharmacyFinalResponse = DrugUtil.getMapperInstance().convertValue(pharmacyDTO, Map.class);
			for (DrugSearch drugSearch : drugResultList) {
				if (pharmacyDTO.getPharmacyMasterId().equals(drugSearch.getPharmacyMasterId())) {
					drugRes.add(drugSearch);
				}
				pharmacyFinalResponse.put(DrugConstants.DRUG_LIST, drugRes);
			}
			finalResponse.add(pharmacyFinalResponse);
		}
		return finalResponse;
	}

	/**
	 * @return
	 */
	@Override
	public Map<String, List<PharmacyDetails>> fetchPharmacyArea() {
		Map<String, List<PharmacyDetails>> pharmacyAreaResponse = new HashMap<String, List<PharmacyDetails>>();
		pharmacyAreaResponse.put(DrugConstants.AREA, drugDAO.getPharmacyArea());
		return pharmacyAreaResponse;
	}

	/**
	 * @param drugManagementObj
	 * @return response
	 */
	@Override
	public String drugManagement(DrugManageDetails drugManagementObj) {
		return drugDAO.updateDrugDetails(drugManagementObj);
	}

	/**
	 * @return List<DrugManageDetails>
	 */
	@Override
	public List<DrugManageDetails> getDrugNameStatusInfo() {
		return drugDAO.getDrugNameStatusInfo();
	}

	/**
	 * @return List<PharmacyManageDetails>
	 */
	@Override
	public List<PharmacyManageDetails> getPharmacyStatus(String pharmacyName) {
		return drugDAO.getPharmacyStatus(pharmacyName);
	}
	
	
	public List<PharmacyDetails> getPharmacyList() {
		return drugDAO.getPharmacyList();
	}

	@Override
	public String pharmacyManagement(PharmacyManageDetails pharmacyManageDetailsObj) {
		return drugDAO.updatePharmacyDetails(pharmacyManageDetailsObj);
		
	}
	
	public DrugPharmacyMapper  getDrugIsAvailableInPharmacy(DrugPharmacyMapper drugPharmacyMapper){
		return drugDAO.getDrugIsAvailableInPharmacy(drugPharmacyMapper);
	}

	public String drugStatusUpdate(DrugPharmacyMapper drugPharmacyMapper){
		return drugDAO.drugStatusUpdate(drugPharmacyMapper);
	}
	
	public String saveDrug(DrugDetails drugDetails){
		String drugId = null;
		if(drugDetails!=null && drugDetails.getDrugName()!= null){
		Map<String, List<String>> drugResObj = getDrugDetails();
		List<String>  drugList = drugResObj.get(DrugConstants.DRUG_LIST_LOWER);
		if(drugList.contains(drugDetails.getDrugName())){
			return  DrugConstants.IS_EXIST_YES;
		}
		String maxCountStr = drugDAO.getLatestDrugId().toString();
		int maxCount = Integer.parseInt(maxCountStr);
		drugId = generateID(maxCount,DrugConstants.DRUG_PREFIX);
		drugDetails.setDrugId(drugId);
		drugDetails.setDrugName(drugDetails.getDrugName());
		drugDetails.setIsActive(DrugConstants.YES_Y);
		drugDAO.saveDrug(drugDetails);
		}
	return drugId;
	}

	
   private String  generateID(int latestMappingId, String prefix) {
	   latestMappingId = latestMappingId +1;
       String id = prefix+latestMappingId;
       return id;
   }
   
   public void pharmacyDrugMapper(String drugID){
		List<PharmacyDetails> pharmacyList = drugDAO.getPharmacyDetails(DrugConstants.ALL);
		String countMappingId = drugDAO.getMasterLatestId().toString();
		int latestMappingId = Integer.parseInt(countMappingId);
		PharmacyDrugMaster pharmacyDrugMaster= null;
		List<PharmacyDrugMaster> pharDrugMasterList = new ArrayList<PharmacyDrugMaster>();
		for(PharmacyDetails pharmacyDetails : pharmacyList){
				String mappingId = generateID(latestMappingId, DrugConstants.MAPPING_PREFIX);
				pharmacyDrugMaster = new PharmacyDrugMaster();
				pharmacyDrugMaster.setMappingId(mappingId);
				pharmacyDrugMaster.setPharmacyMasterId(pharmacyDetails.getPharmacyMasterId());
				pharmacyDrugMaster.setDrugId(drugID);
				pharmacyDrugMaster.setIsAvailable(DrugConstants.YES_Y);
				pharmacyDrugMaster.setDrugPriceEach(getRandomDoubleBetweenRange(DrugConstants.MIN_VALUE,DrugConstants.MAX_VALUE));
				pharmacyDrugMaster.setCurrency(DrugConstants.CURRENCY_INDIA);
				latestMappingId++;
				pharDrugMasterList.add(pharmacyDrugMaster);
		}
		drugDAO.savePharmcayDrugMapper(pharDrugMasterList);
	}

	/*
	 * To generate drug price dynamically
	 * decimal value restricted to two
	 */
	private Double getRandomDoubleBetweenRange(float min, float max) {
		DecimalFormat df = new DecimalFormat(DrugConstants.DECIMAL_FORMAT);
		Random random = new Random();
	    double x = random.doubles(min,(max+1)).findFirst().getAsDouble();
	    return Double.parseDouble(df.format(x));
	}
	
}