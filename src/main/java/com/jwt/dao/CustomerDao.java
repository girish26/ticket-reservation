package com.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, String>{

	Customer findByCustomerName(String customerName);
}
