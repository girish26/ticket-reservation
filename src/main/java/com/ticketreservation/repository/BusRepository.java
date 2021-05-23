package com.ticketreservation.repository;

import com.ticketreservation.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
