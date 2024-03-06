package com.jspiders.springmvcfindcars.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvcfindcars.pojo.AdminPOJO;
import com.jspiders.springmvcfindcars.service.AdminService;

import jakarta.servlet.http.HttpSession;



@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	//Create Account page controller
	@GetMapping("/createAccount")
	public String createAccountPage(ModelMap map) {
		AdminPOJO pojo = service.getAdmin();
		
		//Success
		if (pojo!=null) {
			map.addAttribute("msg","Account already exist..!");
			return "Login";
		}
		//Failure
		return "CreateAccount";
	}
	
	//Create Account Controller
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username,@RequestParam String password,ModelMap map) {
		
		AdminPOJO pojo=service.createAccount(username,password);
		if (pojo!=null) {
			map.addAttribute("msg", "Account Created Successfully..!");
			return "Login";
		}
		map.addAttribute("msg", "Account not created");
		return "Login";
	}
	
	//Login Page Controller
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password,ModelMap map,HttpSession session) {
		
		AdminPOJO pojo=service.login(username,password);
		
		if (pojo!=null) {
			session.setAttribute("login",pojo);
			session.setMaxInactiveInterval(200);
			return "Home";
		}
		map.addAttribute("msg","Invalid username or password..!");
		return "Login";
	}
	
	//Logout Controller
	@GetMapping("/logout")
	public String logout(ModelMap map,HttpSession session) {
		session.invalidate();
		map.addAttribute("msg", "Logged Out Successfully..!");
		return "Login";
	}

}
