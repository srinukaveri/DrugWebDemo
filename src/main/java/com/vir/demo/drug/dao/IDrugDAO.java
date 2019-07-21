/**
 * 
 */
package com.vir.demo.drug.dao;

import java.util.List;

import com.vir.demo.drug.entity.DrugDetails;
import com.vir.demo.drug.entity.PharmacyDetails;
import com.vir.demo.drug.model.DrugSearch;

/**
 * @author sreeni
 *
 */
public interface IDrugDAO {
	public List<PharmacyDetails> getPharmacyDetails(String area);
	public List<DrugDetails> getDrugDetails();
	public List<DrugSearch> getDrugListMaster(List<String> pharmacyId, List<String> drugNameList);
	

}
