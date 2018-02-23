package com.omar.mybank.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omar.mybank.dao.CompteRepository;
import com.omar.mybank.dao.OperationRepository;
import com.omar.mybank.entities.Compte;
import com.omar.mybank.entities.CompteCourant;
import com.omar.mybank.entities.Operation;
import com.omar.mybank.entities.Retrait;
import com.omar.mybank.entities.Versement;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier{
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cpte= compteRepository.findOne(codeCpte);
		if (cpte == null) throw new RuntimeException("Account not Found");
		
		return cpte;
	}

	

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cpte=consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cpte);
		operationRepository.save(v);
		cpte.setSolde(cpte.getSolde()+montant);
		compteRepository.save(cpte);
		
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cpte=consulterCompte(codeCpte);
		double faciliteCaisse=0;
		if(cpte instanceof CompteCourant ) {
			faciliteCaisse=((CompteCourant) cpte).getDecouvert();
			
			if (cpte.getSolde()+faciliteCaisse>montant) {
				Retrait R = new Retrait(new Date(), montant, cpte);
				operationRepository.save(R);
				cpte.setSolde(cpte.getSolde()-montant);
				compteRepository.save(cpte);
			}
			else {
				throw new RuntimeException("You don't have the demanded ammount of money");
			}
		}
		
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
		
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		
		return operationRepository.listOperation(codeCpte, new PageRequest(page, size));
		
	}

	

}
