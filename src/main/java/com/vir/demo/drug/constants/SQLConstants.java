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
	public static final String GET_PHARMACY_LIST_SQL = "select distinct(p.pharmacyName) from PharmacyDetails p order by p.pharmacyName asc";
	public static final String GET_DRUG_SQL = " from DrugDetails d where d.isActive = 'Y' order by d.drugName asc";
	public static final String GET_ALL_DRUG_SQL = " from DrugDetails d where order by d.drugName asc";
	public static final String USER_NAME = "userName";
	public static final String DRUG_NAME = "drugName";
	public static final String PHARMACY_ID = "pharmacyMasterId";
	public static final String AREA = "area";
	public static final String ALL = "all";

	public static final String DRUG_SEARCH_SQL = "select  new com.vir.demo.drug.model.DrugSearch("
			+ "pd.pharmacyMasterId, d.drugId,d.drugName,d.isActive, "
			+ " pd.mappingId,pd.isAvailable,pd.drugPriceEach,pd.currency) "
			+ " from DrugDetails d inner join PharmacyDrugMaster pd on d.drugId = pd.drugId "
			+ " where d.isActive = 'Y' and pd.pharmacyMasterId in (:pharmacyMasterId) and d.drugName in (:drugName)";

	public static final String DRUG_NAME_STATUS_SQL = "select  new com.vir.demo.drug.model.DrugManageDetails("
			+ " d.drugName, d.isActive) from DrugDetails d order by d.drugName asc";

	public static final String PHARMACY_STATUS_SQL = "select  new com.vir.demo.drug.model.PharmacyManageDetails("
			+ "  p.isRegistered, p.area) from PharmacyDetails p where p.pharmacyName =: pharmacyName order by p.pharmacyName asc";

	public static final String LATEST_MASTER_ID = "select (count(pd.mappingId)+1000) from PharmacyDrugMaster pd";
	
	public static final String LATEST_DRUG_ID = "select (count(d.drugId)+1000) from DrugDetails d";

	public static final String DRUG_UPDATE = "update DrugDetails d  set d.isActive =:isActive where d.drugName =: drugName";
	public static final String PHARMACY_UPDATE = "update PharmacyDetails p  set p.isRegistered =:isRegistered where p.pharmacyName =: pharmacyName and p.area = :area";
	
	public static final String GET_DRUG_PHARMACY_AVAIL_SQL = "select  new com.vir.demo.drug.model.DrugPharmacyMapper("
			+" pd.mappingId, pd.isAvailable) from PharmacyDetails p inner join PharmacyDrugMaster pd on p.pharmacyMasterId = pd.pharmacyMasterId "
			+" inner join DrugDetails d on d.drugId = pd.drugId where p.pharmacyName =: pharmacyName and p.area  =: area and d.drugName =: drugName ";
	
	public static final String UPDATE_PHARMACY_DRUG_MASTER_SQL = "update PharmacyDrugMaster pd  set pd.isAvailable =:isAvailable where pd.mappingId =: mappingId ";
	public static final String INSERT_PHAR_DRUG = "insert into PHARMACY_DRUG_MASTER(mapping_Id,pharmacy_Master_Id,drug_Id,is_Available,drug_Price_Each,currency) values(?,?,?,?,?,?)";
	

}
