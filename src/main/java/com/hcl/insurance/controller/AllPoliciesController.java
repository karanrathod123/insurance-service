package com.hcl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.service.AllPoliciesService;

@RestController
public class AllPoliciesController {
	
	@Autowired
	private AllPoliciesService allPoliciesService;
	
	@GetMapping("/insurance/policies")
	public ResponseEntity<Object> listOfPolicies(@RequestBody Policy policy)
	{
	
		
		return new ResponseEntity<Object> (allPoliciesService.listOfPolicies(policy),HttpStatus.OK);
	}

} 
