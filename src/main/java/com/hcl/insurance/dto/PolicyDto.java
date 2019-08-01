package com.hcl.insurance.dto;

import lombok.Data;

@Data
public class PolicyDto {

	private Long policyId;
	private String policyName;
	private Double yearlyPremium;
	private Double sumAssured;
	private Integer policyTerm;

}
