package com.omar.mybank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.mybank.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
