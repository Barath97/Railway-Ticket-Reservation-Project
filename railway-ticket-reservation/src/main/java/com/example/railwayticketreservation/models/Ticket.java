package com.example.railwayticketreservation.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@Entity
public class Ticket {
	@Id
	@SequenceGenerator(name="tid_sequence",sequenceName = "tid_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tid_sequence")
	private int ticketId;
	
	private int seatNumber;
	private String berthType;	
	
	@OneToOne(mappedBy = "ticket")
    private Passenger passenger;
	
	public Ticket() {}

	public Ticket(int seatNumber, String berthType) {
		super();
		this.seatNumber = seatNumber;
		this.berthType = berthType;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", seatNumber=" + seatNumber + ", berthType=" + berthType + "]";
	}
		
}

