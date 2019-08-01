package hcl.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.ResponseData;

@Service
public class TrendAnalysisService {

	@Autowired
	TrendAnalysisRepository trendAnalysisRepository;
	
	public ResponseData getPoliciesTrends(String trendType) {

		
		
		ResponseData response = new ResponseData();
		
		return response;
	}

}
