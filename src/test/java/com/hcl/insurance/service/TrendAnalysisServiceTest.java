package com.hcl.insurance.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

import com.hcl.insurance.dto.CalculatedPolicy;
import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.repository.OptedPoliciesRepository;

@RunWith(MockitoJUnitRunner.class)
public class TrendAnalysisServiceTest {

	ResponseData expectedResponse;
	@Mock
	OptedPoliciesRepository optedPoliciesRepository;
	@InjectMocks
	TrendAnalysisService trendAnalysisService;
	
	@Before
	public void setUp() throws Exception {
		
		List<CalculatedPolicy> calculatedPolicyList=new ArrayList<>();
		
		CalculatedPolicy calculatedPolicy=new CalculatedPolicy();
		calculatedPolicy.setMonth(1);
		calculatedPolicy.setPercentage(10.15);
		calculatedPolicy.setPolicyCount(2);
		calculatedPolicy.setPolicyId(201l);
		calculatedPolicy.setPolicyName("Life Insurance");
		calculatedPolicy.setWeek(3);
		
		
		
		
	}

	@Test
	public void testGetPoliciesTrends() {
		
		Mockito.when(optedPoliciesRepository.findBySearchTermTotalPolicies()).thenReturn(3);
		
		ResponseData actualResponse = trendAnalysisService.getPoliciesTrends("weekly");
		assertEquals(expectedResponse, actualResponse.getData());
		assertTrue(true);
	}

	
	@Test
	public void testGetPoliciesTrends1() {
		
		Mockito.when(optedPoliciesRepository.findBySearchTermTotalPolicies()).thenReturn(2);
		
		ResponseData actualResponse = trendAnalysisService.getPoliciesTrends("monthly");
		assertEquals(expectedResponse, actualResponse.getData());
		assertTrue(true);
	}
	
	
	@Test
	public void testGetPoliciesTrends2() {
		
		Mockito.when(optedPoliciesRepository.findBySearchTermTotalPolicies()).thenReturn(1);
		
		ResponseData actualResponse = trendAnalysisService.getPoliciesTrends("all");
		assertEquals(expectedResponse, actualResponse.getData());
		assertTrue(true);
	}
	
	@Test
	public void getAllProductTestWhenEmpty() {

		Mockito.when(optedPoliciesRepository.findBySearchTermTotalPolicies()).thenReturn(null);
		ResponseData response = trendAnalysisService.getPoliciesTrends("all");
		assertNotNull(response);
	}
	
}
