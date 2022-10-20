package com.placement.service;

import java.util.List;

import com.placement.payload.JobDto;

public interface JobService 
{
public JobDto addJob(JobDto job);
	
	public List<JobDto> getAllJobs();
	
	public JobDto getJobById(int jobId);
	
	public void deleteJobById(int jobId);
	
	public JobDto updateJobDetails(JobDto job,int jobId);
}
