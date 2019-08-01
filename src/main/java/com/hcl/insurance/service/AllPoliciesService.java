package com.hcl.insurance.service;

import java.util.List;


import com.hcl.insurance.entity.Policy;


public interface AllPoliciesService {
	
	public List<Policy> listOfPolicies(Policy policy);

}
