package com.placement.service;

import java.util.List;

import com.placement.payload.CompanyDto;

public interface CompanyService 
{
		public CompanyDto addCompany(CompanyDto company);
		
		public List<CompanyDto> getAllCompanies();
		
		public CompanyDto getCompanyById(int companyId);
		
		public void deleteCompanyById(int companyId);
		
		public CompanyDto updateCompanyDetailsById(CompanyDto company,int companyId);
}
