package com.opts.crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.opts.crud.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
