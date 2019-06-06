package com.htetlintun.springboot.demo.cruddemo.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htetlintun.springboot.demo.cruddemo.entity.Employee;
import com.htetlintun.springboot.demo.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@GetMapping("/hello")
	public String hello(){
	return "hello";
}
		
	
	private EmployeeService employeeService; 

	@Autowired
	public EmployeeRestController(EmployeeService theemployeeService) {
		this.employeeService = theemployeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	@GetMapping("/employeesSave")
	public void save() {
		Employee gg = new Employee();

		gg.setFirstName("testing update");
		gg.setLastName("testing lastname");
		gg.setEmail("helllo@gmail.com");
		employeeService.save(gg);
	}
	
	@GetMapping("employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null)
		{
			throw new RuntimeException("Employee id not found");
		}
		return theEmployee;
	}
	
	@PutMapping("/employeesUpdate")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return theEmployee;
		
	}
	
	@PostMapping("/employeesAdd")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employeesDelete/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
  }
