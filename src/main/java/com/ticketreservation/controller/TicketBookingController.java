package com.ticketreservation.controller;

import com.ticketreservation.entities.TicketBooking;
import com.ticketreservation.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketBookingController {

    @Autowired
    TicketBookingService ticketBookingService;

    @GetMapping("/ticketbookings")
    public ResponseEntity<List<TicketBooking>> getTicketBookings() {

        List<TicketBooking> list = ticketBookingService.getTicketBookings();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }


    @GetMapping("/ticketbookings/{ticketBookigId}")
    public ResponseEntity<TicketBooking> getTicketBooking(@PathVariable String ticketBookigId) {

        TicketBooking ticketBooking = ticketBookingService.getTicketBooking(Long.parseLong(ticketBookigId));
        if (ticketBooking == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(ticketBooking));
    }

    //add TicketBooking using POST
    @PostMapping("/ticketbookings")
    public ResponseEntity<TicketBooking> addTicketBooking(@RequestBody TicketBooking ticketBooking) {
        TicketBooking ticketBooking1 = ticketBookingService.addTicketBooking(ticketBooking);
        if (ticketBooking1 == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(ticketBooking1));
    }

    //update Route using PUT
    @PutMapping("/ticketbookings")
    public ResponseEntity<TicketBooking> updateTicketBooking(@RequestBody TicketBooking ticketBooking) {

        TicketBooking ticketBooking1 = this.ticketBookingService.updateTicketBooking(ticketBooking);
        if (ticketBooking1 == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(ticketBooking1));
    }

    //Delete Ticket Booking
    @DeleteMapping("/ticketbookings/{ticketBookigId}")
    public ResponseEntity<HttpStatus> deleteTicketBooking(@PathVariable String ticketBookigId) {
        try {
            ticketBookingService.deleteTicketBooking(Long.parseLong(ticketBookigId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
