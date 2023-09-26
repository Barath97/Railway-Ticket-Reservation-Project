package com.example.railwayticketreservation.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Ticket {
	@Id
	@SequenceGenerator(name="tid_sequence",sequenceName = "tid_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tid_sequence")
	private int ticketId;
	private int seatNumber;
	private String berthType;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Passenger_id")
	private Passenger passenger;
	
	public Ticket(){};
	
	public Ticket(Passenger passenger, int seatNumber, String berthType) {
		super();
		this.passenger = passenger;
		this.seatNumber = seatNumber;
		this.berthType = berthType;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBerthType() {
		return berthType;
	}

	public void setBerthType(String berthType) {
		this.berthType = berthType;
	}

	@Override
	public String toString() {
		return "Ticket [passenger=" + passenger + ", seatNumber=" + seatNumber + ", berthType=" + berthType + "]";
	}
	
	
}
