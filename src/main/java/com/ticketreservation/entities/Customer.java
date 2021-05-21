package com.ticketreservation.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    private String customerName;//this is unique so used as Id
    private String password;
    private String city;
    private String email;
    private String mobileNo;
    private Boolean isLoggedIn;

    public Customer() {
    }

    public Customer(String customerName, String password, String city, String email, String mobileNo,
                    Boolean isLoggedIn) {
        super();
        this.customerName = customerName;
        this.password = password;
        this.city = city;
        this.email = email;
        this.mobileNo = mobileNo;
        this.isLoggedIn = isLoggedIn;
    }


    @Override
    public String toString() {
        return "customerName=" + customerName + ", password=" + password
                + ", city=" + city + ", email=" + email + ", mobileno=" + mobileNo + ", isLoggedIn=" + isLoggedIn + "]";
    }


}
