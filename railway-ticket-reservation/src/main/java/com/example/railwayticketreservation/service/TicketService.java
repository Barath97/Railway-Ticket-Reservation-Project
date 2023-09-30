package com.example.railwayticketreservation.service;

import java.util.List;

import com.example.railwayticketreservation.models.Passenger;

public interface TicketService {

	public boolean bookTicket(Passenger passenger);

	public boolean cancelTicket(int id);

	public List<Passenger> getAlltickets();

	public Passenger ticketDetails(int id);

	 

	  
	 
}
