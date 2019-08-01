package com.hcl.insurance.dto;

import java.util.List;

import lombok.Data;

@Data
public class OptedPolicies {
	
	private List<CalculatedPolicy> policylist;
	private Integer totalPolicyOpted;

}
