package com.vir.drug.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vir.drug.dao.IDrugDAO;
import com.vir.drug.entity.DrugDetails;
import com.vir.drug.entity.PharmacyDetails;
import com.vir.drug.model.DrugRequest;
import com.vir.drug.model.DrugSearch;
import com.vir.drug.util.DrugUtil;

/**
 * @author Sreeni
 *
 */
@Service
@Transactional
public class DrugService implements IDrugService {

	@Autowired
	private IDrugDAO drugDAO;
	
	@Autowired
	private DrugUtil durgUtil;

	/**
	 * fetch the detailed information about the drug
	 * 
	 * @return drugdetails
	 */
	public Map<String, List<String>> fetchDrugDetails() {
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
		finalResponse.put("druglist", drugNames);
		return finalResponse;
	}

	/**
	 * fetch the pharmacy along with the drug details
	 * 
	 * @param drugDetails
	 * @return
	 */
	public List<Object> fetchPharmacyDrugDetails(DrugRequest drugDetails) {
		String area = drugDetails.getArea();
		List<String> drugList = drugDetails.getDrugName();
		List<PharmacyDetails> pharmacyList = drugDAO.getPharmacyDetails(area);
		List<DrugSearch> drugResultList = drugDAO.getDrugListMaster(getPharmacyID(pharmacyList), drugList);
		return mappingPharmacyDrug(pharmacyList, drugResultList);
	}

	/**
	 * get the list of pharmacy ids for the particular area
	 * 
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
	 * map the drugdetails with the pharmacy object
	 * 
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
			ObjectMapper objectMapper =  new ObjectMapper();
			pharmacyFinalResponse = objectMapper.convertValue(pharmacyDTO, Map.class);
			for (DrugSearch drugSearch : drugResultList) {
				if (pharmacyDTO.getPharmacyMasterId().equals(drugSearch.getPharmacyMasterId())) {
					drugRes.add(drugSearch);
				}
				pharmacyFinalResponse.put("drugList", drugRes);
			}
			finalResponse.add(pharmacyFinalResponse);
		}
		return finalResponse;
	}

}