package com.ticketreservation.services;

import com.ticketreservation.entities.Customer;
import com.ticketreservation.entities.Route;

import java.util.List;

public interface RouteService {

    public List<Route> getRoutes();

    public Route getRoute(Long routeId);

    public Route addRoute(Route route);

    public Route updateRoute(Route route);

    public void deleteRoute(Long routeId);
}
