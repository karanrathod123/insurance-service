package com.hcl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.service.TrendAnalysisService;

@RestController
@RequestMapping("/policies")
public class TrendAnalysisController {

	@Autowired
	TrendAnalysisService trendSAnalysisService;
	
	@GetMapping("/trend/{trendType}")
	public ResponseEntity<ResponseData> getPoliciesTrends(@PathVariable String trendType) {
		
		return new ResponseEntity<>(trendSAnalysisService.getPoliciesTrends(trendType), HttpStatus.OK);
		
	}
	
	
	
}
