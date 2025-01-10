package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;
@Controller
@RequestMapping("/login")
public class LoginController {
	
	// Inject the OrdersBusinessService
    @Autowired
    private OrdersBusinessServiceInterface service;
    @Autowired
    private SecurityBusinessService security;
    
    
	@GetMapping("/")
    public String display(Model model) {
        // Set model attributes
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel()); // Assuming LoginModel is a class you have defined

        // Return the view name
        return "login";
    }
	
	@PostMapping("/doLogin") 
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		//Print the form values out
		System.out.println(String.format("Form with Username of %s and Password of %s", loginModel.getUsername(), loginModel.getPassword()));
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		//Call the service test method
		service.test();
		
		//Call the authenticate method
		security.authenticate(loginModel.getUsername(), loginModel.getPassword());
		
		model.addAttribute("title", "MyOrders");
		model.addAttribute("orders", service.getOrders());
		//Navigate back to the Login View
		return "orders";
	}
	
}
