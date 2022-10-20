package com.placement.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StudentDto 
{
	private int studentId;
	
	
	private String studentName;
	

	private String studentDOB;
	
	
	private String studentAddress;
	
	private String studentEmail;
	
	private String studentPassword;
	
	private String studentContact;
	
	private String studentCGPA;
	
	private String studentBranch;
	
	private String studentGender;
	@JsonIgnore
	List<ApplyJobDto> jobList=new ArrayList();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(String studentDOB) {
		this.studentDOB = studentDOB;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentContact() {
		return studentContact;
	}

	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}

	public String getStudentCGPA() {
		return studentCGPA;
	}

	public void setStudentCGPA(String studentCGPA) {
		this.studentCGPA = studentCGPA;
	}

	public String getStudentBranch() {
		return studentBranch;
	}

	public void setStudentBranch(String studentBranch) {
		this.studentBranch = studentBranch;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public List<ApplyJobDto> getJobList() {
		return jobList;
	}

	public void setJobList(List<ApplyJobDto> jobList) {
		this.jobList = jobList;
	}

	public StudentDto(int studentId, String studentName, String studentDOB, String studentAddress, String studentEmail,
			String studentPassword, String studentContact, String studentCGPA, String studentBranch,
			String studentGender, List<ApplyJobDto> jobList) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDOB = studentDOB;
		this.studentAddress = studentAddress;
		this.studentEmail = studentEmail;
		this.studentPassword = studentPassword;
		this.studentContact = studentContact;
		this.studentCGPA = studentCGPA;
		this.studentBranch = studentBranch;
		this.studentGender = studentGender;
		this.jobList = jobList;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", studentDOB=" + studentDOB
				+ ", studentAddress=" + studentAddress + ", studentEmail=" + studentEmail + ", studentPassword="
				+ studentPassword + ", studentContact=" + studentContact + ", studentCGPA=" + studentCGPA
				+ ", studentBranch=" + studentBranch + ", studentGender=" + studentGender + ", jobList=" + jobList
				+ "]";
	}

	
	
	
	
}
