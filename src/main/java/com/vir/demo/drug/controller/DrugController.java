package com.vir.demo.drug.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vir.demo.drug.entity.PharmacyDetails;
import com.vir.demo.drug.exception.DrugMapperValidationException;
import com.vir.demo.drug.model.DrugRequest;
import com.vir.demo.drug.service.IDrugService;
import com.vir.demo.drug.util.DrugUtil;

/**
 * @author Sreeni This is the controller class where all process starting from
 *         here.
 *
 */
@RestController
public class DrugController {
	
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(DrugController.class);

	@Autowired
	private IDrugService drugService;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String showText() {
		return "Welcome to drugweb app...!";
	}

	/**
	 * This method return the detailed information about the drugs
	 * 
	 * @return list of drug details
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/drug", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<String>> getDrugDetails() {
		logger.info("inside drug details ");
		return drugService.getDrugDetails();
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
		logger.info("drug details started "+drugDetails);
		List<Object> finalResponse = null;
		try {
			DrugRequest drugRequestObj = DrugUtil.getMapperInstance().readValue(drugDetails, DrugRequest.class);
			finalResponse = drugService.fetchPharmacyDrugDetails(drugRequestObj);
			logger.info("drug details completed "+finalResponse.toString());
		} catch (DrugMapperValidationException exe) {
			return DrugUtil.setResponseList(exe.getMessage(), exe.getErrorCode());
		}
		return finalResponse;
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/pharmacy/area", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<PharmacyDetails>> getPharmacyArea() {
		logger.info("inside  pharmacy area  ");
		return drugService.fetchPharmacyArea();
	}

}
