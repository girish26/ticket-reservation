package com.ticketreservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "ticketbooking")
@Getter
@Setter
public class TicketBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketBookigId;

    @ElementCollection
    private List<Integer> seatNumbers;//passenger can select seat numbers

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateoperation = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "bus_id",nullable = false)
    private Bus bus;

    public TicketBooking() {
    }

    public TicketBooking(Long ticketBookigId, List<Integer> seatNumbers, Date dateoperation, Customer customer, Bus bus) {
        this.ticketBookigId = ticketBookigId;
        this.seatNumbers = seatNumbers;
        this.dateoperation = dateoperation;
        this.customer = customer;
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "TicketBooking{" +
                "ticketBookigId=" + ticketBookigId +
                ", seatNumbers=" + seatNumbers +
                ", dateoperation=" + dateoperation +
                ", customer=" + customer +
                ", bus=" + bus +
                '}';
    }
}
