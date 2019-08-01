package com.hcl.insurance.dto;

import lombok.Data;

@Data
public class OptedPoliciesDto {

	private Long userId;
	private Long policyId;
	private boolean isAccepted;
	private String nominee;
}
