package com.ticketreservation.controller;

import com.ticketreservation.entities.Bus;
import com.ticketreservation.entities.Route;
import com.ticketreservation.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/buses")
    public ResponseEntity<List<Bus>> getBuses() {

        List<Bus> list = busService.getBuses();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/buses/{busId}")
    public ResponseEntity<Bus> getBus(@PathVariable String busId) {

        Bus bus = busService.getBus(Long.parseLong(busId));
        if (bus == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(bus));
    }

    // to get available sets in Bus
    @GetMapping("/buses/{busId}/seatsAvailable")
    public ResponseEntity<List<Integer>> getAvailableSeats(@PathVariable String busId) {

        List<Integer> availbleSeats = busService.getAvailableSeats(Long.parseLong(busId));
        if (availbleSeats == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(availbleSeats));
    }

    @PostMapping("/buses")
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
        Bus bus1 = busService.addBus(bus);
        if (bus1 == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(bus1));
    }

    //update Bus using PUT
    @PutMapping("/buses")
    public ResponseEntity<Bus> updateBus(@RequestBody Bus bus) {

        Bus bus1 = this.busService.updateBus(bus);
        if (bus1 == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(bus1));
    }

    //Delete Bus
    @DeleteMapping("/buses/{busId}")
    public ResponseEntity<HttpStatus> deleteBus(@PathVariable String busId) {
        try {
            this.busService.deleteBus(Long.parseLong(busId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
