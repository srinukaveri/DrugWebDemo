/**
 * 
 */
package com.vir.demo.drug.service;

import java.util.List;
import java.util.Map;

import com.vir.demo.drug.model.DrugRequest;

/**
 * @author sreeni
 * Interface for  the drug service
 */
public interface IDrugService {
	public Map<String,List<String>> fetchDrugDetails();
	public List<Object> fetchPharmacyDrugDetails(DrugRequest drugDetails);

}
