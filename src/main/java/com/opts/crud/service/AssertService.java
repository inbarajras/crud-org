package com.opts.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opts.crud.dao.ProjectRepository;
import com.opts.crud.entity.Assert;

@Service
public class AssertService {
	
	@Autowired
	ProjectRepository projectRepository;

	public List<Assert> getProjects() {
		List<Assert> projList = (List<Assert>) projectRepository.findAll();
		return projList;
	}

	public void saveProject(Assert project) {
		projectRepository.save(project);
	}

	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}

}
