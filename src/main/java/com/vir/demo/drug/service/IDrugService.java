/**
 * 
 */
package com.vir.demo.drug.service;

import java.util.List;

import com.vir.demo.drug.model.DrugManageDetails;
import com.vir.demo.drug.model.DrugManagement;
import com.vir.demo.drug.model.DrugRequest;

/**
 * @author sreeni
 * Interface for  the drug service
 */
public interface IDrugService {
	public List<Object> fetchPharmacyDrugDetails(DrugRequest drugDetails);
	public String drugManagement(DrugManageDetails drugManagementObj);
	
	

}
