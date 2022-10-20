package com.placement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="job")
@Builder
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@ToString
public class JobEntity 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int jobId;
	
	@Column(nullable=false)
	@NotEmpty(message="Job title can not be empty")
	@Size(min=4,max=20,message="Job title must be minimum 4 characters and maximum 20 characters")
	private String jobTitle;
	
	@Column(nullable=false)
	@NotEmpty(message="JobType can not be empty")
	@Size(min=4,max=20,message="JobType must be minimum 4 characters and maximum 20 characters")
	private String jobType;
	
	@Column(nullable=false)
	@NotEmpty(message="JobStatus can not be empty")
	@Size(min=6,max=8,message="JobStatus must be Active or InActive")
	private String jobStatus;
	
	@Column(nullable=false)
	@NotEmpty(message="jobPackage can not be empty")
	@Size(min=3,max=10,message="jobPackage must be minimum 4 characters and maximum 10 characters")
	private String jobPackage;
	
	@Column(nullable=false)
	@NotEmpty(message="jobcriteria can not be empty")
	@Size(min=4,max=30,message="jobcriteria must be minimum 4 characters and maximum 10 characters")
	private String jobcriteria;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="companyId1")
	private CompanyEntity company;


	

	
	

	
	
	
	
	
}
