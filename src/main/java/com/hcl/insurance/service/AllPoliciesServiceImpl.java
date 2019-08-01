package com.hcl.insurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.insurance.dto.PolicyDto;
import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.repository.PolicyRepository;

@Service
public class AllPoliciesServiceImpl implements AllPoliciesService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public ResponseData listOfPolicies() {

		ResponseData response = new ResponseData();
		List<PolicyDto> policyDto = new ArrayList<>();

		List<Policy> policyList = policyRepository.findAll();

		if (ObjectUtils.isEmpty(policyList)) {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Incorrect Product ID");
			return response;
		}

		policyList.stream().forEach(policy -> {
			PolicyDto dto = new PolicyDto();
			BeanUtils.copyProperties(policy, dto);
			policyDto.add(dto);
		});
		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("The list of Product");
		response.setData(policyDto);

		return response;

	}

}
