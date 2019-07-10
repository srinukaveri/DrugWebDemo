package com.vir.demo.main.constants;

public class SQLConstants {

	public static final String LOGIN_SQL = "from UserLoginDetails p  where p.userName =: userName";
	public static final String GET_PHARMACY_SQL = " from PharmacyDetails";
	public static final String GET_DRUG_SQL = " from DrugDetails d where d.isActive = 'Y' order by d.drugName asc";
	public static final String USER_NAME = "userName";
	public static final String DRUG_NAME = "drugName";
	
	public static final String DRUG_SEARCH_SQL = "select "
			+ "p.pharmacyMasterId as pharmacyMasterId,p.pharmacyName,p.isRegistered,p.addressLine,p.area,p.city,p.state,p.postalCode,"
			+ "p.country,p.latitude,p.longtitude,p.openTime,p.closedTime,d.drugId,d.drugName,d.isActive,"
			+ "pd.mappingId,pd.isAvailable,pd.drugPriceEach,pd.currency"
			+" from DrugDetails d inner join PharmacyDrugMaster pd on d.drugId = pd.drugId "
			+ " inner join PharmacyDetails p on p.pharmacyMasterId = pd.pharmacyMasterId"
			+ " where d.drugName =:drugName";
	
	

}
