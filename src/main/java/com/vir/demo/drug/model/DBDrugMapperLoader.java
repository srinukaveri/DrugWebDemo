package com.vir.demo.drug.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vir.demo.drug.constants.DrugConstants;
import com.vir.demo.drug.dao.DrugDAO;
import com.vir.demo.drug.entity.DrugDetails;
import com.vir.demo.drug.entity.PharmacyDetails;
import com.vir.demo.drug.entity.PharmacyDrugMaster;

/**
 * @author C-PN16
 * which helps to pre-load the PD Master information in H2 DB
 * before the server up
 *
 */
@Component
public class DBDrugMapperLoader{
	
	@Autowired
	private DrugDAO drugDAO;

	@PostConstruct
	public void pharmacyDrugMapper(){
		List<PharmacyDetails> pharmacyList = drugDAO.getPharmacyDetails(DrugConstants.ALL);
		List<DrugDetails> drugList = drugDAO.getDrugDetails();
		PharmacyDrugMaster pharmacyDrugMaster= null;
		int val=0001;
		List<PharmacyDrugMaster> pharDrugMasterList = new ArrayList<PharmacyDrugMaster>();
		for(PharmacyDetails pharmacyDetails : pharmacyList){
			for(DrugDetails drugDetails : drugList){
				val = val+1;
				String mappingId = DrugConstants.PD_MASTER_ID_PREFIX+val;
				pharmacyDrugMaster = new PharmacyDrugMaster();
				pharmacyDrugMaster.setMappingId(mappingId);
				pharmacyDrugMaster.setPharmacyMasterId(pharmacyDetails.getPharmacyMasterId());
				pharmacyDrugMaster.setDrugId(drugDetails.getDrugId());
				pharmacyDrugMaster.setIsAvailable(DrugConstants.YES_Y);
				pharmacyDrugMaster.setDrugPriceEach(getRandomDoubleBetweenRange(10,30));
				pharmacyDrugMaster.setCurrency(DrugConstants.CURRENCY_INDIA);
				pharDrugMasterList.add(pharmacyDrugMaster);
				
			}
		}
		drugDAO.savePharmcayDrugMapper(pharDrugMasterList);
	}

	/*
	 * To generate drug price dynamically
	 * decimal value restricted to two
	 */
	private Double getRandomDoubleBetweenRange(float min, float max) {
		DecimalFormat df = new DecimalFormat("###.##");
		Random random = new Random();
	    double x = random.doubles(min,(max+1)).findFirst().getAsDouble();
	    return Double.parseDouble(df.format(x));
	}
	
	
}
