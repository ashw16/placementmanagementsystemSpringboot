package com.placement.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.placement.entity.JobEntity;
import com.placement.entity.StudentEntity;
@DataJpaTest
public class JobRepositoryTests 
{
	
		@Autowired
		private JobRepository jobRepository;
		
		@Test
		@DisplayName("Junit test for save job operation...")
		public void givenJobObject_whenSavedJob_thenReturnSavedJob()
		{
			JobEntity job=JobEntity.builder()
					.jobTitle("Development")
					.jobType("Backend-Development")
					.jobStatus("Active")
					.jobcriteria("60% through out academics")
					.jobPackage("5-LPA")
					.build();
			JobEntity savedJob=jobRepository.save(job);
			
			Assertions.assertThat(savedJob).isNotNull();
			Assertions.assertThat(savedJob.getJobId()).isGreaterThan(0);
		}
		
		//get all companies
				@Test
				@DisplayName("Junit test for get all jobs")
				public void givenJobsList_whenFindAllJobsList_then()
				{
					//given
					JobEntity job=JobEntity.builder()
							.jobTitle("Development")
							.jobType("Backend-Development")
							.jobStatus("Active")
							.jobcriteria("60% through out academics")
							.jobPackage("5-LPA")
							.build();
					
					//given
					JobEntity job2=JobEntity.builder()
							.jobTitle("Web-Design")
							.jobType("Frontend-Development")
							.jobStatus("Active")
							.jobcriteria("60% through out academics")
							.jobPackage("4-LPA")
							.build();
					jobRepository.save(job);
					jobRepository.save(job2);
					
					//when
					List<JobEntity> jobList=this.jobRepository.findAll();
					
					//then
					Assertions.assertThat(jobList.size()).isNotNull();
					Assertions.assertThat(jobList.size()).isEqualTo(2);
				}
				
				//get job by Id
				@Test
				@DisplayName("Junit test for get job by id")
				public void givenJobObject_whenFindById_thenReturnedJobObject()
				{
					//given
					JobEntity job=JobEntity.builder()
							.jobTitle("Development")
							.jobType("Backend-Development")
							.jobStatus("Active")
							.jobcriteria("60% through out academics")
							.jobPackage("5-LPA")
							.build();
					
					
					JobEntity savedJob=jobRepository.save(job);
					//when
					JobEntity jobById=this.jobRepository.findById(savedJob.getJobId()).get();
					
					//then
					Assertions.assertThat(jobById).isNotNull();
					Assertions.assertThat(jobById.getJobId()).isGreaterThan(0);	
					Assertions.assertThat(jobById.getJobId()).isEqualTo(savedJob.getJobId());
				}	
				
				//update job 
				@Test
				@DisplayName("Junit test for update job")
				public void givenJobObject_whenUpdatedJob_thenReturnUpdatedJob()
				{	
					//given
					JobEntity job=JobEntity.builder()
							.jobTitle("Development")
							.jobType("Backend-Development")
							.jobStatus("Active")
							.jobcriteria("60% through out academics")
							.jobPackage("5-LPA")
							.build();
					JobEntity savedJob=jobRepository.save(job);
					//when
					JobEntity jobDB=this.jobRepository.findById(savedJob.getJobId()).get();	
					
					jobDB.setJobType("Backend-Development coding part");
					JobEntity updateJob=jobRepository.save(jobDB);
					//then
						
					Assertions.assertThat(jobDB.getJobType()).isEqualTo("Backend-Development coding part");
					Assertions.assertThat(jobDB.getJobTitle()).isEqualTo("Development");
					
				}
				
				//delete job
				@Test
				@DisplayName("Junit test for delete job")
				public void givenJobObject_whenDeleteJob_thenDeleteJobNull()
				{
					///given
					JobEntity job=JobEntity.builder()
							.jobTitle("Development")
							.jobType("Backend-Development")
							.jobStatus("Active")
							.jobcriteria("60% through out academics")
							.jobPackage("5-LPA")
							.build();
					JobEntity savedJob=jobRepository.save(job);
					//when
					JobEntity jobDB=this.jobRepository.findById(savedJob.getJobId()).get();	
					
					this.jobRepository.delete(jobDB);
					Optional<JobEntity> jobDB2=this.jobRepository.findById(job.getJobId());
					
					//then	
					Assertions.assertThat(jobDB2).isEmpty();
					
				}
				
				
				
				//JPQL with Named parameter
				@Test
				@DisplayName("JUNIT Test for custom query using JPQL with Named parameter")
				public void givenJobTitleAndJobType_whenFindByJPQLNamed_thenReturnJobObject()
				{
					//given
					JobEntity job=JobEntity.builder()
							.jobTitle("Development")
							.jobType("Backend-Development")
							.jobStatus("Active")
							.jobcriteria("60% through out academics")
							.jobPackage("5-LPA")
							.build();
					JobEntity savedJob=jobRepository.save(job);
					
					//when
					JobEntity jobObj=this.jobRepository.
							findByJobTitleAndJobTypeWithNamedParam(job.getJobTitle(),job.getJobType());
					
					//then 
					Assertions.assertThat(savedJob).isNotNull();
					Assertions.assertThat(savedJob.getJobId()).isGreaterThan(0);
				}
				
				
				//JPQL with NativeSQL Indexed parameter
				@Test
				@DisplayName("JUNIT Test for custom query using JPQL with NativeSQL INDEX parameter")
				public void givenJobTitleAndJobType_whenFindByJPQLNativeSQLIndexParam_thenReturnJobObject()
				{
					///given
					JobEntity job=JobEntity.builder()
							.jobTitle("Development")
							.jobType("Backend-Development")
							.jobStatus("Active")
							.jobcriteria("60% through out academics")
							.jobPackage("5-LPA")
							.build();
					JobEntity savedJob=jobRepository.save(job);
					
					//when
					JobEntity jobObj=this.jobRepository.findByJobTitleAndJobTypeWithNativeQueryIndexParam(job.getJobTitle(),job.getJobType());
					
					//then 
					Assertions.assertThat(jobObj).isNotNull();
				}
				
				//JPQL with NativeSQL Named parameter
				@Test
				@DisplayName("JUNIT Test for custom query using JPQL with NativeSQL Named parameter")
				public void givenJobTitleAndJobType_whenFindByJPQLNativeSQLNamedParam_thenReturnJobObject()
				{
					///given
					JobEntity job=JobEntity.builder()
							.jobTitle("Development")
							.jobType("Backend-Development")
							.jobStatus("Active")
							.jobcriteria("60% through out academics")
							.jobPackage("5-LPA")
							.build();
					JobEntity savedJob=jobRepository.save(job);
					
					//when
					JobEntity jobObj=this.jobRepository.findByJobTitleAndJobTypeWithNativeQueryNamedParam(job.getJobTitle(),job.getJobType());
					
					//then 
					Assertions.assertThat(jobObj).isNotNull();
				}
				
				//JPQL 	WITH Indexed parameter
				@Test
				@DisplayName("JUNIT Test for custom query using JPQL with INDEX parameter")
				public void givenJobTitleAndJobType_whenFindByJPQLIndex_thenReturnJobObject()
				{
					///given
					JobEntity job=JobEntity.builder()
							.jobTitle("Development")
							.jobType("Backend-Development")
							.jobStatus("Active")
							.jobcriteria("60% through out academics")
							.jobPackage("5-LPA")
							.build();
					JobEntity savedJob=jobRepository.save(job);
					
					//when
					JobEntity jobObj=this.jobRepository.findByJobTitleAndJobTypeWithIndexParam(job.getJobTitle(),job.getJobType());
					
					//then 
					Assertions.assertThat(savedJob).isNotNull();
					Assertions.assertThat(savedJob.getJobId()).isGreaterThan(0);
				}
				
				
}
