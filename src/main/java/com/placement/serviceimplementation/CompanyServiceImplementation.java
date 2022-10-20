package com.placement.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.entity.CompanyEntity;
import com.placement.exception.ResourceNotFoundException;
import com.placement.payload.CompanyDto;
import com.placement.repository.CompanyRepository;
import com.placement.service.CompanyService;
@Service
public class CompanyServiceImplementation implements CompanyService
{

	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//addCompany
	@Override
	public CompanyDto addCompany(CompanyDto companyDto) {
		CompanyEntity companyEntity=this.modelMapper.map(companyDto, CompanyEntity.class);
		CompanyEntity savedcompany=this.companyRepository.save(companyEntity);
		return this.modelMapper.map(savedcompany, CompanyDto.class);
	}

	@Override
	public List<CompanyDto> getAllCompanies() {
		List<CompanyEntity> companyList=this.companyRepository.findAll();
		
		List<CompanyDto> companyDtoList=companyList.stream().
				map((company)->this.modelMapper.
				map(company, CompanyDto.class)).
				collect(Collectors.toList());
		
		
		System.out.println(companyDtoList);
		
		return companyDtoList;
	}

	@Override
	public CompanyDto getCompanyById(int companyId) {
		CompanyEntity companyEntity=this.companyRepository.findById(companyId).orElseThrow(()->
		new ResourceNotFoundException("job","job id", companyId));
		return this.modelMapper.map(companyEntity, CompanyDto.class);
	}

	@Override
	public void deleteCompanyById(int companyId) {
		this.companyRepository.findById(companyId).orElseThrow(()->
		new ResourceNotFoundException("company","company id", companyId));
		this.companyRepository.deleteById(companyId);
		
	}

	@Override
	public CompanyDto updateCompanyDetailsById(CompanyDto companyDto, int companyId) {
		CompanyEntity companyobj=this.companyRepository.findById(companyId).orElseThrow(()->
		new ResourceNotFoundException("company","company id", companyId));
		CompanyEntity updatecompany=this.modelMapper.map(companyDto, CompanyEntity.class);
		CompanyEntity company=this.companyRepository.save(updatecompany);
		return this.modelMapper.map(company, CompanyDto.class);
	}
	
	
	
	
	

}
