package com.placement.service;

import java.util.List;

import com.placement.payload.StudentDto;

public interface StudentService 
{
	public StudentDto addStudent(StudentDto student);
	
	public List<StudentDto> getAllStudents();
	
	public StudentDto getStudentById(int studentId);
	
	public void deleteStudentById(int studentId);
	
	public StudentDto updateStudent(StudentDto student,int studentId);
	
	
}
