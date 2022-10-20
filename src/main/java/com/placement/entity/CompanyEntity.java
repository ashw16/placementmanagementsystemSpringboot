package com.placement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="company")
@Builder
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class CompanyEntity 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="companyId")
	private int companyId;
	
	@Column(nullable=false)
	@NotEmpty(message="Company name can not be empty")
	@Size(min=2,max=20,message="Company name must be minimum 2 characters and maximum 20 characters")
	private String companyName;
	
	@Column(nullable=false)
	@NotEmpty(message="Company type can not be empty")
	@Size(min=2,max=20,message="Company Type must be minimum 2 characters and maximum 20 characters")
	private String companyType;
	
	@Column(nullable=false)
	@NotEmpty(message="Company Description can not be empty")
	@Size(min=2,max=50,message="Company Description must be minimum 2 characters and maximum 50 characters")
	private String companyDescription;
	
	
	@OneToMany(mappedBy="company",cascade=CascadeType.ALL)
	//@JsonIgnore
	List<JobEntity> jobPostList=new ArrayList();

	

//	@Override
//	public String toString() {
//		return "CompanyEntity [companyId=" + companyId + ", companyName=" + companyName + ", companyType=" + companyType
//				+ ", companyDescription=" + companyDescription + ", jobPostList=" + jobPostList + "]";
//	}

	
	
	
	
	
}
