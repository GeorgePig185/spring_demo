package com.htetlintun.springboot.demo.cruddemo.service;

import java.util.List;

import com.htetlintun.springboot.demo.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public void save(Employee gg);

	public Employee findById(int employeeId);

	public void deleteById(int employeeId);

}
