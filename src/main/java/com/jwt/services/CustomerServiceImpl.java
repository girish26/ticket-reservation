package com.jwt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jwt.dao.CustomerDao;
import com.jwt.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
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
