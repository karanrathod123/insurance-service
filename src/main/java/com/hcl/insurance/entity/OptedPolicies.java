package com.hcl.insurance.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class OptedPolicies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
	private LocalDate bookingDate;
	
	private LocalDate maturityDate;
	
	private String nominee;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User userId;
	
	@OneToOne
	@JoinColumn(name = "policyId")
	private Policy policyId;
}
