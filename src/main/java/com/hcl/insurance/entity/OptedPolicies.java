package com.hcl.insurance.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class OptedPolicies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	private Long policyId;
	private Long userId;
	private LocalDate bookingDate;
	private LocalDate maturityDate;
	private String nominee;
}
