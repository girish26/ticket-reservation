package com.ticketreservation.repository;

import com.ticketreservation.entities.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketBookingRepository extends JpaRepository<TicketBooking,Long> {
}
