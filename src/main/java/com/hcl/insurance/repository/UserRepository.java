package com.hcl.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.insurance.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
