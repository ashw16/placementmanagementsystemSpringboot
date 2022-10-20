package com.placement.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.entity.StudentEntity;
import com.placement.payload.StudentDto;
import com.placement.repository.StudentRepository;
import com.placement.service.StudentService;
import com.placement.exception.ResourceNotFoundException;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//addStudent
	@Override
	public StudentDto addStudent( StudentDto studentDto) 
	{
		StudentEntity studentEntity=this.modelMapper.map(studentDto, StudentEntity.class);
		StudentEntity savedstudent=this.studentRepository.save(studentEntity);
		return this.modelMapper.map(savedstudent, StudentDto.class);
	}
	
	
	//getAllStudents
	@Override
	public List<StudentDto> getAllStudents() 
	{
		List<StudentEntity> studentlist=this.studentRepository.findAll();
		List<StudentDto> studentDtolist=studentlist.stream().map((student)->
		this.modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
		return studentDtolist;
	}
	
	
	//getStudentById
	@Override
	public StudentDto getStudentById(int studentId) {
		StudentEntity studentEntity=this.studentRepository.findById(studentId).orElseThrow(()->
		new com.placement.exception.ResourceNotFoundException("student","student id", studentId));
		return this.modelMapper.map(studentEntity, StudentDto.class);
		
	}
	
	//deleteStudentById
	@Override
	public void deleteStudentById(int studentId) 
	{
		this.studentRepository.findById(studentId).orElseThrow(()->
		new ResourceNotFoundException("student","student id", studentId));
		this.studentRepository.deleteById(studentId);
		
	}

	//updateStudent
	@Override
	public StudentDto updateStudent(StudentDto studentDto, int studentId) {
		StudentEntity studentobj=this.studentRepository.findById(studentId).orElseThrow(()->
		new ResourceNotFoundException("student","student id", studentId));
		studentDto.setStudentId(studentId);
		StudentEntity updatestudent=this.modelMapper.map(studentDto, StudentEntity.class);
		StudentEntity student=this.studentRepository.save(updatestudent);
		return this.modelMapper.map(student, StudentDto.class);
	}	
}
