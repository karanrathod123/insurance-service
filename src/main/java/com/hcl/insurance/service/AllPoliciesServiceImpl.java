package com.hcl.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.repository.PolicyRepository;



@Service
public class AllPoliciesServiceImpl implements AllPoliciesService{

	@Autowired
	private PolicyRepository policyRepository;
	
	public List<Policy> listOfPolicies(Policy policy)
	{
		
		
		return null;
	}
	
}
