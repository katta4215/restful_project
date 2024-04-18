package com.cyr.restful.rerepositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyr.restful.model.Employee;
@Repository
public interface ServiceRepository extends JpaRepository<Employee, Integer> {

}
