package com.htetlintun.springboot.demo.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.htetlintun.springboot.demo.cruddemo.entity.Employee;

@Repository
public class EmployeeDAPImpl implements EmployeeDAO {

	
	//define fields for entity manager	
	private EntityManager entityManger;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAPImpl(EntityManager theEntityManger) {
		this.entityManger = theEntityManger;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// get the current hibernate session
		org.hibernate.Session currenSession = entityManger.unwrap(org.hibernate.Session.class);
		
		//create the query 
		Query<Employee> theQuery =
				 (Query<Employee>) ((EntityManager) currenSession).createQuery("from Employee",Employee.class);
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		//return the results
		return employees;
	}

	@Override
	public void save(Employee gg) {
		// TODO Auto-generated method stub
		org.hibernate.Session currentSession = entityManger.unwrap(org.hibernate.Session.class);
		currentSession.saveOrUpdate(gg);
		
	}

	@Override
	public Employee findById(int employeeId) {

		// get the current hibernate session
		org.hibernate.Session currentSession = entityManger.unwrap(org.hibernate.Session.class);
		
		// get the employee
		Employee theEmployee =
				currentSession.get(Employee.class, employeeId);
		
		// return the employee
		return theEmployee;
	}

	@Override
	public void deleteById(int employeeId) {
		// get the current hibernate session
		org.hibernate.Session currentSession = entityManger.unwrap(org.hibernate.Session.class);
						
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery(
								"delete from Employee where id=:employeeId");
				theQuery.setParameter("employeeId", employeeId);
				
				theQuery.executeUpdate();
		
	}

}
