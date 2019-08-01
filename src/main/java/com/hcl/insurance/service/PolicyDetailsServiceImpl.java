package com.hcl.insurance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.PolicyDetailsDto;
import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.repository.PolicyRepository;

@Service
public class PolicyDetailsServiceImpl implements PolicyDetailsService {

	@Autowired
	private PolicyRepository policyRepository;
	
	
	List<PolicyDetailsDto> policyDetailsList = new ArrayList<>(); 
	
	@Override
	public ResponseData detailsOfPolicy(Long id) {
		PolicyDetailsDto policyDetailsDto;
		
		Optional<Policy> policyOptional = policyRepository.findById(id);
		ResponseData responseData = new ResponseData();
		if(policyOptional.isPresent()) {
			Policy policy=policyOptional.get();
			policyDetailsDto = new PolicyDetailsDto();
			policyDetailsDto.setPolicyId(policy.getPolicyId());
			policyDetailsDto.setPolicyName(policy.getPolicyName());
			policyDetailsDto.setSumAssured(policy.getSumAssured());
			policyDetailsDto.setTerm(policy.getPolicyTerm());
			policyDetailsList.add(policyDetailsDto);
			responseData.setData(policyDetailsList);
			responseData.setHttpStatus(HttpStatus.OK);
			responseData.setMessage("Details of Policy Are as Follows");
			
		}else {
			responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseData.setMessage("Details Are Not Present For Following User ");
		}
		return responseData;
	}

}
