package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.model.Department;
import com.company.service.DepartmentService;

@Controller
public class DepartmentController 
{
	@Autowired
	private DepartmentService departmentservice;
	
	@GetMapping("/alldepartments")
	public String getAlldepartments(Model model)
	{
		model.addAttribute("listdepartments", departmentservice.getAllDepartment());
		return "view_departments";
	}
	
	@GetMapping("/newDepartment")
	public String newDepratment(Model model)
	{
		Department dept = new Department();
		model.addAttribute("department",dept);
		return "New_Department";
		
	}
	
	@PostMapping("/saveDepartment")
	public String saveDepartment(@ModelAttribute("departement")Department department)
	{
		departmentservice.SaveDepartment(department);
		return "redirect:/alldepartments";
	}
	
	@GetMapping("/updatedepartment/{id}")
	public String updateDepartment(@PathVariable Long id,Model model)
	{
		Department department = departmentservice.getDepartmentById(id);
		model.addAttribute("department",department);
		return "update_department";
	}
	
	@GetMapping("/deletedepartment/{id}")
	public String deleteDepartment(@PathVariable Long id,Model model)
	{
		departmentservice.deleteDepartmentById(id);
		return "redirect:/alldepartments";
		
	}
		
	
	
	
}
