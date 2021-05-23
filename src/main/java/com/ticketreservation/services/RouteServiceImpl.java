package com.ticketreservation.services;

import com.ticketreservation.entities.Route;
import com.ticketreservation.repository.RouteRepositoryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepositoryBus routeRepositoryBus;

    public RouteServiceImpl(){}

    @Override
    public List<Route> getRoutes() {
        return routeRepositoryBus.findAll();
    }

    @Override
    public Route getRoute(Long routeId) {
        return routeRepositoryBus.findById(routeId).get();
    }

    @Override
    public Route addRoute(Route route) {
        routeRepositoryBus.save(route);
        return route;
    }

    @Override
    public Route updateRoute(Route route) {
        routeRepositoryBus.save(route);
        return route;
    }

    @Override
    public void deleteRoute(Long routeId) {
        Route entity = routeRepositoryBus.getOne(routeId);
        routeRepositoryBus.delete(entity);
    }
}
