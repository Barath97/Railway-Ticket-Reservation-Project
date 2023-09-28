package com.example.railwayticketreservation.service;

import java.util.List;

import com.example.railwayticketreservation.models.Passenger;

public interface TicketService {

	public void bookTicket(Passenger passenger);

	public void cancelTicket(int id);
	 
}
