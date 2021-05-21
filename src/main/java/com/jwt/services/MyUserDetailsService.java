package com.jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.CustomerDetailsImpl;
import com.jwt.dao.CustomerDao;
import com.jwt.entities.Customer;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerDao repo;
	
	@Override
	public UserDetails loadUserByUsername(String customerName) throws UsernameNotFoundException {
		//customerName="dhiraj0404";
		//System.out.println("************** from db Customer Name : "+customerName);
		
		Customer customer = repo.findByCustomerName(customerName);
		
		if(customer == null)
			throw new UsernameNotFoundException("Customer 404 i.e not found");
		
		return new CustomerDetailsImpl(customer);
		
		
		//correct working below line only
	//	{        "customerName": "dhiraj0404",        "password": "Dhiraj123"    }
	}

}
