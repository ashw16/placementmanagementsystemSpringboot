package com.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.placement.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer>
{
	//JPQL with index param
	@Query("select s from StudentEntity s where s.studentName=?1 and s.studentEmail=?2")
	StudentEntity findByStudentNameAndstudentEmailWithIndexParam(String studentName,String studentEmail);
	
	
		//JPQL with Named param
		@Query("select s from StudentEntity s where s.studentName=:studentName and s.studentEmail=:studentEmail")
		StudentEntity findByStudentNameAndstudentEmailWithNamedParam(@Param("studentName")String studentName,@Param("studentEmail") String studentEmail);
	
		//JPQL with Native Query with index param
		@Query(value="select * from student s where s.student_name=?1 and s.student_email=?2",nativeQuery=true)
		StudentEntity findByStudentNameAndstudentEmailWithNativeQueryIndexParam(String studentName,String studentEmail);
	
		//JPQL with Native Query with Named param
		@Query(value="select * from student s where s.student_name=:studentName and s.student_email=:studentEmail",nativeQuery=true)
		StudentEntity findByStudentNameAndstudentEmailWithNativeQueryNamedParam(@Param("studentName")String studentName,@Param("studentEmail") String studentEmail);
}
