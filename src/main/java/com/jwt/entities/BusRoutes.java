package com.jwt.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BusRoutes {
	
	@Id
	private int busRouteId;

	
	@OneToMany // on one route many buses are runs
	private Bus bus;

}
