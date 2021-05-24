package com.ticketreservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "customer")
@Getter
@Setter
public class Customer {

    @Id
    private String userId;
    private String customerName;
    private String password;
    private String city;

   // @Column(unique=true, nullable=false)
    private String email;

  //  @Column(unique=true, nullable=false)
    private String mobileNo;

    private Boolean isLoggedIn;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<TicketBooking> ticketBookings;

    public Customer() {
    }

    public Customer(String userId, String customerName, String password, String city, String email, String mobileNo, Boolean isLoggedIn, Set<TicketBooking> ticketBookings) {
        this.userId = userId;
        this.customerName = customerName;
        this.password = password;
        this.city = city;
        this.email = email;
        this.mobileNo = mobileNo;
        this.isLoggedIn = isLoggedIn;
        this.ticketBookings = ticketBookings;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", isLoggedIn=" + isLoggedIn +
                ", ticketBookings=" + ticketBookings +
                '}';
    }
}
