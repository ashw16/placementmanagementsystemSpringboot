package com.placement.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.placement.exception.ResourceNotFoundException;
import com.placement.entity.JobEntity;
import com.placement.payload.JobDto;
import com.placement.repository.JobRepository;
import com.placement.service.JobService;

@Service
public class JobServiceImplementation implements JobService
{

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public JobDto addJob(JobDto jobDto) 
	{
		JobEntity jobEntity=this.modelMapper.map(jobDto, JobEntity.class);
		JobEntity savedjob=this.jobRepository.save(jobEntity);
		return this.modelMapper.map(savedjob, JobDto.class);
	}

	@Override
	public List<JobDto> getAllJobs() {
		List<JobEntity> jobList=this.jobRepository.findAll();
		List<JobDto> jobDtoList=jobList.stream().
				map((job)->this.modelMapper.
				map(job, JobDto.class)).
				collect(Collectors.toList());
		return jobDtoList;
	}

	@Override
	public JobDto getJobById(int jobId) {
		JobEntity jobEntity=this.jobRepository.findById(jobId).orElseThrow(()->
		new ResourceNotFoundException("job","job id", jobId));
		return this.modelMapper.map(jobEntity, JobDto.class);
	}

	@Override
	public void deleteJobById(int jobId) 
	{
		this.jobRepository.findById(jobId).orElseThrow(()->
		new ResourceNotFoundException("job","job id", jobId));
		this.jobRepository.deleteById(jobId);
		
	}

	@Override
	public JobDto updateJobDetails(JobDto jobDto, int jobId) 
	{
		JobEntity jobobj=this.jobRepository.findById(jobId).orElseThrow(()->
		new ResourceNotFoundException("job","job id", jobId));
		JobEntity updatejob=this.modelMapper.map(jobDto, JobEntity.class);
		JobEntity job=this.jobRepository.save(updatejob);
		return this.modelMapper.map(job, JobDto.class);
		
	}

}
