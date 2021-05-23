package com.ticketreservation.services;

import com.ticketreservation.entities.Bus;
import com.ticketreservation.entities.Route;
import com.ticketreservation.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    public BusServiceImpl(){ }

    @Override
    public List<Bus> getBuses() {
        return busRepository.findAll();
    }

    @Override
    public Bus getBus(Long busId) {
        return busRepository.findById(busId).get();
    }

    @Override
    public Bus addBus(Bus bus) {
        busRepository.save(bus);
        return bus;
    }

    @Override
    public Bus updateBus(Bus bus) {
        busRepository.save(bus);
        return bus;
    }

    @Override
    public void deleteBus(Long busId) {
        Bus bus = busRepository.getById(busId);
        busRepository.delete(bus);
    }
}
