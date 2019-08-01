package com.hcl.insurance.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PolicyReport {

	private Long bookingId;
	
	private Long policyId;
	
	private String policyName;
	
	private Integer ageLimit;
	
	private Double sumAssured;
	
	private Integer policyTerm;
	
	private Double yearlyPremium;

	private LocalDate bookingDate;

	private LocalDate maturityDate;

	private String nominee;

}
