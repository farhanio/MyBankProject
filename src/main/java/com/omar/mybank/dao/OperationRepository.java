package com.omar.mybank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.mybank.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{

}
