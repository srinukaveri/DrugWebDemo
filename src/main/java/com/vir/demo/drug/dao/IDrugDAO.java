/**
 * 
 */
package com.vir.demo.drug.dao;

import java.util.List;

import com.vir.demo.drug.entity.DrugDetails;
import com.vir.demo.drug.entity.PharmacyDetails;
import com.vir.demo.drug.entity.PharmacyDrugMaster;
import com.vir.demo.drug.entity.UserLoginDetails;
import com.vir.demo.drug.model.DrugManageDetails;
import com.vir.demo.drug.model.DrugPharmacyMapper;
import com.vir.demo.drug.model.DrugSearch;
import com.vir.demo.drug.model.PharmacyManageDetails;

/**
 * @author sreeni
 *
 */
public interface IDrugDAO {
	public List<PharmacyDetails> getPharmacyDetails(String area);

	public List<DrugDetails> getDrugDetails();

	public List<DrugSearch> getDrugListMaster(List<String> pharmacyId, List<String> drugNameList);

	public UserLoginDetails doLogin(String userName, String password);

	List<DrugManageDetails> getDrugNameStatusInfo();

	List<PharmacyDetails> getPharmacyArea();

	String updateDrugDetails(DrugManageDetails drug);

	void savePharmcayDrugMapper(List<PharmacyDrugMaster> pharDrugMasterList);

	List<DrugSearch> getPharmacyDrugDetails(String drugName);

	String updatePharmacyDetails(PharmacyManageDetails pharmacyManageDetailsObj);
	
	public List<PharmacyManageDetails> getPharmacyStatus(String pharmacyName);
	
	public DrugPharmacyMapper  getDrugIsAvailableInPharmacy(DrugPharmacyMapper drugPharmacyMapper);
}
