package com.opts.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opts.crud.dao.EmployeeRepository;
import com.opts.crud.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmp() {
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		return empList;
	}

	public void saveEmp(Employee emp) {
		employeeRepository.save(emp);
	}

	public void deleteEmp(Long id) {
		employeeRepository.deleteById(id);
	}

}
