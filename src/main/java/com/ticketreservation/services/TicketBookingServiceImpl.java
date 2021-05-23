package com.ticketreservation.services;

import com.ticketreservation.entities.TicketBooking;
import com.ticketreservation.repository.TicketBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

    @Autowired
    private TicketBookingRepository ticketBookingRepository;

    public TicketBookingServiceImpl(){}

    @Override
    public List<TicketBooking> getTicketBookings() {
        return ticketBookingRepository.findAll();
    }

    @Override
    public TicketBooking getTicketBooking(Long ticketBookigId) {
        return ticketBookingRepository.findById(ticketBookigId).get();
    }

    @Override
    public TicketBooking addTicketBooking(TicketBooking ticketBooking) {

        ticketBookingRepository.save(ticketBooking);
        return ticketBooking;
    }

    @Override
    public TicketBooking updateTicketBooking(TicketBooking ticketBooking) {
        ticketBookingRepository.save(ticketBooking);
        return ticketBooking;
    }

    @Override
    public void deleteTicketBooking(Long ticketBookigId) {
        TicketBooking ticketBooking = ticketBookingRepository.getById(ticketBookigId);
        ticketBookingRepository.delete(ticketBooking);
    }
}
