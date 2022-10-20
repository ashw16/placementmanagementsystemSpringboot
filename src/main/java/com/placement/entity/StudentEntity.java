package com.placement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="student")
@Builder
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@ToString
public class StudentEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	
	@Column(nullable=false)
	@NotEmpty(message="StudentName can not be empty")
	@Size(min=4,max=10,message="StudentName must be minimum 4 characters and maximum 10 characters")
	private String studentName;
	
	@Column(nullable=false)
	@NotEmpty(message="StudentDOB can not be empty")
	@Size(min=4,max=15,message="StudentDOB must be minimum 4 characters and maximum 15 characters")
	private String studentDOB;
	
	@Column(nullable=false)
	@NotEmpty(message="StudentAddress can not be empty")
	@Size(min=4,max=20,message="StudentAddress must be minimum 4 characters and maximum 20 characters")
	private String studentAddress;
	
	@Column(nullable=false,unique = true)
	@NotEmpty(message="studentEmail can not be empty")
	@Email
	private String studentEmail;
	
	@Column(nullable=false)
	@NotEmpty(message="studentPassword can not be empty")
	private String studentPassword;
	
	@Column(nullable=false)
	@NotEmpty(message="studentContact can not be empty")
	@Size(min=10,max=10,message="studentContact must be 10 numbers")
	private String studentContact;
	
	@Column(nullable=false)
	@NotEmpty(message="studentCGPA can not be empty")
	private String studentCGPA;
	
	@Column(nullable=false)
	@NotEmpty(message="studentBranch can not be empty")
	private String studentBranch;
	
	@Column(nullable=false)
	@NotEmpty(message="studentGender can not be empty")
	private String studentGender;
	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	@JsonIgnore
	List<ApplyJobEntity> jobList=new ArrayList();

	


	
	
	
}
