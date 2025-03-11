package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Employee;
import com.company.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeerepository;
	
	public List<Employee> getAllEmployee()
	{
		return employeerepository.findAll() ;
	}
	
	public Employee getEmployeeById(long id)
	{
		return employeerepository.findById(id).orElseThrow(null);
	}
	
	public Employee saveEmployee(Employee employee)
	{
		return employeerepository.save(employee);
	}
	
	public void deleteEmployeeById(Long id)
	{
		employeerepository.deleteById(id);
	}
	
	public List<Employee> searchEmployeesByName(String name) {
        return employeerepository.findByNameContainingIgnoreCase(name);
    }
	
}
