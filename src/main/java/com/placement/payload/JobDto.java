package com.placement.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JobDto 
{
	
	private int jobId;
	
	
	private String jobTitle;
	
	
	private String jobType;
	
	
	private String jobStatus;
	
	
	private String jobPackage;
	
	
	private String jobcriteria;
	
	@JsonIgnore
	private CompanyDto company;


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getJobType() {
		return jobType;
	}


	public void setJobType(String jobType) {
		this.jobType = jobType;
	}


	public String getJobStatus() {
		return jobStatus;
	}


	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}


	public String getJobPackage() {
		return jobPackage;
	}


	public void setJobPackage(String jobPackage) {
		this.jobPackage = jobPackage;
	}


	public String getJobcriteria() {
		return jobcriteria;
	}


	public void setJobcriteria(String jobcriteria) {
		this.jobcriteria = jobcriteria;
	}


	public CompanyDto getCompany() {
		return company;
	}


	public void setCompany(CompanyDto company) {
		this.company = company;
	}


	public JobDto(int jobId, String jobTitle, String jobType, String jobStatus, String jobPackage, String jobcriteria,
			CompanyDto company) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.jobStatus = jobStatus;
		this.jobPackage = jobPackage;
		this.jobcriteria = jobcriteria;
		this.company = company;
	}


	public JobDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	/*@Override
	public String toString() {
		return "JobDto [jobId=" + jobId + ", jobTitle=" + jobTitle + ", jobType=" + jobType + ", jobStatus=" + jobStatus
				+ ", jobPackage=" + jobPackage + ", jobcriteria=" + jobcriteria + ", company=" + company + "]";
	}*/


	


	
	
	
}
