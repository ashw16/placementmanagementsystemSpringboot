package com.placement.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.placement.entity.StudentEntity;

@DataJpaTest
public class StudentRepositoryTests 
{
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	@DisplayName("Junit test for save student operation...")
	public void givenStudentObject_whenSavedStudent_thenReturnSavedStudent()
	{
		StudentEntity student=StudentEntity.builder().studentName("aman")
				.studentDOB("26-07-1999")
				.studentEmail("aman@gmail.com")
				.studentContact("1234567891")
				.studentGender("male")
				.studentPassword("12345")
				.studentAddress("Hubli")
				.studentBranch("BE/CS")
				.studentCGPA("7.5")
				.build();
		StudentEntity savedStudent=studentRepository.save(student);
		
		Assertions.assertThat(savedStudent).isNotNull();
		Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
	}
	
	//get all students
	@Test
	@DisplayName("Junit test for get all students")
	public void givenStudentsList_whenFindAllStudentsList_then()
	{
		//given
		StudentEntity student=StudentEntity.builder()
				.studentName("aman")
				.studentDOB("26-07-1999")
				.studentEmail("aman@gmail.com")
				.studentContact("1234567891")
				.studentGender("male")
				.studentPassword("12345")
				.studentAddress("Hubli")
				.studentBranch("BE/CS")
				.studentCGPA("7.5")
				.build();
		
		//given
				StudentEntity student2=StudentEntity.builder()
						.studentName("Raman")
						.studentDOB("06-09-1997")
						.studentEmail("Raman@gmail.com")
						.studentContact("8050364576")
						.studentGender("male")
						.studentPassword("12345")
						.studentAddress("Hubli")
						.studentBranch("BE/EEE")
						.studentCGPA("8.5")
						.build();
		studentRepository.save(student);
		studentRepository.save(student2);
		
		//when
		List<StudentEntity> studentList=this.studentRepository.findAll();
		
		//then
		Assertions.assertThat(studentList.size()).isNotNull();
		Assertions.assertThat(studentList.size()).isEqualTo(2);
	}
	
	//get student by Id
		@Test
		@DisplayName("Junit test for get student by id")
		public void givenStudentObject_whenFindById_thenReturnedStudentObject()
		{
			//given
			StudentEntity student=StudentEntity.builder()
					.studentName("aman")
					.studentDOB("26-07-1999")
					.studentEmail("aman@gmail.com")
					.studentContact("1234567891")
					.studentGender("male")
					.studentPassword("12345")
					.studentAddress("Hubli")
					.studentBranch("BE/CS")
					.studentCGPA("7.5")
					.build();
			
			
			StudentEntity savedStudent=studentRepository.save(student);
			//when
			StudentEntity studentById=this.studentRepository.findById(savedStudent.getStudentId()).get();
			
			//then
			Assertions.assertThat(studentById).isNotNull();
			Assertions.assertThat(studentById.getStudentId()).isGreaterThan(0);	
			Assertions.assertThat(studentById.getStudentId()).isEqualTo(savedStudent.getStudentId());
		}
		

		//update student 
				@Test
				@DisplayName("Junit test for update student")
				public void givenStudentObject_whenUpdatedStudent_thenReturnUpdatedStudent()
				{
					//given
					StudentEntity student=StudentEntity.builder()
							.studentName("aman")
							.studentDOB("26-07-1999")
							.studentEmail("aman@gmail.com")
							.studentContact("1234567891")
							.studentGender("male")
							.studentPassword("12345")
							.studentAddress("Hubli")
							.studentBranch("BE/CS")
							.studentCGPA("7.5")
							.build();
					
					
					StudentEntity savedStudent=studentRepository.save(student);
					//when
					StudentEntity studentDB=this.studentRepository.findById(student.getStudentId()).get();
					
					studentDB.setStudentEmail("amankumar@gmail.com");
					StudentEntity updateStudent=studentRepository.save(studentDB);
					//then
						
					Assertions.assertThat(studentDB.getStudentEmail()).isEqualTo("amankumar@gmail.com");
					Assertions.assertThat(studentDB.getStudentContact()).isEqualTo("1234567891");
					
				}		
				
				//delete student
				@Test
				@DisplayName("Junit test for delete student")
				public void givenStudentObject_whenDeleteStudent_thenDeleteStudentNull()
				{
					//given
					StudentEntity student=StudentEntity.builder()
							.studentName("aman")
							.studentDOB("26-07-1999")
							.studentEmail("aman@gmail.com")
							.studentContact("1234567891")
							.studentGender("male")
							.studentPassword("12345")
							.studentAddress("Hubli")
							.studentBranch("BE/CS")
							.studentCGPA("7.5")
							.build();
					
					
					StudentEntity savedStudent=studentRepository.save(student);
					//when
					StudentEntity studentDB=this.studentRepository.findById(student.getStudentId()).get();
					
					this.studentRepository.delete(studentDB);
					Optional<StudentEntity> studentDB2=this.studentRepository.findById(student.getStudentId());
					//then
						
					Assertions.assertThat(studentDB2).isEmpty();
					
				}
	
	
	
	
	
	//JPQL 	WITH Indexed parameter
	@Test
	@DisplayName("JUNIT Test for custom query using JPQL with INDEX parameter")
	public void givenStudentNameAndStudentEmail_whenFindByJPQLIndex_thenReturnStudentObject()
	{
		//given
		StudentEntity student=StudentEntity.builder().studentName("aman")
				.studentDOB("26-07-1999")
				.studentEmail("aman@gmail.com")
				.studentContact("1234567891")
				.studentGender("male")
				.studentPassword("12345")
				.studentAddress("Hubli")
				.studentBranch("BE/CS")
				.studentCGPA("7.5")
				.build();
		StudentEntity savedStudent=studentRepository.save(student);
		
		//when
		StudentEntity studentObj=this.studentRepository.findByStudentNameAndstudentEmailWithIndexParam(student.getStudentName(),student.getStudentEmail());
		
		//then 
		Assertions.assertThat(savedStudent).isNotNull();
		Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
	}
	
	
	
	//JPQL with Named parameter
	@Test
	@DisplayName("JUNIT Test for custom query using JPQL with Named parameter")
	public void givenStudentNameAndStudentEmail_whenFindByJPQLNamed_thenReturnStudentObject()
	{
		//given
		StudentEntity student=StudentEntity.builder().studentName("aman")
				.studentDOB("26-07-1999")
				.studentEmail("aman@gmail.com")
				.studentContact("1234567891")
				.studentGender("male")
				.studentPassword("12345")
				.studentAddress("Hubli")
				.studentBranch("BE/CS")
				.studentCGPA("7.5")
				.build();
		StudentEntity savedStudent=studentRepository.save(student);
		
		//when
		StudentEntity studentObj=this.studentRepository.
				findByStudentNameAndstudentEmailWithNamedParam(student.getStudentName(),student.getStudentEmail());
		
		//then 
		Assertions.assertThat(savedStudent).isNotNull();
		Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
	}
	
	
	
	   //JPQL with NativeSQL Indexed parameter
		@Test
		@DisplayName("JUNIT Test for custom query using JPQL with NativeSQL INDEX parameter")
		public void givenStudentNameAndStudentEmail_whenFindByJPQLNativeSQLIndexParam_thenReturnStudentObject()
		{
			//given
			StudentEntity student=StudentEntity.builder().studentName("aman")
					.studentDOB("26-07-1999")
					.studentEmail("aman@gmail.com")
					.studentContact("1234567891")
					.studentGender("male")
					.studentPassword("12345")
					.studentAddress("Hubli")
					.studentBranch("BE/CS")
					.studentCGPA("7.5")
					.build();
			StudentEntity savedStudent=studentRepository.save(student);
			
			//when
			StudentEntity studentObj=this.studentRepository.findByStudentNameAndstudentEmailWithNativeQueryIndexParam(student.getStudentName(),student.getStudentEmail());
			
			//then 
			Assertions.assertThat(studentObj).isNotNull();
			
		}
		
		
		
		
		//JPQL with NativeSQL Named parameter
				@Test
				@DisplayName("JUNIT Test for custom query using JPQL with NativeSQL Named parameter")
				public void givenStudentNameAndStudentEmail_whenFindByJPQLNativeSQLNamedParam_thenReturnStudentObject()
				{
					//given
					StudentEntity student=StudentEntity.builder()
							.studentName("aman")
							.studentDOB("26-07-1999")
							.studentEmail("aman@gmail.com")
							.studentContact("1234567891")
							.studentGender("male")
							.studentPassword("12345")
							.studentAddress("Hubli")
							.studentBranch("BE/CS")
							.studentCGPA("7.5")
							.build();
					StudentEntity savedStudent=studentRepository.save(student);
					
					//when
					StudentEntity studentObj=this.studentRepository.
							findByStudentNameAndstudentEmailWithNativeQueryNamedParam(student.getStudentName(),student.getStudentEmail());
					
					//then 
					Assertions.assertThat(studentObj).isNotNull();
					
				}
		
		
}
