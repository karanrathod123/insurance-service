package com.hcl.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.entity.OptedPolicies;
import com.hcl.insurance.exception.ResourceNotFoundException;
import com.hcl.insurance.repository.OptedPoliciesRepository;

@Service
public class TrendAnalysisService {

	@Autowired
	OptedPoliciesRepository optedPoliciesRepository;
	
	
	public ResponseData getPoliciesTrends(String trendType) {

		List<OptedPolicies> list = optedPoliciesRepository.findAll();

		
		
		ResponseData response = new ResponseData();
		if(list.isEmpty()) {
			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("No data found");
			return response;
		}
		
		if(trendType.equalsIgnoreCase("Weekly")) {
			
		}
		else if(trendType.equalsIgnoreCase("Monthly")){
			
		}
		else if(trendType.equalsIgnoreCase("")) {
			
		}
		else {
			throw new ResourceNotFoundException("Please enter the valid trend type(weekly/monthly)");
		}
		
		return response;
	}

}
