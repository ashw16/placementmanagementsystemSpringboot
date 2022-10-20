package com.placement.payload;


public class ApplyJobDto 
{
	private int applyJobId;
	
	private int companyId;
	
	private int jobId;
	
	private boolean isStudentPlaced=false;
	
	private boolean applyJobStatus=false;
	
	private StudentDto student;

	public int getApplyJobId() {
		return applyJobId;
	}

	public void setApplyJobId(int applyJobId) {
		this.applyJobId = applyJobId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public boolean isStudentPlaced() {
		return isStudentPlaced;
	}

	public void setStudentPlaced(boolean isStudentPlaced) {
		this.isStudentPlaced = isStudentPlaced;
	}

	public boolean isApplyJobStatus() {
		return applyJobStatus;
	}

	public void setApplyJobStatus(boolean applyJobStatus) {
		this.applyJobStatus = applyJobStatus;
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "ApplyJobDto [applyJobId=" + applyJobId + ", companyId=" + companyId + ", jobId=" + jobId
				+ ", isStudentPlaced=" + isStudentPlaced + ", applyJobStatus=" + applyJobStatus + ", student=" + student
				+ "]";
	}

	public ApplyJobDto(int applyJobId, int companyId, int jobId, boolean isStudentPlaced, boolean applyJobStatus,
			StudentDto student) {
		super();
		this.applyJobId = applyJobId;
		this.companyId = companyId;
		this.jobId = jobId;
		this.isStudentPlaced = isStudentPlaced;
		this.applyJobStatus = applyJobStatus;
		this.student = student;
	}

	public ApplyJobDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
