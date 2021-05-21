package com.jwt.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private String customerName;//this is unique so used as Id
	private String password;
	private String city;
	private String email;
	private String mobileno;
	private Boolean isLoggedIn;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String customerName, String password, String city, String email, String mobileno,
			Boolean isLoggedIn) {
		super();
		this.customerName = customerName;
		this.password = password;
		this.city = city;
		this.email = email;
		this.mobileno = mobileno;
		this.isLoggedIn = isLoggedIn;
	}


	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}
	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	@Override
	public String toString() {
		return "customerName=" + customerName + ", password=" + password
				+ ", city=" + city + ", email=" + email + ", mobileno=" + mobileno + ", isLoggedIn=" + isLoggedIn + "]";
	}

	
}
