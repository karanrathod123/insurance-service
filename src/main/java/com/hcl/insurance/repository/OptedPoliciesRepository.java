package com.hcl.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.insurance.entity.OptedPolicies;

@Repository
public interface OptedPoliciesRepository extends JpaRepository<OptedPolicies, Long> {
	
	
}
