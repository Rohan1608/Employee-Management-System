package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.company.model.Employee;
import com.company.service.DepartmentService;
import com.company.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private DepartmentService departmentservice;
	
	@GetMapping("/allemployees")
	public String getAllEmployees(Model model)
	{
		model.addAttribute("Employees",employeeservice.getAllEmployee());
		return "view_employee";
	}
	
	 @GetMapping("/searchEmployee")
	    public String searchEmployee(@ModelAttribute("name") String name, Model model) {
	        model.addAttribute("Employees", employeeservice.searchEmployeesByName(name));
	        return "view_employee"; // Redirect to the same view to show search results
	    }
	
	@GetMapping("/newemployee")
	public String newEmployee(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		model.addAttribute("departments",departmentservice.getAllDepartment());
		return "New_Employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute ("employee")Employee employee)
	{
		employeeservice.saveEmployee(employee);
		return "redirect:/allemployees";
	}
	
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable Long id,Model model)
	{
		Employee employee = employeeservice.getEmployeeById(id);
		model.addAttribute("employee",employee);
		model.addAttribute("departments",departmentservice.getAllDepartment());
		return "update_employee";
	}
	
	@GetMapping("deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id,Model model)
	{
		employeeservice.deleteEmployeeById(id);
		return "redirect:/allemployees";
	}
	

}
