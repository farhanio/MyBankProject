package com.omar.mybank;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.omar.mybank.dao.ClientRepository;
import com.omar.mybank.dao.CompteRepository;
import com.omar.mybank.dao.OperationRepository;
import com.omar.mybank.entities.Client;
import com.omar.mybank.entities.CompteCourant;
import com.omar.mybank.entities.CompteEpargne;
import com.omar.mybank.entities.Retrait;
import com.omar.mybank.entities.Versement;

@SpringBootApplication
public class MyBankApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	
	public static void main(String[] args) {
		 SpringApplication.run(MyBankApplication.class, args);
		
	
	}


	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client("Omar","omar.farhani@outlook.com");
		Client c2 = new Client("SuperMan","super.man@outlook.com");
		clientRepository.save(c1);
		clientRepository.save(c2);
		
		CompteCourant cc1 = new CompteCourant("U098324/9", new Date(), 1000, c1, 350);
		CompteCourant cc2 = new CompteCourant("U098586/3", new Date(), 1000, c2, 350);
		
		CompteEpargne CE1 = new CompteEpargne("U076748/1", new Date(),  232.4 , c1 , 5);
		CompteEpargne CE2 = new CompteEpargne("U054312/5", new Date(),  628.3 , c2 , 8);
		compteRepository.save(cc1);
		compteRepository.save(cc2);
		compteRepository.save(CE1);
		compteRepository.save(CE2);
		
		operationRepository.save(new Versement(new Date(), 1000, cc1));
		operationRepository.save(new Versement(new Date(), 1300, cc2));
		operationRepository.save(new Versement(new Date(), 350, CE1));
		operationRepository.save(new Versement(new Date(), 280, CE2));
		
		operationRepository.save(new Retrait(new Date(), 280, cc1));
		operationRepository.save(new Retrait(new Date(), 580, cc2));
		
	}
}
