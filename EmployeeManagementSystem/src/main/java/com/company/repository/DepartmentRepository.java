package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
