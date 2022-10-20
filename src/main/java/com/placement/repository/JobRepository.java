package com.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.placement.entity.JobEntity;
import com.placement.entity.StudentEntity;

public interface JobRepository extends JpaRepository<JobEntity,Integer>
{
	//JPQL with Native Query with index param
			@Query(value="select * from job s where s.job_title=?1 and s.job_type=?2",nativeQuery=true)
			JobEntity findByJobTitleAndJobTypeWithNativeQueryIndexParam(String jobTitle,String jobType);
	
	//JPQL with index param
		@Query("select s from JobEntity s where s.jobTitle=?1 and s.jobType=?2")
		JobEntity findByJobTitleAndJobTypeWithIndexParam(String jobTitle,String jobType);
		
		//JPQL with Named param
		@Query("select s from JobEntity s where s.jobTitle=:jobTitle and s.jobType=:jobType")
		JobEntity findByJobTitleAndJobTypeWithNamedParam(@Param("jobTitle")String jobTitle,@Param("jobType") String jobType);
		
		//JPQL with Native Query with Named param
		@Query(value="select * from job s where s.job_title=:jobTitle and s.job_type=:jobType",nativeQuery=true)
		JobEntity findByJobTitleAndJobTypeWithNativeQueryNamedParam(@Param("jobTitle")String jobTitle,@Param("jobType") String jobType);
}
