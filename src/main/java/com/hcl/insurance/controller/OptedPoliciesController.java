package com.hcl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.OptedPoliciesDto;
import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.service.OptedPolicies;

@CrossOrigin
@RestController
@RequestMapping("/policies")
public class OptedPoliciesController {

	@Autowired
	private OptedPolicies optedPolicies;

	@PostMapping("/opt")
	public ResponseEntity<Object> optedPolicies(@RequestBody OptedPoliciesDto optedPoliciesDto) {
		ResponseData responseData = optedPolicies.optedPolicies(optedPoliciesDto);
		if (responseData == null) {
			return new ResponseEntity<>(responseData, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(responseData, HttpStatus.OK);

	}

}
