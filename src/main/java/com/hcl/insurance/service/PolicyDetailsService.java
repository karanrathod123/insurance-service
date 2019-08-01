package com.hcl.insurance.service;

import com.hcl.insurance.dto.ResponseData;

public interface PolicyDetailsService {

	ResponseData detailsOfPolicy(Long id);

}
