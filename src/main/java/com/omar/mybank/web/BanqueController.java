package com.omar.mybank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.omar.mybank.metier.IBanqueMetier;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banqueMetier;
	
	@RequestMapping("/")
	public String index(){
		return "home";
	}
	
	
	@RequestMapping("/consultercompte")
	public String consulterCompte(){
		return "compte";
	}
	
	@RequestMapping("/operations")
	public String consulterOperations(){
		return "operation";
	}
	
	

}
