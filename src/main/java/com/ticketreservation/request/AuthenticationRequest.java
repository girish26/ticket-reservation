package com.ticketreservation.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
	
	private String username;
	private String password;
	
	public AuthenticationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	
	
}
