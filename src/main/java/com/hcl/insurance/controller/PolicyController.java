package com.hcl.insurance.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.OptedPoliciesDto;
import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.service.AllPoliciesService;
import com.hcl.insurance.service.OptedPolicies;
import com.hcl.insurance.service.PolicyDetailsService;
import com.hcl.insurance.service.PolicyService;
import com.hcl.insurance.service.TrendAnalysisService;

@RestController
@RequestMapping("/policies")
public class PolicyController {

	@Autowired
	private PolicyService policyServiceImpl;

	@Autowired
	private AllPoliciesService allPoliciesService;

	@Autowired
	private PolicyDetailsService policyDetailsService;

	@Autowired
	private TrendAnalysisService trendSAnalysisService;

	@Autowired
	private OptedPolicies optedPolicies;

	@GetMapping(path = "/user/{userId}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> userPolicyReport(@PathVariable Long userId) {

		ResponseData response = policyServiceImpl.userPolicyReport(userId);

		ByteArrayInputStream bis = (ByteArrayInputStream) response.getData();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=\"userreport.pdf\"");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	@GetMapping()
	public ResponseEntity<Object> listOfPolicies() {

		ResponseData response = allPoliciesService.listOfPolicies();
		return new ResponseEntity<>(response, response.getHttpStatus());

	}

	@GetMapping("/{policyId}")
	public ResponseEntity<Object> detailsOfPolicy(@PathVariable Long policyId) {
		ResponseData responseData = policyDetailsService.detailsOfPolicy(policyId);
		return new ResponseEntity<>(responseData, responseData.getHttpStatus());

	}

	@GetMapping("/trend/{trendType}")
	public ResponseEntity<ResponseData> getPoliciesTrends(@PathVariable String trendType) {

		ResponseData response = trendSAnalysisService.getPoliciesTrends(trendType);
		return new ResponseEntity<>(response,response.getHttpStatus());

	}

	@PostMapping("/opt")
	public ResponseEntity<Object> optedPolicies(@RequestBody OptedPoliciesDto optedPoliciesDto) {
		ResponseData responseData = optedPolicies.optedPolicies(optedPoliciesDto);
		return new ResponseEntity<>(responseData, responseData.getHttpStatus());

	}

}
