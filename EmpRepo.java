package com.ashutosh.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashutosh.basic.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
