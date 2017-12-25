package com.yonghyun.projectStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonghyun.projectStudy.domain.Employee;
import com.yonghyun.projectStudy.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	// Logger
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable int id){
		System.out.println("dddd");
		return this.employeeService.getEmployee(id);
	}
}
