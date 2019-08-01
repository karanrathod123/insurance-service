package com.hcl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.service.PolicyDetailsService;

@RestController
@RequestMapping("/policies")
public class PolicyDetailsController {

	
	@Autowired
	PolicyDetailsService policyDetailsService;
	
	@GetMapping
	public ResponseEntity<Object> detailsOfPolicy(@RequestParam Long id) {
		ResponseData responseData = policyDetailsService.detailsOfPolicy(id);
		return new ResponseEntity<Object>(responseData, HttpStatus.OK);

	}
}
