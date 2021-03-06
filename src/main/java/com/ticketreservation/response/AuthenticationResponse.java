package com.ticketreservation.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {

	private final String jwt;
	
	public AuthenticationResponse(String jwt) {
		this.jwt=jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
	
}
