package com.htetlintun.springboot.demo.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htetlintun.springboot.demo.cruddemo.dao.EmployeeDAO;
import com.htetlintun.springboot.demo.cruddemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private	EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDao) {
		this.employeeDao =employeeDao;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}
	
	@Override
	@Transactional
	public void save(Employee gg) {
		// TODO Auto-generated method stub
		employeeDao.save(gg);
	}

	@Override
	@Transactional
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(employeeId);
	}
	
	@Override
	@Transactional
	public void deleteById(int employeeId) {
		// TODO Auto-generated method stub
		 employeeDao.deleteById(employeeId);
	}
}
