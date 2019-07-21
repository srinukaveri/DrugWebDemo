package com.vir.demo.drug.model;

import java.io.Serializable;
import java.util.List;

public class ModifyDrugInfo implements Serializable{
	
	private static final long serialVersionUID = -2272506691779568441L;
	
	private String actionType;
	private List<String> drugList;
	
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public List<String> getDrugList() {
		return drugList;
	}
	public void setDrugList(List<String> drugList) {
		this.drugList = drugList;
	}
	
	
	

}
