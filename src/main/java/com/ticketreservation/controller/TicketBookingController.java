package com.ticketreservation.controller;

import com.ticketreservation.entities.Bus;
import com.ticketreservation.entities.Route;
import com.ticketreservation.entities.TicketBooking;
import com.ticketreservation.services.BusService;
import com.ticketreservation.services.RouteService;
import com.ticketreservation.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/v1/ticketbookings")
public class TicketBookingController {

    @Autowired
    TicketBookingService ticketBookingService;

    //All Customise methods are here
    @Autowired
    BusService busService;

    @Autowired
    RouteService routeService;



    //Display all available buses on perticular route
    @GetMapping("/routes/{routeId}/buses")
    public ResponseEntity<List<Bus>> getAvailableBuses(@PathVariable String routeId){
        Route route = routeService.getRoute(Long.parseLong(routeId));
        List<Bus> busesOnRoute;
        if (route == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            List<Bus> busList = busService.getBuses();
            if(busList == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }else{
                busesOnRoute = busList.stream()
                                         .filter(bus -> bus.getRoute().getRouteId() == Long.parseLong(routeId))
                                         .collect(Collectors.toList());
            }
        }

        return ResponseEntity.of(Optional.of(busesOnRoute));
    }

    // Ticket Booking method

    @PostMapping("/book")
    public ResponseEntity<List<Integer>> ticketBooking(@RequestBody TicketBooking ticketBooking) {
        List<Integer> ticketsBooked = ticketBookingService.ticketBooking(ticketBooking);
        if (ticketsBooked == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(ticketsBooked));
    }
    // All Common Methods are written below

    @GetMapping("/history")
    public ResponseEntity<List<TicketBooking>> getTicketBookings() {

        List<TicketBooking> list = ticketBookingService.getTicketBookings();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }


    @GetMapping("/{ticketBookigId}")
    public ResponseEntity<TicketBooking> getTicketBooking(@PathVariable String ticketBookigId) {

        TicketBooking ticketBooking = ticketBookingService.getTicketBooking(Long.parseLong(ticketBookigId));
        if (ticketBooking == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(ticketBooking));
    }



    //update Ticket using PUT
    @PutMapping("/")
    public ResponseEntity<TicketBooking> updateTicketBooking(@RequestBody TicketBooking ticketBooking) {

        TicketBooking ticketBooking1 = this.ticketBookingService.updateTicketBooking(ticketBooking);
        if (ticketBooking1 == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(ticketBooking1));
    }

    //Delete Ticket Booking
    @DeleteMapping("/{ticketBookigId}")
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
