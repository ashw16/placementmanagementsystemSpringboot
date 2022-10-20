package com.placement.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.placement.entity.ApplyJobEntity;
import com.placement.entity.StudentEntity;

@DataJpaTest
public class ApplyJobRepositoryTests 
{
	@Autowired
	private ApplyJobRepository applyjobRepository;
	
	@Test
	@DisplayName("Junit test for save applyJob operation...")
	public void givenApplyJobObject_whenSavedApplyJob_thenReturnSavedApplyJob()
	{
		ApplyJobEntity applyjob=ApplyJobEntity.builder()
				.jobId(1)
				.applyJobStatus(true)
				.companyId(1)
				.isStudentPlaced(true)
				.build();
		ApplyJobEntity savedapplyJob=applyjobRepository.save(applyjob);
		
		Assertions.assertThat(savedapplyJob).isNotNull();
		Assertions.assertThat(savedapplyJob.getApplyJobId()).isGreaterThan(0);
	}
	
	//get all appliedJobs
	@Test
	@DisplayName("Junit test for get all appliedjobs")
	public void givenAppliedJobsList_whenFindAllAppliedJobsList_then()
	{
		//Given
		ApplyJobEntity applyjob=ApplyJobEntity.builder()
				.jobId(1)
				.applyJobStatus(true)
				.companyId(1)
				.isStudentPlaced(true)
				.build();
		//Given
		ApplyJobEntity applyjob2=ApplyJobEntity.builder()
				.jobId(2)
				.applyJobStatus(true)
				.companyId(2)
				.isStudentPlaced(true)
				.build();
		
		applyjobRepository.save(applyjob);
		applyjobRepository.save(applyjob2);
		
		//when
		List<ApplyJobEntity> appliedjobList=this.applyjobRepository.findAll();
		
		//then
		Assertions.assertThat(appliedjobList.size()).isNotNull();
		Assertions.assertThat(appliedjobList.size()).isEqualTo(2);
		
	}
	
	//get applyJob by Id
	@Test
	@DisplayName("Junit test for get applyJob by id")
	public void givenApplyJobObject_whenFindById_thenReturnedApplyJobObject()
	{
		//Given
				ApplyJobEntity applyjob=ApplyJobEntity.builder()
						.jobId(1)
						.applyJobStatus(true)
						.companyId(1)
						.isStudentPlaced(true)
						.build();
				ApplyJobEntity savedApplyJob=applyjobRepository.save(applyjob);
		//when
				ApplyJobEntity applyJobById=this.applyjobRepository.findById(savedApplyJob.getApplyJobId()).get();
				
		//then
				Assertions.assertThat(applyJobById).isNotNull();
				Assertions.assertThat(applyJobById.getApplyJobId()).isGreaterThan(0);	
				Assertions.assertThat(applyJobById.getApplyJobId()).isEqualTo(savedApplyJob.getApplyJobId());
	}
	
	//update applyJob 
	@Test
	@DisplayName("Junit test for update applyJob")
	public void givenApplyJobObject_whenUpdatedApplyJob_thenReturnUpdatedApplyJob()
	{
		//Given
		ApplyJobEntity applyjob=ApplyJobEntity.builder()
				.jobId(1)
				.applyJobStatus(true)
				.companyId(1)
				.isStudentPlaced(true)
				.build();
		ApplyJobEntity savedApplyJob=applyjobRepository.save(applyjob);
		
		//when
		ApplyJobEntity applyJobDB=this.applyjobRepository.findById(savedApplyJob.getApplyJobId()).get();	
		applyJobDB.setJobId(2);
		ApplyJobEntity updateApplyJob=applyjobRepository.save(applyJobDB);
		//then
			
		Assertions.assertThat(applyJobDB.getJobId()).isEqualTo(2);
		Assertions.assertThat(applyJobDB.getApplyJobId()).isEqualTo(savedApplyJob.getApplyJobId());
	}
	
	//delete applyJob
	@Test
	@DisplayName("Junit test for delete applyJob")
	public void givenApplyJobObject_whenDeleteApplyJob_thenDeleteApplyJobNull()
	{
		//Given
				ApplyJobEntity applyjob=ApplyJobEntity.builder()
						.jobId(1)
						.applyJobStatus(true)
						.companyId(1)
						.isStudentPlaced(true)
						.build();
				ApplyJobEntity savedApplyJob=applyjobRepository.save(applyjob);
				
				//when
				ApplyJobEntity applyJobDB=this.applyjobRepository.findById(savedApplyJob.getApplyJobId()).get();	
				
				this.applyjobRepository.delete(applyJobDB);
				Optional<ApplyJobEntity> applyJobDB2=this.applyjobRepository.findById(applyjob.getApplyJobId());
				
				//then	
				Assertions.assertThat(applyJobDB2).isEmpty();
	}
	
	//JPQL 	WITH Indexed parameter
		@Test
		@DisplayName("JUNIT Test for custom query using JPQL with INDEX parameter")
		public void givenJobIdAndCompanyId_whenFindByJPQLIndex_thenReturnApplyJobObject()
		{
			//given
			ApplyJobEntity applyJob=ApplyJobEntity.builder()
					.jobId(1)
					.companyId(1)
					.isStudentPlaced(true)
					.applyJobStatus(true)
					.build();
			ApplyJobEntity savedApplyJob=applyjobRepository.save(applyJob);
			
			//when
			ApplyJobEntity applyJobObj=this.applyjobRepository
					.findByJobIdAndCompanyIdWithIndexParam(applyJob.getJobId(),applyJob.getCompanyId());
			
			//then 
			Assertions.assertThat(savedApplyJob).isNotNull();
			Assertions.assertThat(savedApplyJob.getApplyJobId()).isGreaterThan(0);
		}
		
		//JPQL with Named parameter
		@Test
		@DisplayName("JUNIT Test for custom query using JPQL with Named parameter")
		public void givenJobIdAndCompanyId_whenFindByJPQLNamed_thenReturnApplyJobObject()
		{
			//given
			ApplyJobEntity applyJob=ApplyJobEntity.builder()
					.jobId(1)
					.companyId(1)
					.isStudentPlaced(true)
					.applyJobStatus(true)
					.build();
			ApplyJobEntity savedApplyJob=applyjobRepository.save(applyJob);
			
			//when
			ApplyJobEntity applyJobObj=this.applyjobRepository.
					findByJobIdAndCompanyIdWithNamedParam(applyJob.getJobId(),applyJob.getCompanyId());
			
			//then 
			Assertions.assertThat(savedApplyJob).isNotNull();
			Assertions.assertThat(savedApplyJob.getJobId()).isGreaterThan(0);
		}
		
		//JPQL with NativeSQL Named parameter GetAppliedJobsByStudentId
		@Test
		@DisplayName("JUNIT Test for custom query using JPQL with NativeSQL Named parameter")
		public void givenStudentId_whenGetAppliedJobsByJPQLNativeSQLNamedParam_thenReturnApplyJobObject()
		{
			//given
			ApplyJobEntity applyJob=ApplyJobEntity.builder()
					.jobId(1)
					.companyId(1)
					.isStudentPlaced(true)
					.applyJobStatus(true)
					.build();
		}
		
		
		
}
