package com.hcl.insurance.service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.insurance.dto.PolicyReport;
import com.hcl.insurance.dto.ResponseData;
import com.hcl.insurance.entity.OptedPolicies;
import com.hcl.insurance.entity.User;
import com.hcl.insurance.repository.OptedPoliciesRepository;
import com.hcl.insurance.repository.UserRepository;
import com.hcl.insurance.utills.GeneratePdfReport;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private OptedPoliciesRepository optedPoliciesRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseData userPolicyReport(Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		List<PolicyReport> report = new ArrayList<>();
		ResponseData response = new ResponseData();

		if (userOptional.isPresent()) {
			List<OptedPolicies> userPolicies = optedPoliciesRepository.findByUserId(userOptional.get());
			if (ObjectUtils.isEmpty(userPolicies)) {
				response.setMessage("No policy opted by you");
				response.setHttpStatus(HttpStatus.OK);
			} else {
				userPolicies.stream().forEach(details -> {
					PolicyReport policyReport = new PolicyReport();
					policyReport.setBookingId(details.getBookingId());
					policyReport.setPolicyId(details.getPolicyId().getPolicyId());
					policyReport.setPolicyName(details.getPolicyId().getPolicyName());
					policyReport.setSumAssured(details.getPolicyId().getSumAssured());
					policyReport.setPolicyTerm(details.getPolicyId().getPolicyTerm());
					policyReport.setYearlyPremium(details.getPolicyId().getYearlyPremium());
					policyReport.setAgeLimit(details.getPolicyId().getAgeLimit());
					policyReport.setBookingDate(details.getBookingDate());
					policyReport.setMaturityDate(details.getMaturityDate());
					policyReport.setNominee(details.getNominee());
					report.add(policyReport);
				});

				ByteArrayInputStream byteArray = GeneratePdfReport.userPolicyReport(report);
				response.setMessage("User details successfully genareted");
				response.setHttpStatus(HttpStatus.OK);
				response.setData(byteArray);
			}
			return response;
		}
		response.setMessage("Incorrect UserId");
		response.setHttpStatus(HttpStatus.BAD_REQUEST);
		return response;
	}

}
