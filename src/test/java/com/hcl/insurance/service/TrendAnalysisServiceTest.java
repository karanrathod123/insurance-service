package com.hcl.insurance.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
	}

	@Test
	public void testGetPoliciesTrends() {
		
		Mockito.when(optedPoliciesRepository.findBySearchTermTotalPolicies()).thenReturn(3);
		
		ResponseData actualResponse = trendAnalysisService.getPoliciesTrends("weekly");
		//assertEquals(expectedResponse, actualResponse.getData());
		//assertTrue(true);
	}

}
