package com.hcl.insurance.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.repository.PolicyRepository;



@RunWith(MockitoJUnitRunner.class)
public class PolicyDetailsServiceImplTest {

	@Mock
	PolicyRepository policyRespository;

	@InjectMocks
	PolicyDetailsServiceImpl policyDetailsServiceImpl;

	
	Policy p=new Policy();

	@Before
	public void setup() {
		
		p.setPolicyId(1l);
		p.setPolicyName("LIC");
		p.setAgeLimit(24);
		p.setPolicyTerm(24);
		p.setSumAssured(90000.0);
		p.setYearlyPremium(13.0);
				
	}

	
	
	@Test
	public void detailsOfPolicyTest() {
		Mockito.when(policyRespository.findById(1l)).thenReturn(Optional.of(new Policy()));
		ResponseData response = policyDetailsServiceImpl.detailsOfPolicy(p.getPolicyId());
		assertNotNull(response);
		
	}

}
