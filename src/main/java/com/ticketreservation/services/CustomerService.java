package com.ticketreservation.services;

import java.util.List;

import com.ticketreservation.entities.Customer;

public interface CustomerService {

	
	public List<Customer> getCustomers();

	public Customer getCustomer(String customerName);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public void deleteCustomer(String customerName);

}