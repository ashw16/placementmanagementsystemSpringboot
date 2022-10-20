package com.placement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.placement.entity.ApplyJobEntity;
import com.placement.entity.StudentEntity;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity,Integer>{
	//JPQL with Native Query with Named param
	@Query(value="Select * from applyjob aj where aj.student_id=:sid",nativeQuery=true)
	List<ApplyJobEntity> getAppliedJobsByStudentId(@Param("sid") int sid);
	
	//JPQL with Native Query with Named param
	@Query(value="Select * from applyjob aj where aj.student_id=:sid and aj.job_id=:jid",nativeQuery=true)
	List<ApplyJobEntity> updatePlacedStudentByStudentIdAndJobId(@Param("sid") int sid,@Param("jid") int jid);
	
	//JPQL with Native Query with Named param
	@Query(value="Select * from applyjob aj where aj.is_student_placed=:isStudentPlaced",nativeQuery=true)
	List<ApplyJobEntity> getAllPlacedStudents(@Param("isStudentPlaced") boolean isStudentPlaced);
	
	//JPQL with index param
	@Query("select s from ApplyJobEntity s where s.jobId=?1 and s.companyId=?2")
	ApplyJobEntity findByJobIdAndCompanyIdWithIndexParam(int jobId,int companyId);
		
		
	//JPQL with Named param
	@Query("select s from ApplyJobEntity s where s.jobId=:jobId and s.companyId=:companyId")
	ApplyJobEntity findByJobIdAndCompanyIdWithNamedParam(@Param("jobId")int jobId,@Param("companyId") int companyId);
}
