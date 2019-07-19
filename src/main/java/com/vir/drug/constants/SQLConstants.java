package com.vir.drug.constants;

/**
 * @author Sreeni
 * SQL Queries listed in below
 */
public class SQLConstants {

	public static final String LOGIN_SQL = "from UserLoginDetails p  where p.userName =: userName";
	public static final String GET_PHARMACY_SQL = " from PharmacyDetails p where p.area  =: area";
	public static final String GET_DRUG_SQL = " from DrugDetails d where d.isActive = 'Y' order by d.drugName asc";
	public static final String USER_NAME = "userName";
	public static final String DRUG_NAME = "drugName";
	public static final String PHARMACY_ID = "pharmacyMasterId";
	public static final String AREA = "area";
	
	
	public static final String DRUG_SEARCH_SQL = "select  new com.vir.drug.model.DrugSearch("
			+  "pd.pharmacyMasterId, d.drugId,d.drugName,d.isActive, "
			+ " pd.mappingId,pd.isAvailable,pd.drugPriceEach,pd.currency) "
			+" from DrugDetails d inner join PharmacyDrugMaster pd on d.drugId = pd.drugId "
			+ " where pd.pharmacyMasterId in (:pharmacyMasterId) and d.drugName in (:drugName)";
	
	

}
