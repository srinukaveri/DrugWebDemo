/**
 * 
 */
package com.vir.drug.service;

import java.util.List;
import java.util.Map;

import com.vir.drug.model.DrugInputRequest;

/**
 * @author sreeni
 * Interface for  the drug service
 */
public interface IDrugService {
	public Map<String,List<String>> fetchDrugDetails();
	public List<Object> fetchPharmacyDrugDetails(DrugInputRequest drugDetails);

}
