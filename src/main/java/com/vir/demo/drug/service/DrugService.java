package com.vir.demo.drug.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vir.demo.drug.constants.DrugConstants;
import com.vir.demo.drug.constants.ErrorCodes;
import com.vir.demo.drug.dao.DrugDAO;
import com.vir.demo.drug.entity.DrugDetails;
import com.vir.demo.drug.entity.PharmacyDetails;
import com.vir.demo.drug.entity.UserLoginDetails;
import com.vir.demo.drug.exception.DrugMapperValidationException;
import com.vir.demo.drug.exception.LoginValidationException;
import com.vir.demo.drug.model.DrugManageDetails;
import com.vir.demo.drug.model.DrugRequest;
import com.vir.demo.drug.model.DrugSearch;
import com.vir.demo.drug.model.ModifyDrugInfo;
import com.vir.demo.drug.model.PharmacyManageDetails;
import com.vir.demo.drug.util.DrugUtil;

/**
 * @author Sreeni
 *
 */
@Service
@Transactional
public class DrugService implements IDrugService{
	
	@Autowired
	private DrugDAO drugDAO;
	
		
	
	/**
	 * for the login valiidation
	 * @param userName
	 * @param password
	 * @return response msg
	 */
	public String doLogin(String userName,String password){
	String responseMsg = null;
		   if(!StringUtils.isBlank(userName) && !StringUtils.isBlank(password)){
			   UserLoginDetails userInfo = drugDAO.doLogin(userName, password);
			   if(userInfo != null){
				   if(userInfo.getUserName().equals(userName)&& userInfo.getUserPassword().equals(password)){
					   responseMsg = DrugConstants.LOGIN_SUCCESS_MSG;
				   }else if(!userInfo.getUserPassword().equals(password)){
					   responseMsg = DrugConstants.IN_VALID_USER_PASSWORD;
				   }else{
					   responseMsg = DrugConstants.INVALID_LOGIN_CREDENTIALS;
				   }
			   }else{
				   responseMsg = DrugConstants.NO_RECORD_FOUND;
			   }
		   }else{ 
			   throw new LoginValidationException(DrugConstants.INVALID_LOGIN_CREDENTIALS,ErrorCodes.LOGIN_VALIDATION_ERROR_CODE);
		   }
		return responseMsg;	
	}
	
	/**
	 * fetch the detailed information about the drug
	 * @return drugdetails
	 */
	public Map<String,List<String>> getDrugDetails(){
		List<DrugDetails> drugList = drugDAO.getDrugDetails();
		List<String> drugNames = null;
		Map<String,List<String>> finalResponse = new HashMap<String,List<String>>();	
		if(drugList != null && drugList.size()>0 && !drugList.isEmpty()){
			drugNames = new ArrayList<String>();
			for(DrugDetails durgDetails : drugList){
				drugNames.add(durgDetails.getDrugName());
			}
			Collections.sort(drugNames);
		}
		finalResponse.put("druglist", drugNames);
		return finalResponse;
	}
	
	/**
	 * @param drugName
	 * @return pharmacy master details
	 */
	public List<DrugSearch> getPharmacyDrugMasterDetails(String drugName){
		return drugDAO.getPharmacyDrugDetails(drugName);
	}

	public List<Object>  fetchPharmacyDrugDetails(DrugRequest drugDetails) {
		String area = drugDetails.getArea();
		List<String> drugList = drugDetails.getDrugName();
		List<PharmacyDetails> pharmacyList = drugDAO.getPharmacyDetails(area);
		List<DrugSearch> drugResultList = drugDAO.getDrugListMaster(getPharmacyID(pharmacyList),drugList);
		if(org.apache.commons.collections4.CollectionUtils.isEmpty(drugResultList)){
			throw new DrugMapperValidationException(DrugConstants.SERVICE_ERROR_MSG,ErrorCodes.SERVICE_ERROR_CODE);
		}
		return mappingPharmacyDrug(pharmacyList,drugResultList);
	}
	
	private List<String> getPharmacyID(List<PharmacyDetails> pharmacyList){
		List<String> pharmacyIdList = new ArrayList<String>();
		if(pharmacyList!= null  && ! pharmacyList.isEmpty()){
			for(PharmacyDetails pharmcayDetails : pharmacyList){
				pharmacyIdList.add(pharmcayDetails.getPharmacyMasterId());
			}
		}
		return pharmacyIdList;
	}
	
	
	@SuppressWarnings("unchecked")
	private List<Object> mappingPharmacyDrug(List<PharmacyDetails> pharmacyList,List<DrugSearch> drugResultList){
	     Map<Object,Object> pharmacyFinalResponse = new HashMap<Object,Object>();
	     List<Object> finalResponse = new ArrayList<Object>();
			for(PharmacyDetails pharmacyDTO : pharmacyList){
				 List<DrugSearch> drugRes = new ArrayList<DrugSearch>();
				 pharmacyFinalResponse = DrugUtil.getMapperInstance().convertValue(pharmacyDTO, Map.class);
				 for(DrugSearch drugSearch :drugResultList){
					if(pharmacyDTO.getPharmacyMasterId().equals(drugSearch.getPharmacyMasterId())){
						drugRes.add(drugSearch);
					}
					pharmacyFinalResponse.put("drugList",drugRes);
				}
				finalResponse.add(pharmacyFinalResponse);
			}
		return finalResponse;
	}
	

	public Map<String,List<PharmacyDetails>> fetchPharmacyArea(){
		Map<String,List<PharmacyDetails>> pharmacyAreaResponse = new HashMap<String,List<PharmacyDetails>>();
		pharmacyAreaResponse.put("area", drugDAO.getPharmacyArea());
	return pharmacyAreaResponse;
	}

	/**
	 * @param drugManagementObj
	 * @return response
	 */
	public String drugManagement(DrugManageDetails drugManagementObj) {
		return drugDAO.updateDrugDetails(drugManagementObj);
	}

	public List<DrugManageDetails> getDrugNameStatusInfo(){
	 return drugDAO.getDrugNameStatusInfo();	
	}
	
	
	public List<PharmacyManageDetails> getPharmacyStatus(){
		return  drugDAO.getPharmacyStatus();
	}
	

}