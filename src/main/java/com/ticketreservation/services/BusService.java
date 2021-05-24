package com.ticketreservation.services;

import com.ticketreservation.entities.Bus;

import java.util.List;

public interface BusService {
    public List<Bus> getBuses();

    public Bus getBus(Long busId);

    public Bus addBus(Bus bus);

    public Bus updateBus(Bus bus);

    public void deleteBus(Long busId);

    public List<Integer> getAvailableSeats(Long busId);
}
