package com.jwt.entities;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Bus {

	@Id
	private int busNumber;
	private int totalSeats;

	@ManyToOne // Many buses runs on same route
	private BusRoutes busRoutes;
	
	@OneToMany // one bus has many passengers i.e customers
	private Customer customer;
}
