package com.opts.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opts.crud.dao.OrganisationRepository;
import com.opts.crud.entity.Organisation;

@Service
public class OrgService {
	
	@Autowired
	OrganisationRepository organisationRepository;

	public List<Organisation> getOrg() {
		List<Organisation> orgOpt = (List<Organisation>) organisationRepository.findAll(); 
		return orgOpt;
	}

	public void saveOrg(Organisation org) {
		organisationRepository.save(org);
	}

	public void deleteOrg(Long id) {
		organisationRepository.deleteById(id);
	}

}
