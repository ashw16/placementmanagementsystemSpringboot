package com.placement.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.placement.entity.CompanyEntity;


@DataJpaTest
public class CompanyRepositoryTests 
{
	@Autowired
	private CompanyRepository companyRepository;
	
	@Test
	@DisplayName("Junit test for save company operation...")
	public void givenCompanyObject_whenSavedCompany_thenReturnSavedCompany()
	{
		CompanyEntity company=CompanyEntity.builder()
				.companyName("Amazon")
				.companyType("IT")
				.companyDescription("Amazon is a american based company")
				.build();
		CompanyEntity savedCompany=companyRepository.save(company);
		
		Assertions.assertThat(savedCompany).isNotNull();
		Assertions.assertThat(savedCompany.getCompanyId()).isGreaterThan(0);
	}
	
	//get all companies
		@Test
		@DisplayName("Junit test for get all companies")
		public void givenCompaniesList_whenFindAllCompaniesList_then()
		{
			//given
			CompanyEntity company=CompanyEntity.builder()
					.companyName("Amazon")
					.companyType("IT")
					.companyDescription("Amazon is a american based company")
					.build();
			
			//given
			CompanyEntity company2=CompanyEntity.builder()
					.companyName("Microsoft")
					.companyType("IT")
					.companyDescription("Microsoft is a Top MNC company")
					.build();
			companyRepository.save(company);
			companyRepository.save(company2);
			
			//when
			List<CompanyEntity> companyList=this.companyRepository.findAll();
			
			//then
			Assertions.assertThat(companyList.size()).isNotNull();
			Assertions.assertThat(companyList.size()).isEqualTo(2);
		}
		
		//get company by Id
				@Test
				@DisplayName("Junit test for get company by id")
				public void givenCompanyObject_whenFindById_thenReturnedCompanyObject()
				{
					//given
					CompanyEntity company=CompanyEntity.builder()
							.companyName("Amazon")
							.companyType("IT")
							.companyDescription("Amazon is a american based company")
							.build();
					
					
					CompanyEntity savedCompany=companyRepository.save(company);
					//when
					CompanyEntity companyById=this.companyRepository.findById(savedCompany.getCompanyId()).get();
					
					//then
					Assertions.assertThat(companyById).isNotNull();
					Assertions.assertThat(companyById.getCompanyId()).isGreaterThan(0);	
					Assertions.assertThat(companyById.getCompanyId()).isEqualTo(savedCompany.getCompanyId());
				}
				
				
				//update company 
				@Test
				@DisplayName("Junit test for update company")
				public void givenCompanyObject_whenUpdatedCompany_thenReturnUpdatedCompany()
				{
					//given
					CompanyEntity company=CompanyEntity.builder()
							.companyName("Amazon")
							.companyType("IT")
							.companyDescription("Amazon is a american based company")
							.build();
					
					
					CompanyEntity savedCompany=companyRepository.save(company);
					//when
					CompanyEntity companyDB=this.companyRepository.findById(company.getCompanyId()).get();
					
					companyDB.setCompanyType("IT-BASED");
					CompanyEntity updateCompany=companyRepository.save(companyDB);
					//then
						
					Assertions.assertThat(companyDB.getCompanyType()).isEqualTo("IT-BASED");
					Assertions.assertThat(companyDB.getCompanyName()).isEqualTo("Amazon");
					
				}
				
				//delete company
				@Test
				@DisplayName("Junit test for delete company")
				public void givenCompanyObject_whenDeleteCompany_thenDeleteCompanyNull()
				{
					//given
					CompanyEntity company=CompanyEntity.builder()
							.companyName("Amazon")
							.companyType("IT")
							.companyDescription("Amazon is a american based company")
							.build();
					
					
					CompanyEntity savedCompany=companyRepository.save(company);
					//when
					CompanyEntity companyDB=this.companyRepository.findById(company.getCompanyId()).get();
					
					this.companyRepository.delete(companyDB);
					Optional<CompanyEntity> companyDB2=this.companyRepository.findById(company.getCompanyId());
					//then
						
					Assertions.assertThat(companyDB2).isEmpty();
					
				}
				
	
				//JPQL with Named parameter
				@Test
				@DisplayName("JUNIT Test for custom query using JPQL with Named parameter")
				public void givenCompanyNameAndCompanyType_whenFindByJPQLNamed_thenReturnCompanyObject()
				{
					//given
					CompanyEntity company=CompanyEntity.builder()
							.companyName("Amazon")
							.companyType("IT")
							.companyDescription("Amazon is a american based company")
							.build();
					CompanyEntity savedCompany=companyRepository.save(company);
					
					//when
					CompanyEntity companyObj=this.companyRepository.
							findByCompanyNameAndCompanyTypeWithNamedParam(company.getCompanyName(),company.getCompanyType());
					
					//then 
					Assertions.assertThat(savedCompany).isNotNull();
					Assertions.assertThat(savedCompany.getCompanyId()).isGreaterThan(0);
				}
				
				
				//JPQL with NativeSQL Indexed parameter
				@Test
				@DisplayName("JUNIT Test for custom query using JPQL with NativeSQL INDEX parameter")
				public void givenCompanyNameAndCompanyType_whenFindByJPQLNativeSQLIndexParam_thenReturnCompanyObject()
				{
					//given
					CompanyEntity company=CompanyEntity.builder()
							.companyName("Amazon")
							.companyType("IT")
							.companyDescription("Amazon is a american based company")
							.build();
					CompanyEntity savedCompany=companyRepository.save(company);
					
					//when
					CompanyEntity companyObj=this.companyRepository.findByCompanyNameAndCompanyTypeWithNativeQueryIndexParam(company.getCompanyName(),company.getCompanyType());
					
					//then 
					Assertions.assertThat(companyObj).isNotNull();
				}
				
				//JPQL with NativeSQL Named parameter
				@Test
				@DisplayName("JUNIT Test for custom query using JPQL with NativeSQL Named parameter")
				public void givenCompanyNameAndCompanyType_whenFindByJPQLNativeSQLNamedParam_thenReturnCompanyObject()
				{
					//given
					CompanyEntity company=CompanyEntity.builder()
							.companyName("Amazon")
							.companyType("IT")
							.companyDescription("Amazon is a american based company")
							.build();
					CompanyEntity savedCompany=companyRepository.save(company);
					
					//when
					CompanyEntity companyObj=this.companyRepository.findByCompanyNameAndCompanyTypeWithNativeQueryNamedParam(company.getCompanyName(),company.getCompanyType());
					
					//then 
					Assertions.assertThat(companyObj).isNotNull();
				}
				
				//JPQL 	WITH Indexed parameter
				@Test
				@DisplayName("JUNIT Test for custom query using JPQL with INDEX parameter")
				public void givenCompanyNameAndCompanyType_whenFindByJPQLIndex_thenReturnCompanyObject()
				{
					//given
					CompanyEntity company=CompanyEntity.builder()
							.companyName("Amazon")
							.companyType("IT")
							.companyDescription("Amazon is a american based company")
							.build();
					CompanyEntity savedCompany=companyRepository.save(company);
					
					//when
					CompanyEntity companyObj=this.companyRepository.findByCompanyNameAndCompanyTypeWithIndexParam(company.getCompanyName(),company.getCompanyType());
					
					//then 
					Assertions.assertThat(savedCompany).isNotNull();
					Assertions.assertThat(savedCompany.getCompanyId()).isGreaterThan(0);
				}
}
