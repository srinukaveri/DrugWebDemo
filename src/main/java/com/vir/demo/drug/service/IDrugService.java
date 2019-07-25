/**
 * 
 */
package com.vir.demo.drug.service;

import java.util.List;
import java.util.Map;

import com.vir.demo.drug.entity.PharmacyDetails;
import com.vir.demo.drug.model.DrugManageDetails;
import com.vir.demo.drug.model.DrugRequest;
import com.vir.demo.drug.model.DrugSearch;
import com.vir.demo.drug.model.PharmacyManageDetails;

/**
 * @author sreeni Interface for the drug service
 */
public interface IDrugService {
	public List<Object> fetchPharmacyDrugDetails(DrugRequest drugDetails);

	public String drugManagement(DrugManageDetails drugManagementObj);

	String doLogin(String userName, String password);

	Map<String, List<String>> getDrugDetails();

	List<DrugSearch> getPharmacyDrugMasterDetails(String drugName);

	Map<String, List<PharmacyDetails>> fetchPharmacyArea();

	List<DrugManageDetails> getDrugNameStatusInfo();

	List<PharmacyManageDetails> getPharmacyStatus(String pharmacyName);

	String pharmacyManagement(PharmacyManageDetails pharmacyManageDetailsObj);
	
	public List<PharmacyDetails> getPharmacyList(); 

}
