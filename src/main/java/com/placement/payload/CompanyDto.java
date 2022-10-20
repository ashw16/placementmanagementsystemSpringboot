package com.placement.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;




public class CompanyDto 
{
	private int companyId;
	
	private String companyName;
	
	
	private String companyType;
	
	private String companyDescription;
	
	//@JsonIgnore
	List<JobDto> jobPostList=new ArrayList();

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public List<JobDto> getJobPostList() {
		return jobPostList;
	}

	public void setJobPostList(List<JobDto> jobPostList) {
		this.jobPostList = jobPostList;
	}

	public CompanyDto(int companyId, String companyName, String companyType, String companyDescription,
			List<JobDto> jobPostList) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyType = companyType;
		this.companyDescription = companyDescription;
		this.jobPostList = jobPostList;
	}

	public CompanyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CompanyDto [companyId=" + companyId + ", companyName=" + companyName + ", companyType=" + companyType
				+ ", companyDescription=" + companyDescription + ", jobPostList=" + jobPostList + "]";
	}

	

	
	
	
}
