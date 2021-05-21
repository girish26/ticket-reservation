package com.ticketreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ticketreservation.repository.CustomerRepository;
import com.ticketreservation.entities.Customer;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String customerName) throws UsernameNotFoundException {
		//customerName="dhiraj0404";
		//System.out.println("************** from db Customer Name : "+customerName);
		
		Customer customer = repo.findByCustomerName(customerName);
		
		if(customer == null)
			throw new UsernameNotFoundException("Customer 404 i.e not found");
		
		return new UserDetailsImpl(customer);
		
		
		//correct working below line only
	//	{        "customerName": "dhiraj0404",        "password": "Dhiraj123"    }
	}

}
