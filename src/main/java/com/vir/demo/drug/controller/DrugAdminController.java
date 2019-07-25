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

import com.vir.demo.drug.exception.LoginValidationException;
import com.vir.demo.drug.model.DrugManageDetails;
import com.vir.demo.drug.model.PharmacyManageDetails;
import com.vir.demo.drug.model.UserLogin;
import com.vir.demo.drug.service.DrugService;
import com.vir.demo.drug.util.DrugUtil;

/**
 * @author Sreeni This is the admin controller class where all admin activity
 *         process start's here.
 *
 */
@RestController
public class DrugAdminController {

	@Autowired
	private DrugService drugService;

	/**
	 * this method validate the user id and password from the UI and returns the
	 * response
	 * 
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

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/drug/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DrugManageDetails> getDrugNameStatusInfo() {
		return drugService.getDrugNameStatusInfo();
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/pharmacy/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PharmacyManageDetails> getPharmacyStatus() {
		return drugService.getPharmacyStatus();
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

}