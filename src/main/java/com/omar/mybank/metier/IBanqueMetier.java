package com.omar.mybank.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.omar.mybank.entities.Compte;
import com.omar.mybank.entities.Operation;

public interface IBanqueMetier {
	
	public Compte consulterCompte(String codeCpte);
	public List<Compte> getToutLesComptes();
	
	public void verser(String codeCpte, double montant);
	public void retirer(String codeCpte, double montant);
	public void virement(String codeCpte1, String codeCpte2, double montant);
	public Page<Operation> listOperation(String codeCpte, int page, int size);
	
	
}
