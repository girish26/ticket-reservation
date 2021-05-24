package com.ticketreservation.controller;

import com.ticketreservation.entities.Route;
import com.ticketreservation.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/routes")
    public ResponseEntity<List<Route>> getRoutes() {

        List<Route> list = routeService.getRoutes();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/routes/{routeId}")
    public ResponseEntity<Route> getRoute(@PathVariable String routeId) {

        Route route = routeService.getRoute(Long.parseLong(routeId));
        if (route == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(route));
    }

    //add Route using POST
    @PostMapping("/routes")
    public ResponseEntity<Route> addRoute(@RequestBody Route route) {
        Route route1 = this.routeService.addRoute(route);
        if (route1 == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(route1));
    }

    //update Route using PUT
    @PutMapping("/routes")
    public ResponseEntity<Route> updateRoute(@RequestBody Route route) {

        Route route1 = this.routeService.updateRoute(route);
        if (route1 == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(route1));
    }

    //Delete Route
    @DeleteMapping("/routes/{routeId}")
    public ResponseEntity<HttpStatus> deleteRoute(@PathVariable String routeId) {
        try {
            this.routeService.deleteRoute(Long.parseLong(routeId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
