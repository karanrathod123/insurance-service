package com.hcl.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.insurance.entity.OptedPolicies;
import com.hcl.insurance.entity.User;

@Repository
public interface OptedPoliciesRepository extends JpaRepository<OptedPolicies, Long> {
	
	public List<OptedPolicies> findByUserId(User userId);
}
