package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Department;
import com.company.repository.DepartmentRepository;

@Service
public class DepartmentService 
{
	@Autowired
	private DepartmentRepository departmentrepository;
	
	public List<Department> getAllDepartment()
	{
		return departmentrepository.findAll();
	}
	
	public Department getDepartmentById(Long id)
	{
		return departmentrepository.findById(id).orElseThrow();
	}
	
	public Department SaveDepartment(Department department)
	{
		return departmentrepository.save(department);
	}
	
	public void deleteDepartmentById(Long id)
	{
		departmentrepository.deleteById(id);
	}
	
}
