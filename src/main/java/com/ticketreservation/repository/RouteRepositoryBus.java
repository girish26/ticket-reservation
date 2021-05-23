package com.ticketreservation.repository;

import com.ticketreservation.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepositoryBus extends JpaRepository<Route, Long> {
   // Route finByRouteName(String routeName);
}
