package com.placement.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="applyjob")
@Builder
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@ToString
public class ApplyJobEntity 
{	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int applyJobId;
	
	@Column(nullable=false)
	@NotNull(message="companyId can not be empty")
	private int companyId;
	
	@Column(nullable=false)
	@NotNull(message="jobId can not be empty")
	private int jobId;
	
	private boolean isStudentPlaced=false;
	
	private boolean applyJobStatus=false;
	
	@ManyToOne
	@JoinColumn(name="student_Id")
	private StudentEntity student;

	

	
	
	
	
	
	
	
	
	
}
