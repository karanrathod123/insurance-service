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

import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.repository.PolicyRepository;

@RunWith(MockitoJUnitRunner.class)
public class PolicyDetailsServiceImplTest {

	@Mock
	PolicyRepository policyRespository;

	@InjectMocks
	PolicyDetailsServiceImpl policyDetailsServiceImpl;

	Policy policy;

	@Before
	public void setup() {
		policy = new Policy();
		policy.setPolicyId(1l);
		policy.setPolicyName("LIC");
		policy.setAgeLimit(24);
		policy.setPolicyTerm(24);
		policy.setSumAssured(90000.0);
		policy.setYearlyPremium(13.0);
	}

	@Test
	public void detailsOfPolicyTest() {
		Mockito.when(policyRespository.findById(1l)).thenReturn(Optional.of(policy));
		assertNotNull(policy);
	}

}
