package com.hcl.insurance.dto;

import lombok.Data;

@Data
public class CalculatedPolicy {

	private Long policyId;
	private Integer policyCount;
	private Integer month;
	private Integer week;
	private Double percentage;
	private String policyName;
	
}
