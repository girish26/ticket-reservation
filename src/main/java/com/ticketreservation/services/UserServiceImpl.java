package com.ticketreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ticketreservation.repository.CustomerRepository;
import com.ticketreservation.entities.Customer;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<Customer> customer = repo.findByCustomerName(userId);
        if (customer == null)
            throw new UsernameNotFoundException("Invalid userId: "+userId);
        return new UserDetailsImpl(customer.get());
    }

    public UserDetails getUserByEmailId(String email) throws UsernameNotFoundException {
        Customer customer = repo.findByEmail(email);
        if (customer == null)
            throw new UsernameNotFoundException("Invalid userId: "+email);
        return new UserDetailsImpl(customer);
    }
}
