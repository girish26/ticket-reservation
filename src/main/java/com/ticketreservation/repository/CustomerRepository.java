package com.ticketreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketreservation.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

	Customer findByCustomerName(String customerName);
}
