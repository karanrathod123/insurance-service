package com.hcl.insurance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "policyId")
public class Policy implements Serializable{
	
	private static final long serialVersionUID = 7161792454149485963L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	
	private String policyName;
	
	private Integer ageLimit;
	
	private Double sumAssured;
	
	private Integer policyTerm;
	
	private Double yearlyPremium;
	
	private String termsAndCondition;
}
