package com.hcl.insurance.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.CalculatedPolicy;
import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.exception.ResourceNotFoundException;
import com.hcl.insurance.repository.OptedPoliciesRepository;
import com.hcl.insurance.repository.PolicyRepository;

@Service
public class TrendAnalysisService {

	@Autowired
	OptedPoliciesRepository optedPoliciesRepository;

	@Autowired
	PolicyRepository policyRepository;

	public ResponseData getPoliciesTrends(String trendType) {

		List<CalculatedPolicy> calculatedPolicies = new ArrayList<>();
		List<Object[]> policies;

		Integer totalCount = optedPoliciesRepository.findBySearchTermTotalPolicies();
		
		ResponseData response = new ResponseData();
		
		if(trendType.equalsIgnoreCase("Weekly")) {
			policies = optedPoliciesRepository.findBySearchTermForWeek();
			policies.stream().forEach(a -> {
				CalculatedPolicy calculatedPolicy = getCalculatedPolicyObject(a, totalCount);
				Double percentage = Double.parseDouble(a[1].toString())/totalCount * 100;
				calculatedPolicy.setPercentage(percentage);
				calculatedPolicy.setWeek(Integer.parseInt(a[2].toString()));
				calculatedPolicies.add(calculatedPolicy);
			});
		}
		else if(trendType.equalsIgnoreCase("Monthly")){
			policies = optedPoliciesRepository.findBySearchTermForMonth();
			policies.stream().forEach(a -> {
				CalculatedPolicy calculatedPolicy = getCalculatedPolicyObject(a, totalCount);
				calculatedPolicy.setMonth(Integer.parseInt(a[2].toString()));
				calculatedPolicies.add(calculatedPolicy);
			}); 
		}
		else if(trendType.equalsIgnoreCase("all")) {
			policies = optedPoliciesRepository.findBySearchTerm();
			policies.stream().forEach(a -> {
				CalculatedPolicy calculatedPolicy = getCalculatedPolicyObject(a, totalCount);
				Double percentage = Double.parseDouble(a[1].toString())/totalCount * 100;
				calculatedPolicy.setPercentage(percentage);
				
				calculatedPolicies.add(calculatedPolicy);
			});	 
		}
		else {
			throw new ResourceNotFoundException("Please enter the valid trend type(weekly/monthly/all)");
		}
		
		
		
		if(policies.isEmpty()) {
			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("No data found");
			return response;
		}
		
		response.setHttpStatus(HttpStatus.OK);
		response.setData(calculatedPolicies);
		return response;
	}

	private CalculatedPolicy getCalculatedPolicyObject(Object[] a, Integer totalCount) {
		CalculatedPolicy calculatedPolicy = new CalculatedPolicy();
		calculatedPolicy.setPolicyId(Long.parseLong(a[0].toString()));
		calculatedPolicy.setPolicyCount(Integer.parseInt(a[1].toString()));
		Double percentage = Double.parseDouble(a[1].toString())/totalCount * 100;
		calculatedPolicy.setPercentage(percentage);
		calculatedPolicy.setPolicyName(a[3].toString());
		return calculatedPolicy;
	}
		
}
