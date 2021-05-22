package com.ticketreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketreservation.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("select c from Customer c where  c.email = ?1 or c.mobileNo = ?1")
    Optional<Customer> findByCustomerName(@Param("userId") String userId);
    Customer findByEmail(String email);
}
