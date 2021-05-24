package com.ticketreservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "bus")
@Setter
@Getter
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long busId;

	private String busNumber;
	private int totalSeats;

	@ElementCollection
	private List<Integer> seatsAllocation ;

	@Temporal(TemporalType.TIMESTAMP)
	private Date journeyStartTime;

	@ManyToOne
	private Route route;

	@OneToMany(mappedBy = "bus")
	@JsonIgnore
	private Set<TicketBooking> ticketBooking;

	public Bus() {
	}

	public Bus(Long busId, String busNumber, int totalSeats, List<Integer> seatsAllocation, Date journeyStartTime, Route route) {
		this.busId = busId;
		this.busNumber = busNumber;
		this.totalSeats = totalSeats;
		this.seatsAllocation = seatsAllocation;
		this.journeyStartTime = journeyStartTime;
		this.route = route;
	}

	@Override
	public String toString() {
		return "Bus{" +
				"busId=" + busId +
				", busNumber='" + busNumber + '\'' +
				", totalSeats=" + totalSeats +
				", seatsAllocation=" + seatsAllocation +
				", journeyStartTime=" + journeyStartTime +
				", route=" + route +
				'}';
	}
}
