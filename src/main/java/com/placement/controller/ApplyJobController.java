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
import com.placement.payload.ApplyJobDto;
import com.placement.payload.JobDto;
import com.placement.service.ApplyJobService;


@RequestMapping("/applyJob")
@RestController
public class ApplyJobController 
{
	@Autowired
	private ApplyJobService applyjobservice;
	
	//addApplyJob
	@PostMapping("/job/{jobId}/company/{companyId}")
	public ApplyJobDto addApplyJob(@RequestBody ApplyJobDto job,@PathVariable("jobId") int jobId,@PathVariable("companyId") int companyId)
	{	
			
		     job.setApplyJobStatus(true);
		     job.setJobId(jobId);
		     job.setCompanyId(companyId);
		    
		
			return this.applyjobservice.applyJob(job);
			
	}
	
	
	//getAllAppliedJobs
	@GetMapping("/")
	public ResponseEntity<List<ApplyJobDto>> getAllAppliedJobs()
	{
		List<ApplyJobDto> allAppliedJobs=this.applyjobservice.getAllAppliedJobs();
		return new ResponseEntity<>(allAppliedJobs,HttpStatus.OK);
	}
	
	//getapplyJobById
	@GetMapping("/{applyJobId}")
	public ResponseEntity<ApplyJobDto> getAppliedJobById(@PathVariable("applyJobId") int applyJobId)
	{
		ApplyJobDto applyJob= this.applyjobservice.getapplyJobById(applyJobId);
		return new ResponseEntity<ApplyJobDto>(applyJob,HttpStatus.OK);
			
	}
	
	//deleteAppliedJob
	@DeleteMapping("/{applyJobId}")
	public ResponseEntity<ApiResponse> deleteAppliedJob(@PathVariable("applyJobId") int applyJobId)
	{
		this.applyjobservice.deleteapplyJobById(applyJobId);
		ApiResponse response=new ApiResponse("ApplyJob record is deleted",true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
	//updateappliedJobById
	@PutMapping("/{applyJobId}")
	public ResponseEntity<ApplyJobDto> updateappliedJobDetails(@Valid @RequestBody ApplyJobDto applyJob,
													@PathVariable("applyJobId") int applyJobId)
	{
    	ApplyJobDto updateappliedJob=this.applyjobservice.updateAppliedJobDetails(applyJob, applyJobId);
		return new ResponseEntity<ApplyJobDto>(updateappliedJob,HttpStatus.OK);
			
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<List<JobDto>> getApplyJobByStudentId(@PathVariable("studentId")int studentId)
	{
		  List<JobDto>jobList=this.applyjobservice.getAllAppliedJobsByStudentId(studentId);
		  return new ResponseEntity<List<JobDto>>(jobList,HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<List<ApplyJobDto>> updatePlacedStudentList(@RequestBody List<ApplyJobDto> applyJobList)
	{
		   List<ApplyJobDto> updatedList=this.applyjobservice.updatePlacedStudentList(applyJobList);
		return new ResponseEntity<List<ApplyJobDto>>(updatedList,HttpStatus.OK);
	}
	
	@GetMapping("/job/{jobId}/student/{studentId}")
	public ResponseEntity<ApplyJobDto> updatePlacedStudentByJobIdAndStudentId(@PathVariable("jobId") int jobId,@PathVariable("studentId") int studentId)
	{
		ApplyJobDto updateded= this.applyjobservice.updatePlacedStudentByJobIdAndStudentId(studentId, jobId);
		return new ResponseEntity <ApplyJobDto>(updateded,HttpStatus.OK);
		
	}
	
}
