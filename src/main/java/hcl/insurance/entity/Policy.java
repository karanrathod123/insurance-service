package hcl.insurance.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Policy {

	private Long policyId;
	private String policyName;
	private Integer ageLimit;
	private Double sumAssured;
	private Integer policyTerm;
}
