package com.hcl.insurance.service;

import com.hcl.insurance.dto.ResponseData;

public interface PolicyService {

	public ResponseData userPolicyReport(Long userId);
}
