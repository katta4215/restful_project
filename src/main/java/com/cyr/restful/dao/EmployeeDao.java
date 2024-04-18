package com.cyr.restful.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyr.restful.model.Employee;

@Repository
public interface  EmployeeDao extends JpaRepository<Employee, Integer> {

}
