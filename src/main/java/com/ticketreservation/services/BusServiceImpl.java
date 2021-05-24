package com.ticketreservation.services;

import com.ticketreservation.entities.Bus;
import com.ticketreservation.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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

    @Override
    public List<Integer> getAvailableSeats(Long busId) {
        Bus bus = busRepository.getById(busId);
        List<Integer> TotalSeats = IntStream.range(1,61).boxed().filter(i -> i <= 60)
                .collect(Collectors.toList());

        List<Integer> bookedSeats = bus.getSeatsAllocation().stream().collect(Collectors.toList());


        List<Integer> availableSeats = TotalSeats.stream()
                                                 .filter(i -> bus.getSeatsAllocation().stream()
                                                 .noneMatch(two -> two == i) ).collect(Collectors.toList());

        if(bookedSeats.size() == 0) // if whole bus is empty
            return TotalSeats;

        return availableSeats;
    }

}
