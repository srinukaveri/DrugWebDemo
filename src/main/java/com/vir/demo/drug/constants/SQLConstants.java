package com.vir.demo.drug.constants;

/**
 * @author Sreeni 
 * SQL Queries listed in below
 */
public class SQLConstants {

	public static final String LOGIN_SQL = "from UserLoginDetails p  where p.userName =: userName";
	public static final String GET_PHARMACY_SQL = " from PharmacyDetails p where p.isRegistered = 'Y' and p.area  =: area";
	public static final String GET_ALL_PHARMACY_SQL = " from PharmacyDetails p where p.isRegistered = 'Y' order by p.area asc";
	public static final String GET_PHARMACY_AREA_SQL = "select distinct(p.area) from PharmacyDetails p where p.isRegistered = 'Y' order by p.area asc";
	public static final String GET_PHARMACY_LIST_SQL = "select distinct(p.pharmacyName) from PharmacyDetails p order by p.area asc";
	public static final String GET_DRUG_SQL = " from DrugDetails d where d.isActive = 'Y' order by d.drugName asc";
	public static final String USER_NAME = "userName";
	public static final String DRUG_NAME = "drugName";
	public static final String PHARMACY_ID = "pharmacyMasterId";
	public static final String AREA = "area";
	public static final String ALL = "all";

	public static final String DRUG_SEARCH_SQL = "select  new com.vir.demo.drug.model.DrugSearch("
			+ "pd.pharmacyMasterId, d.drugId,d.drugName,d.isActive, "
			+ " pd.mappingId,pd.isAvailable,pd.drugPriceEach,pd.currency) "
			+ " from DrugDetails d inner join PharmacyDrugMaster pd on d.drugId = pd.drugId "
			+ " where d.isActive = 'Y' and pd.isAvailable = 'Y' and pd.pharmacyMasterId in (:pharmacyMasterId) and d.drugName in (:drugName)";

	public static final String DRUG_NAME_STATUS_SQL = "select  new com.vir.demo.drug.model.DrugManageDetails("
			+ " d.drugName, d.isActive) from DrugDetails d order by d.drugName asc";

	public static final String PHARMACY_STATUS_SQL = "select  new com.vir.demo.drug.model.PharmacyManageDetails("
			+ " p.pharmacyName, p.isRegistered, p.area) from PharmacyDetails p order by p.pharmacyName asc";

	public static final String LATEST_DRUG_ID = "select new com.vir.demo.demo.drug.model.DrugSearch(max(d.drugId)) from "
			+ "DrugDetails d";

	public static final String DRUG_UPDATE = "update DrugDetails d  set d.isActive =:isActive where d.drugName =: drugName";
	public static final String PHARMACY_UPDATE = "update PharmacyDetails p  set p.isRegistered =:isRegistered where p.pharmacyName =: pharmacyName and p.area = :area";

}
