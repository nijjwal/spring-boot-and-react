package com.timeandspacehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.timeandspacehub.model.Employee;
import com.timeandspacehub.repository.EmployeeRepository;
import com.timeandspacehub.repository.ReCaptchaValidationService;

@Controller
@RequestMapping("/employee")
public class EmployeeControllerThymLeaf {

	@Autowired
	private ReCaptchaValidationService validator;

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			@RequestParam(name = "g-recaptcha-response") String captcha, Model model) {
		if (validator.validateCaptcha(captcha)) {
			employeeRepository.save(employee);
			model.addAttribute("employee", new Employee());
			model.addAttribute("message", "Employee added!!");
		} else {
			model.addAttribute("message", "Please Verify Captcha");
		}
		return "EmployeeRegister";
	}

	@GetMapping("/all")
	public String getAllEmployees(Model model) {
		model.addAttribute("list", employeeRepository.findAll());
		return "EmployeeData";

	}

}
