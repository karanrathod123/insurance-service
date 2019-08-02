package com.hcl.insurance.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.insurance.dto.OptedPoliciesDto;
import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.entity.User;
import com.hcl.insurance.repository.OptedPoliciesRepository;
import com.hcl.insurance.repository.PolicyRepository;
import com.hcl.insurance.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class OptedPoliciesServiceImplTest {

	@Mock
	PolicyRepository policyRepository;

	@Mock
	UserRepository userRepository;

	@Mock
	OptedPoliciesRepository optedPoliciesRepository;

	@InjectMocks
	OptedPoliciesServiceimpl optedPolicyServiceImpl;

	OptedPoliciesDto optedPoliciesDto;

	User user;
	
	Policy policy;

	@Before
	public void setup() {
		optedPoliciesDto = new OptedPoliciesDto();
		optedPoliciesDto.setAccepted(true);
		optedPoliciesDto.setNominee("Vivek");
		optedPoliciesDto.setPolicyId(1l);
		optedPoliciesDto.setUserId(1l);

		user = new User();
		user.setAge(34);
		user.setEmail("Karan@123");
		user.setMobileNumber("4567896534");
		user.setUserId(1l);
		user.setUserName("Karan");

		policy = new Policy();
		policy.setAgeLimit(34);
		policy.setPolicyId(2l);
		policy.setPolicyName("LIC");
		
	}

	@Test
	public void optedPoliciesFindByUserId() {

		Mockito.when(userRepository.findById(1l)).thenReturn(Optional.of(user));
		ResponseData responseData = optedPolicyServiceImpl.optedPolicies(optedPoliciesDto);
		assertNotNull(responseData);

	}
	
	
	@Test
	public void optedPoliciesFindByPolicyId() {
		ResponseData responseData = optedPolicyServiceImpl.optedPolicies(optedPoliciesDto);
		assertNotNull(responseData);
	}

}
