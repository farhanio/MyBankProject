package com.omar.mybank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.mybank.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
