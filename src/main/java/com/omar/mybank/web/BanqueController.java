package com.omar.mybank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 
import java.util.List;

import com.omar.mybank.entities.Compte;
import com.omar.mybank.metier.IBanqueMetier;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banqueMetier;
	
	@RequestMapping(value="/")
	public String index(Model model){
		
		List <Compte> mylist = banqueMetier.getToutLesComptes();
		model.addAttribute("comptes", mylist);
		return "home";
	}
	

	
	@RequestMapping("/consultercompte")
	public String consulterComptes(){
		return "compte";
	}
	
	@RequestMapping("/operations")
	public String consulterOperations(){
		return "operation";
	}
	
	

}
