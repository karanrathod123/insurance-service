package com.hcl.insurance.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookingId")
public class OptedPolicies implements Serializable{

	private static final long serialVersionUID = 8308203578540855615L;

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
