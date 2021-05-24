package com.ticketreservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ticketreservation.repository.CustomerRepository;
import com.ticketreservation.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public CustomerServiceImpl() {

	}
	
	@Override
	public List<Customer> getCustomers() {
		
		return customerDao.findAll();
	}

	@Override
	public Customer getCustomer(String customerName) {
	
		return customerDao.findById(customerName).get();
	}

	@Override
	public Customer addCustomer(Customer cust) {

		//need to encypt customer password
		cust.setPassword(passwordEncoder.encode(cust.getPassword()));
		customerDao.save(cust);
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer cust) {		
		
		customerDao.save(cust);
		return cust;
	}

	@Override
	public void deleteCustomer(String customerName) {
	
		Customer entity = customerDao.getOne(customerName);
		customerDao.delete(entity);

	}
	
	

}
