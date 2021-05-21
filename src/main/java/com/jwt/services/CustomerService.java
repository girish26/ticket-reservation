package com.jwt.services;

import java.util.List;

import com.jwt.entities.Customer;

public interface CustomerService {

	
	public List<Customer> getCustomers();

	public Customer getCustomer(String customerName);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public void deleteCustomer(String customerName);

}