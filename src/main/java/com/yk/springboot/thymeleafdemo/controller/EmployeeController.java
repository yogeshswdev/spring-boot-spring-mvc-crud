package com.yk.springboot.thymeleafdemo.controller;

import com.yk.springboot.thymeleafdemo.entity.Employee;
import com.yk.springboot.thymeleafdemo.service.EmployeeService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService theEmployeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		theEmployeeService = employeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		theModel.addAttribute("employees", theEmployeeService.findAll());

		return "list-employees";
	}
}
