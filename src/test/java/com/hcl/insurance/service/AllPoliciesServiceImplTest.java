package com.hcl.insurance.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.insurance.dto.PolicyDto;
import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.repository.PolicyRepository;

@RunWith(MockitoJUnitRunner.class)
public class AllPoliciesServiceImplTest {

	@Mock
	PolicyRepository policyRepository;

	@InjectMocks
	AllPoliciesServiceImpl allPolicyServiceImpl;

	Policy policy1 = new Policy();
	Policy policy2 = new Policy();

	List<Policy> policyList = new ArrayList<>();

	@Before
	public void setUp() {

		policy1.setPolicyId(1l);
		policy1.setPolicyName("Life Insurance");
		policy1.setPolicyTerm(1);
		policy1.setSumAssured(89000.87);
		policy1.setYearlyPremium(7000.890);

		policy2.setPolicyId(2l);
		policy2.setPolicyName("Life Insurance");
		policy2.setPolicyTerm(1);
		policy2.setSumAssured(89000.87);
		policy2.setYearlyPremium(7000.890);

		policyList.add(policy1);
		policyList.add(policy2);

	}

	@Test
	public void getAllProductTest() {

		Mockito.when(policyRepository.findAll()).thenReturn(policyList);
		ResponseData response = allPolicyServiceImpl.listOfPolicies();
		assertNotNull(response);
	}

	@Test
	public void getAllProductTestWhenEmpty() {

		Mockito.when(policyRepository.findAll()).thenReturn(Collections.emptyList());
		ResponseData response = allPolicyServiceImpl.listOfPolicies();
		assertNotNull(response);
	}

}
