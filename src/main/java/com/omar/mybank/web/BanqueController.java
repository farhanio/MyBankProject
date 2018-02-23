package com.omar.mybank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.omar.mybank.entities.Compte;
import com.omar.mybank.metier.IBanqueMetier;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banqueMetier;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Model model){
		
		Compte compte = banqueMetier.consulterCompte("U098324/9");
		System.out.println(compte.getCodeCompte());
		System.out.println(compte.getSolde());
		model.addAttribute("compte",compte);
		return "home";
	}
	
//	
//	@RequestMapping(value="/consultercompte", method = RequestMethod.GET)
//	public String consulterCompte( ){
//		try {
//			Compte cp = banqueMetier.consulterCompte("U098324/9");
//		
//		//	model.addAttribute("compte", cp);
//		}catch(Exception e) {
//			//model.addAttribute("exception", e);
//		}
//		return "home";
//	}
	
	@RequestMapping("/consulterComptes")
	public String consulterComptes(){
		return "home";
	}
	
	@RequestMapping("/operations")
	public String consulterOperations(){
		return "operation";
	}
	
	

}
