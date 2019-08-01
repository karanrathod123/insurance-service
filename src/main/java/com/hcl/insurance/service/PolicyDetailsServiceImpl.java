package com.hcl.insurance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.repository.PolicyRepository;

@Service
public class PolicyDetailsServiceImpl implements PolicyDetailsService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public ResponseData detailsOfPolicy(Long id) {

		Optional<Policy> policyOptional = policyRepository.findById(id);
		ResponseData responseData = new ResponseData();
		if (policyOptional.isPresent()) {
			Policy policy = policyOptional.get();
			responseData.setData(policy);
			responseData.setHttpStatus(HttpStatus.OK);
			responseData.setMessage("Details of Policy Are as Follows");

		} else {
			responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseData.setMessage("Details Are Not Present For Following User ");
		}
		return responseData;
	}

}
