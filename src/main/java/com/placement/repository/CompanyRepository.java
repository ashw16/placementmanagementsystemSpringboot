package com.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.placement.entity.CompanyEntity;
import com.placement.entity.StudentEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity,Integer> {
	//JPQL with Native Query with index param
	@Query(value="select * from company s where s.company_name=?1 and s.company_type=?2",nativeQuery=true)
	CompanyEntity findByCompanyNameAndCompanyTypeWithNativeQueryIndexParam(String companyName,String companyType);

	//JPQL with index param
	@Query("select s from CompanyEntity s where s.companyName=?1 and s.companyType=?2")
	CompanyEntity findByCompanyNameAndCompanyTypeWithIndexParam(String companyName,String companyType);

	//JPQL with Named param
	@Query("select s from CompanyEntity s where s.companyName=:companyName and s.companyType=:companyType")
	CompanyEntity findByCompanyNameAndCompanyTypeWithNamedParam(@Param("companyName")String companyName,@Param("companyType") String companyType);

	//JPQL with Native Query with Named param
	@Query(value="select * from company s where s.company_name=:companyName and s.company_type=:companyType",nativeQuery=true)
	CompanyEntity findByCompanyNameAndCompanyTypeWithNativeQueryNamedParam(@Param("companyName")String companyName,@Param("companyType") String companyType);

}
