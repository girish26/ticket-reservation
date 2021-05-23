package com.ticketreservation.services;


import com.ticketreservation.entities.TicketBooking;

import java.util.List;

public interface TicketBookingService {
    public List<TicketBooking> getTicketBookings();

    public TicketBooking getTicketBooking(Long ticketBookigId);

    public TicketBooking addTicketBooking(TicketBooking ticketBooking);

    public TicketBooking updateTicketBooking(TicketBooking ticketBooking);

    public void deleteTicketBooking(Long ticketBookigId);
}
