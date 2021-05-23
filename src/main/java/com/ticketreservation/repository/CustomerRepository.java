package com.ticketreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketreservation.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "select * from Customer c where  c.user_id = ?1 or c.email = ?1 or c.mobile_no = ?1",nativeQuery = true)
    Optional<Customer> findByCustomerName(@Param("userId") String userId);
    Customer findByEmail(String email);
}
