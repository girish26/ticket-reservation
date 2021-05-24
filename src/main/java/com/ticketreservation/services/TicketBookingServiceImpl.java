package com.ticketreservation.services;

import com.ticketreservation.entities.Bus;
import com.ticketreservation.entities.TicketBooking;
import com.ticketreservation.repository.BusRepository;
import com.ticketreservation.repository.CustomerRepository;
import com.ticketreservation.repository.RouteRepositoryBus;
import com.ticketreservation.repository.TicketBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

    @Autowired
    private TicketBookingRepository ticketBookingRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepositoryBus routeRepositoryBus;

    @Autowired
    private CustomerRepository customerRepository;

    public TicketBookingServiceImpl(){}

    @Override
    public List<TicketBooking> getTicketBookings() {
        return ticketBookingRepository.findAll();
    }

    @Override
    public TicketBooking getTicketBooking(Long ticketBookigId) {
        return ticketBookingRepository.findById(ticketBookigId).get();
    }

    // below method modified to Ticket Booking and user can enter seat number while booking
    public List<Integer> ticketBooking(TicketBooking ticketBooking) {

        List<Integer> seatNumbers = ticketBooking.getSeatNumbers();// user selected seats

        Bus bus = busRepository.getById(ticketBooking.getBus().getBusId());

        List<Integer> TotalSeats = IntStream.range(1,61).boxed().filter(i -> i <= 60).collect(Collectors.toList());

        List<Integer> bookedSeats = bus.getSeatsAllocation().stream().collect(Collectors.toList());


        List<Integer> availableSeats = TotalSeats.stream().filter(i -> bus.getSeatsAllocation().stream()
                                                 .noneMatch(two -> two == i) ).collect(Collectors.toList());

        List<Integer> seatNo  = seatNumbers.stream().filter(i -> bus.getSeatsAllocation().stream().anyMatch(two -> two == i))
                                                    .collect(Collectors.toList());
        try {
            if (seatNo.size() > 0) {
                throw new Exception("These seats are already booked");
            }else{
                bus.setSeatsAllocation(seatNumbers);
                busRepository.save(bus);
                ticketBookingRepository.save(ticketBooking);//seats are booked
            }
        }catch(Exception e){ }

        return seatNumbers;
    }


    @Override
    public TicketBooking addTicketBooking(TicketBooking ticketBooking) {

        ticketBookingRepository.save(ticketBooking);
        return ticketBooking;
    }

    @Override
    public TicketBooking updateTicketBooking(TicketBooking ticketBooking) {
        ticketBookingRepository.save(ticketBooking);
        return ticketBooking;
    }

    @Override
    public void deleteTicketBooking(Long ticketBookigId) {
        TicketBooking ticketBooking = ticketBookingRepository.getById(ticketBookigId);
        ticketBookingRepository.delete(ticketBooking);
    }
}
