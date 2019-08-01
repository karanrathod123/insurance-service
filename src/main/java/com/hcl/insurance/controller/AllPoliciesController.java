package com.hcl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.ResponseData;

import com.hcl.insurance.service.AllPoliciesService;

@CrossOrigin
@RestController
@RequestMapping("/policies")
public class AllPoliciesController {

	
	@Autowired
	private AllPoliciesService allPoliciesService;

	@GetMapping("/")
	public ResponseEntity<Object> listOfPolicies() {

		ResponseData response = allPoliciesService.listOfPolicies();
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
