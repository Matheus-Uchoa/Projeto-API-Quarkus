package org.acme.dto;

import lombok.extern.jackson.Jacksonized;

@Jacksonized
public class BrandDTO {
	private String name;
	private String industry;
	private int yearFounded;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
}
