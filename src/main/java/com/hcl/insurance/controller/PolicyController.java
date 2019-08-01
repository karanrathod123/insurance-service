package com.hcl.insurance.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.service.PolicyService;
import com.hcl.insurance.utills.GeneratePdfReport;

@RestController
@RequestMapping("/policies")
public class PolicyController {
	
	@Autowired
	private PolicyService policyServiceImpl;

	@GetMapping(path = "/user/{userId}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> userPolicyReport(@PathVariable Long userId) {

		ResponseData response = policyServiceImpl.userPolicyReport(userId);

		ByteArrayInputStream bis = (ByteArrayInputStream) response.getData();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=\"userreport.pdf\"");


		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
