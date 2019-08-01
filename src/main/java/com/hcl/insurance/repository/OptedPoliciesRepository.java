package com.hcl.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.insurance.entity.OptedPolicies;
import com.hcl.insurance.entity.User;

@Repository
public interface OptedPoliciesRepository extends JpaRepository<OptedPolicies, Long> {
	
	@Query(value = "SELECT DISTINCT opt.policy_id, COUNT(opt.policy_id), WEEKOFYEAR(opt.booking_date), policy.policy_name " + 
			"FROM  insuranceservice.opted_policies opt JOIN insuranceservice.policy policy" + 
			" ON opt.policy_id = policy.policy_id GROUP BY opt.policy_id;", nativeQuery = true)
	List<Object[]> findBySearchTerm();
	
	
	@Query(value = "SELECT DISTINCT opt.policy_id, COUNT(opt.policy_id), WEEKOFYEAR(opt.booking_date), policy.policy_name " + 
			"FROM  insuranceservice.opted_policies opt JOIN insuranceservice.policy policy" + 
			" ON opt.policy_id = policy.policy_id GROUP BY opt.policy_id , WEEKOFYEAR(opt.booking_date);", nativeQuery = true)
	List<Object[]> findBySearchTermForWeek();
	
	
	@Query(value = "\r\n" + 
			"SELECT DISTINCT opt.policy_id, COUNT(opt.policy_id), MONTH(opt.booking_date), policy.policy_name "
			+ "FROM  insuranceservice.opted_policies opt JOIN insuranceservice.policy policy"
			+ " ON opt.policy_id = policy.policy_id GROUP BY opt.policy_id , MONTH(opt.booking_date);", nativeQuery = true)
	List<Object[]> findBySearchTermForMonth();
	
	
	@Query(value = "SELECT  count(*) FROM insuranceservice.opted_policies;", nativeQuery = true)
	Integer findBySearchTermTotalPolicies();
	
	public List<OptedPolicies> findByUserId(User userId);
	
}
