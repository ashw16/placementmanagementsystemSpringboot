package com.placement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.exception.ApiResponse;
import com.placement.payload.CompanyDto;
import com.placement.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController 
{
	@Autowired
	private CompanyService companyservice;
	
		//getcompanyById
		@GetMapping("/{companyId}")
		public ResponseEntity<CompanyDto> getCompanyById(@PathVariable("companyId") int companyId)
		{
			CompanyDto company= this.companyservice.getCompanyById(companyId);
			return new ResponseEntity<CompanyDto>(company,HttpStatus.OK);
			
		}
		
		//addCompany
		@PostMapping("/")
		public CompanyDto addCompany(@Valid @RequestBody CompanyDto company)
		{	
	
			return this.companyservice.addCompany(company);
			
		}
		
		//getAllCompanies
		@GetMapping("/")
		public ResponseEntity<List<CompanyDto>> getAllCompanies()
		{
			List<CompanyDto> allCompanies=this.companyservice.getAllCompanies();
			return new ResponseEntity<>(allCompanies,HttpStatus.OK);
		}
		
		//deleteCompany
		@DeleteMapping("/{companyId}")
		public ResponseEntity<ApiResponse> deleteCompany(@PathVariable("companyId") int companyId)
		{
			this.companyservice.deleteCompanyById(companyId);
			ApiResponse response=new ApiResponse("Company record is deleted",true);
			return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		}
		
		//updateCompanyDetails
		@PutMapping("/{companyId}")
		public ResponseEntity<CompanyDto> updateCompanyDetailsById(@Valid @RequestBody CompanyDto company,
													@PathVariable("companyId") int companyId)
		{
			CompanyDto updateCompany=this.companyservice.updateCompanyDetailsById(company, companyId);
			return new ResponseEntity<CompanyDto>(updateCompany,HttpStatus.OK);
			
		}
}	
