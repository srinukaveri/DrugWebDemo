package com.vir.demo.drug.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vir.demo.drug.constants.DrugConstants;
import com.vir.demo.drug.entity.DrugDetails;
import com.vir.demo.drug.entity.PharmacyDetails;
import com.vir.demo.drug.exception.LoginValidationException;
import com.vir.demo.drug.model.DrugManageDetails;
import com.vir.demo.drug.model.DrugPharmacyMapper;
import com.vir.demo.drug.model.PharmacyManageDetails;
import com.vir.demo.drug.model.UserLogin;
import com.vir.demo.drug.service.IDrugService;
import com.vir.demo.drug.util.DrugUtil;

/**
 * @author Sreeni This is the admin controller class where all admin activity
 *         process start's here.
 *
 */
@RestController
public class DrugAdminController {

	@Autowired
	private IDrugService drugService;

	/**
	 * this method validate the user id and password from the UI and returns the
	 * response
	 * @param userName
	 * @param password
	 * @return the login response whether success or failure
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String doLogin(@RequestBody String userLoginDetails) throws Exception {
		String loginResponse = null;
		try {
			UserLogin loginObj = DrugUtil.getMapperInstance().readValue(userLoginDetails, UserLogin.class);
			String serviceResponse = drugService.doLogin(loginObj.getUserName(), loginObj.getPassword());
			loginResponse = DrugUtil.toJSONString(serviceResponse);
		} catch (LoginValidationException exe) {
			loginResponse = DrugUtil.toJSONStringException(exe.getMessage(), exe.getErrorCode());
		}
		return loginResponse;
	}

	/**
	 * The Request uri for the drug management like drug active or inactive.
	 * 
	 * @param drugManageDetails
	 * @return Success response;
	 * @throws Exception
	 */

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/drug/manage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> drugMangement(@RequestBody String drugManageDetails) throws Exception {
		DrugManageDetails drugManagementObj = DrugUtil.getMapperInstance().readValue(drugManageDetails,
				DrugManageDetails.class);
		Map<String, String> mapObj = new HashMap<String, String>();
		mapObj.put("message", drugService.drugManagement(drugManagementObj));
		return mapObj;

	}

	/**
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/drug/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DrugManageDetails> getDrugNameStatusInfo() {
		return drugService.getDrugNameStatusInfo();
	}

	/**
	 * @param pharmacyName
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/pharmacy/status", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PharmacyManageDetails> getPharmacyStatus(@RequestBody String pharmacyName) throws Exception {
		PharmacyManageDetails pharmacyManageDetailsObj = DrugUtil.getMapperInstance().readValue(pharmacyName,
				PharmacyManageDetails.class);
		return drugService.getPharmacyStatus(pharmacyManageDetailsObj.getPharmacyName());
	}

	/**
	 * The Request uri for the pharmacy management like drug active or inactive.
	 * 
	 * @param drugManageDetails
	 * @return Success response;
	 * @throws Exception
	 */

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/pharmacy/manage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> pharmacyMangement(@RequestBody String pharmacyManageDetails) throws Exception {
		PharmacyManageDetails pharmacyManageDetailsObj = DrugUtil.getMapperInstance().readValue(pharmacyManageDetails,
				PharmacyManageDetails.class);
		Map<String, String> mapObj = new HashMap<String, String>();
		mapObj.put("message", drugService.pharmacyManagement(pharmacyManageDetailsObj));
		return mapObj;

	}

	/**
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/pharmacy/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PharmacyDetails> getPharmacyList() {
		return drugService.getPharmacyList();
	}

	/**
	 * @param drugPharmacyDetails
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/dp/isavailable", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DrugPharmacyMapper drugIsAvailableInPharmacy(@RequestBody String drugPharmacyDetails) throws Exception {
		DrugPharmacyMapper pharmacyManageDetailsObj = DrugUtil.getMapperInstance().readValue(drugPharmacyDetails,
				DrugPharmacyMapper.class);
		return drugService.getDrugIsAvailableInPharmacy(pharmacyManageDetailsObj);
	}

	/**
	 * @param drugPharmacyDetails
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/dp/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String drugMasterIsAvailableUpdate(@RequestBody String drugPharmacyDetails) throws Exception {
		DrugPharmacyMapper pharmacyManageDetailsObj = DrugUtil.getMapperInstance().readValue(drugPharmacyDetails,
				DrugPharmacyMapper.class);
		return drugService.drugStatusUpdate(pharmacyManageDetailsObj);
	}

	/**
	 * @param drugDetails
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/drug/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> saveDrug(@RequestBody String drugDetails) throws Exception {
		Map<String, String> finalResponse = new HashMap<String,String>();
		DrugDetails drugObj = DrugUtil.getMapperInstance().readValue(drugDetails, DrugDetails.class);
		String responseId = drugService.saveDrug(drugObj);
		if(responseId != null && responseId.equals(DrugConstants.IS_EXIST_YES)){
			finalResponse.put(DrugConstants.MESSAGE, DrugConstants.DRUG_IS_AVAILABLE);
		}else if(responseId != null && !responseId.equals(DrugConstants.IS_EXIST_YES)){	
			drugService.pharmacyDrugMapper(responseId);
			finalResponse.put(DrugConstants.MESSAGE, DrugConstants.DRUG_SUCCESS_MSG);
		}else{
			finalResponse.put(DrugConstants.MESSAGE, DrugConstants.DRUG_ERROR_MSG);
		}
		return finalResponse;
	}

}