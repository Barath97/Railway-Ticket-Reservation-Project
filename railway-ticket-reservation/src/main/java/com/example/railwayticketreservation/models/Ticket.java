package com.example.railwayticketreservation.models;

public class Ticket {
	private Passenger passenger;
	private int seatNumber;
	private String berthType;
	
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
