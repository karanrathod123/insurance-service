package com.hcl.insurance.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.OptedPoliciesDto;
import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.entity.User;
import com.hcl.insurance.entity.OptedPolicies;
import com.hcl.insurance.repository.OptedPoliciesRepository;
import com.hcl.insurance.repository.PolicyRepository;
import com.hcl.insurance.repository.UserRepository;

@Service
public class OptedPoliciesServiceimpl implements com.hcl.insurance.service.OptedPolicies {

	@Autowired
	private OptedPoliciesRepository optedPoliciesRepository;

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseData optedPolicies(OptedPoliciesDto optedPoliciesDto) {
		ResponseData responseData = new ResponseData();
		Optional<User> userOptional = userRepository.findById(optedPoliciesDto.getUserId());

		if (userOptional.isPresent()) {
			Optional<Policy> policyOptional = policyRepository.findById(optedPoliciesDto.getPolicyId());
			if (policyOptional.isPresent()) {
				if (optedPoliciesDto.isAccepted()) {
					if ((userOptional.get().getAge() < 13 || userOptional.get().getAge() > 65) && optedPoliciesDto.getNominee()=="") {
						responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
						responseData.setMessage("Your age is not eligible...please add nominee");
						return responseData;
					}else {
						LocalDate today = LocalDate.now();
						LocalDate maturityAge = today.plusYears(15);
						OptedPolicies optedPolicies = new OptedPolicies();
						optedPolicies.setBookingDate(LocalDate.now());
						optedPolicies.setMaturityDate(maturityAge);
						optedPolicies.setNominee(optedPoliciesDto.getNominee());
						optedPolicies.setPolicyId(policyOptional.get());
						optedPolicies.setUserId(userOptional.get());
					 // optedPolicies.setNominee(null);
						optedPoliciesRepository.save(optedPolicies);
						responseData.setData(optedPolicies);
						responseData.setHttpStatus(HttpStatus.OK);
						return responseData;
					}

				} else {
					responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
					responseData.setMessage("Please Agree to the terms and conditions");
				}
			} else {
				responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
				responseData.setMessage("Policies are not available for this Id...");
			}
		} else {
			responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseData.setMessage("User is not present...");
		}
		return responseData;
	}

}
