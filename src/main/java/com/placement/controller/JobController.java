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
import com.placement.payload.JobDto;
import com.placement.service.JobService;
@RequestMapping("/job")
@RestController
public class JobController 
{
	@Autowired
	private JobService jobservice;
	
	
	//getjobById
	@GetMapping("/{jobId}")
	public ResponseEntity<JobDto> getJobById(@PathVariable("jobId") int jobId)
	{
		JobDto job= this.jobservice.getJobById(jobId);
		return new ResponseEntity<JobDto>(job,HttpStatus.OK);
		
	}
	
	
	//addJobs
	@PostMapping("/")
	public JobDto addStudent(@Valid @RequestBody JobDto job)
	{	
		//StudentDto newStudent= this.studentservice.addStudent(student);
		return this.jobservice.addJob(job);
		
	}
	
	
	//getAllJobs
	@GetMapping("/")
	public ResponseEntity<List<JobDto>> getAllJobs()
	{
		List<JobDto> allJobs=this.jobservice.getAllJobs();
		return new ResponseEntity<>(allJobs,HttpStatus.OK);
	}
	
	
	//deleteJob
	@DeleteMapping("/{jobId}")
	public ResponseEntity<ApiResponse> deleteJob(@PathVariable("jobId") int jobId)
	{
		this.jobservice.deleteJobById(jobId);
		ApiResponse response=new ApiResponse("Job record is deleted",true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
	
	//updateJob
	@PutMapping("/{jobId}")
	public ResponseEntity<JobDto> updateJobDetails(@Valid @RequestBody JobDto job,
												@PathVariable("jobId") int jobId)
	{
		JobDto updateJob=this.jobservice.updateJobDetails(job, jobId);
		return new ResponseEntity<JobDto>(updateJob,HttpStatus.OK);
		
	}
}
