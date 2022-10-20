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
import com.placement.payload.StudentDto;
import com.placement.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService studentservice;
	
	
	//getStudentById
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId") int studentId)
	{
		StudentDto student= this.studentservice.getStudentById(studentId);
		return new ResponseEntity<StudentDto>(student,HttpStatus.OK);
		
	}
	
	//addStudent
	@PostMapping("/")
	public StudentDto addStudent(@Valid @RequestBody StudentDto student)
	{	
		//StudentDto newStudent= this.studentservice.addStudent(student);
		return this.studentservice.addStudent(student);
		
	}
	
	//getAllStudents
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> getAllStudents()
	{
		List<StudentDto> allStudents=this.studentservice.getAllStudents();
		return new ResponseEntity<>(allStudents,HttpStatus.OK);
	}
	
	
	//deleteStudent
	@DeleteMapping("/{studentId}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("studentId") int studentId)
	{
		this.studentservice.deleteStudentById(studentId);
		ApiResponse response=new ApiResponse("Student record is deleted",true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
	
	//updateStudent
	@PutMapping("/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto student,
												@PathVariable("studentId") int studentId)
	{
		StudentDto updateStudent=this.studentservice.updateStudent(student, studentId);
		return new ResponseEntity<StudentDto>(updateStudent,HttpStatus.OK);
		
	}
}