package com.placement.service;

import java.util.List;

import com.placement.payload.ApplyJobDto;
import com.placement.payload.JobDto;

public interface ApplyJobService 
{
	public ApplyJobDto applyJob(ApplyJobDto applyJob);
	
	public List<ApplyJobDto> getAllAppliedJobs();
	
	public ApplyJobDto getapplyJobById(int applyJobId);
	
	public void deleteapplyJobById(int applyJobId);
	
	public ApplyJobDto updateAppliedJobDetails(ApplyJobDto applyJob,int applyJobId);
	
	public List<JobDto> getAllAppliedJobsByStudentId(int studentId);
	
	public List<ApplyJobDto> updatePlacedStudentList(List<ApplyJobDto> applyJobList);
	
	public ApplyJobDto updatePlacedStudentByJobIdAndStudentId(int studentId,int jobId);
}
