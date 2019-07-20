package com.vir.drug.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vir.drug.model.DrugRequest;
import com.vir.drug.service.IDrugService;
import com.vir.drug.util.DrugUtil;

/**
 * @author Sreeni 
 * This is the controller class where all process starting from
 * here.
 *
 */
@RestController
@Component
public class DrugController {

	@Autowired
	private IDrugService drugService;
	
	@Autowired
	private DrugUtil durgUtil;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String showText() {
		return "Welcome to drugweb app...!";
	}

	/**
	 * This method return the detailed information about the drugs
	 * 
	 * @return list of drug details
	 */
	@RequestMapping(value = "/drug", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<String>> getDrugDetails() {
		return drugService.fetchDrugDetails();
	}

	/**
	 * This method find the corresponding and near by available pharmacy details
	 * for the particular drug which is given by the user.
	 * 
	 * @param drugDetails
	 * @return drugsearch
	 * @throws Exception
	 */
	@RequestMapping(value = "/drug/details", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> getPriceDetails(@RequestBody String drugDetails) throws Exception {
		DrugRequest drugRequestObj = durgUtil.getMapperInstance().readValue(drugDetails, DrugRequest.class);
		return drugService.fetchPharmacyDrugDetails(drugRequestObj);
	}

}
