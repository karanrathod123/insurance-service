package com.hcl.insurance.service;

import com.hcl.insurance.dto.OptedPoliciesDto;
import com.hcl.insurance.dto.ResponseData;

public interface OptedPolicies {

	ResponseData optedPolicies(OptedPoliciesDto optedPoliciesDto);

}
