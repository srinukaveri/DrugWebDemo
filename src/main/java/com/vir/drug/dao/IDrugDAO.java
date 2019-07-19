/**
 * 
 */
package com.vir.drug.dao;

import java.util.List;

import com.vir.drug.entity.DrugDetails;
import com.vir.drug.entity.PharmacyDetails;
import com.vir.drug.model.DrugSearch;

/**
 * @author sreeni
 *
 */
public interface IDrugDAO {
	public List<PharmacyDetails> getPharmacyDetails(String area);
	public List<DrugDetails> getDrugDetails();
	public List<DrugSearch> getDrugListMaster(List<String> pharmacyId, List<String> drugNameList);
	

}
