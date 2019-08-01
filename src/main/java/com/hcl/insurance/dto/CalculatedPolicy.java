package com.hcl.insurance.dto;

import lombok.Data;

@Data
public class CalculatedPolicy {

	private Long policyId;
	private Integer optedPolicies;
	private Double percentage;
	
}
