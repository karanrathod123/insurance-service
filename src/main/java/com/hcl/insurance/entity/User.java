package com.hcl.insurance.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String userName;

	private String mobileNumber;

	private String email;

	@OneToMany(mappedBy = "userId")
	List<OptedPolicies> userPolicies = new ArrayList<>();
}
