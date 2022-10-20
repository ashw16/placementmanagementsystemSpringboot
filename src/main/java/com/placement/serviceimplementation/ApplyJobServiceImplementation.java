package com.placement.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.entity.ApplyJobEntity;
import com.placement.entity.JobEntity;
import com.placement.exception.ResourceNotFoundException;
import com.placement.payload.ApplyJobDto;
import com.placement.payload.JobDto;
import com.placement.repository.ApplyJobRepository;
import com.placement.repository.JobRepository;
import com.placement.service.ApplyJobService;
import com.placement.service.JobService;

@Service
public class ApplyJobServiceImplementation implements ApplyJobService{
	
	
	@Autowired
	private ApplyJobRepository applyjobRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public List<com.placement.payload.ApplyJobDto> getAllAppliedJobs() {
		List<ApplyJobEntity> applyJobList=this.applyjobRepository.findAll();
		List<ApplyJobDto> applyJobDtoList=applyJobList.stream().
				map((applyjob)->this.modelMapper.
				map(applyjob, ApplyJobDto.class)).
				collect(Collectors.toList());
		return applyJobDtoList;
	}

	@Override
	public ApplyJobDto getapplyJobById(int applyJobId) {
		ApplyJobEntity applyJobEntity=this.applyjobRepository.findById(applyJobId).orElseThrow(()->
		new ResourceNotFoundException("applyJob","applyJob id", applyJobId));
		return this.modelMapper.map(applyJobEntity, ApplyJobDto.class);
	}



	@Override
	public ApplyJobDto updateAppliedJobDetails(ApplyJobDto applyJob,int applyJobId) 
	{
		ApplyJobEntity applyJobobj=this.applyjobRepository.findById(applyJobId).orElseThrow(()->
		new ResourceNotFoundException("applyjob","applyjob id", applyJobId));
		ApplyJobEntity updateapplyjob=this.modelMapper.map(applyJob, ApplyJobEntity.class);
		ApplyJobEntity applyjob=this.applyjobRepository.save(updateapplyjob);
		return this.modelMapper.map(applyjob, ApplyJobDto.class);
	}		
	
	


	@Override
	public ApplyJobDto applyJob(ApplyJobDto applyJob) {
		// TODO Auto-generated method stub
		ApplyJobEntity applyJobEntity=this.modelMapper.map(applyJob, ApplyJobEntity.class);
		ApplyJobEntity savedappliedjob=this.applyjobRepository.save(applyJobEntity);
		return this.modelMapper.map(savedappliedjob, ApplyJobDto.class);
	}

	@Override
	public void deleteapplyJobById(int applyJobId) 
	{
		this.applyjobRepository.findById(applyJobId).orElseThrow(()->
		new ResourceNotFoundException("appyJob","applyJob id", applyJobId));
		this.applyjobRepository.deleteById(applyJobId);
		
	}

	@Override
	public List<JobDto> getAllAppliedJobsByStudentId(int studentId) {
		
		List<JobDto> jobList = new ArrayList<>();
		
		
		
		List<ApplyJobEntity> applyJObListByStudentId=this.applyjobRepository.getAppliedJobsByStudentId(studentId);
		          
		   applyJObListByStudentId.stream().forEach(e->
		   {
			      int jobId= e.getJobId();
            JobDto job=    jobService.getJobById(jobId);
            jobList.add(job);
			      
		   });
		
		System.out.println(jobList);
		return jobList;
		
		
	
	}

	@Override
	public List<ApplyJobDto> updatePlacedStudentList(List<ApplyJobDto> applyJobList) {
		// TODO Auto-generated method stub
		List<ApplyJobDto> applyJobList2 =  new ArrayList();
	List<ApplyJobEntity> applyJobEntityList=	applyJobList.stream().map(applyJob->this.modelMapper.map(applyJob, ApplyJobEntity.class)).collect(Collectors.toList());
		applyJobEntityList.stream().forEach(job->
		{
		    ApplyJobEntity updatedApplyJob=	this.applyjobRepository.save(job);
		    applyJobList2.add(this.modelMapper.map(updatedApplyJob,ApplyJobDto.class));
		    
		});
		return applyJobList2;
	}

	@Override
	public ApplyJobDto updatePlacedStudentByJobIdAndStudentId(int studentId, int jobId) 
	{
		// TODO Auto-generated method stub
	List<ApplyJobEntity> saveupdate= this.applyjobRepository.updatePlacedStudentByStudentIdAndJobId(studentId, jobId);
	ApplyJobEntity applyJobEntity = null;
	for(int i=0;i<1;i++)
	 {
		 applyJobEntity=saveupdate.get(i);
		 applyJobEntity.setStudentPlaced(true);
	 }
	
	     
	return this.modelMapper.map(this.applyjobRepository.save(applyJobEntity), ApplyJobDto.class);
	}

	

	

	

}
