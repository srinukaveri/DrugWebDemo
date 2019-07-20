package com.vir.drug.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DrugRequest implements Serializable {

	private static final long serialVersionUID = 1548102846183592891L;
	private String area;
	private List<String> drugName;

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area
	 *            the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the drugName
	 */
	public List<String> getDrugName() {
		return drugName;
	}

	/**
	 * @param drugName
	 *            the drugName to set
	 */
	public void setDrugName(List<String> drugName) {
		this.drugName = drugName;
	}

}
