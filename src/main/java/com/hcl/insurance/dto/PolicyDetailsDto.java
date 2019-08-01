package com.hcl.insurance.dto;

import lombok.Data;

@Data
public class PolicyDetailsDto {

	private Long policyId;
	private String policyName;
	private Double sumAssured;
	private Integer term;
}
