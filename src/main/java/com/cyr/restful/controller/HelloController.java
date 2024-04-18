package com.cyr.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyr.restful.dao.EmployeeDao;
import com.cyr.restful.model.Employee;
import com.cyr.restful.service.EmployeeService;

@RestController
public class HelloController {
	@Autowired
	private EmployeeDao repo;
	@Autowired
	private EmployeeService employeeservice;
	@RequestMapping(value = "/all")
	public ResponseEntity<List<Employee>> listEmployee() {
		return new ResponseEntity<List<Employee>>(employeeservice.getAllEmployees(),HttpStatus.OK);
	}
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@RequestBody Employee employee) {
		if (employee.getId() == 0) {
			employeeservice.saveEmployee(employee);
		}
		return "Saved Successfully";
	}
       @GetMapping("/employeeById/{id}")
       public ResponseEntity<Employee>getcById(@PathVariable int id){
    	   if(repo.findById(id).isPresent()){
    		   return new ResponseEntity<Employee>(employeeservice.getEmployee(id),HttpStatus.OK);
    	   }
    	   return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
       }
       @DeleteMapping("/delete/{id}")
       public void deleteById(@PathVariable("id")int id){
    	   repo.deleteById(id);
    	}
}



