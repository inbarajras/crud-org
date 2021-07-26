package com.opts.crud.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Organisation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orgId;
	
	private String orgName;
	
	@OneToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,
			CascadeType.PERSIST},fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	@OneToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,
			CascadeType.PERSIST},fetch = FetchType.LAZY)
	private List<Assert> asserts;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Assert> getAsserts() {
		return asserts;
	}

	public void setAsserts(List<Assert> asserts) {
		this.asserts = asserts;
	}
	

}
