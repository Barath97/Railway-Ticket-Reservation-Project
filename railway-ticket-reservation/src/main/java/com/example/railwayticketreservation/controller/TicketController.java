package com.example.railwayticketreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.railwayticketreservation.models.Passenger;
import com.example.railwayticketreservation.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/bookticket")
	public ResponseEntity<?> bookTicket(@RequestBody Passenger passenger){
		try {
			ticketService.bookTicket(passenger);
			return new ResponseEntity<>("Ticket Booked Successfully",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Failed to book Ticker",HttpStatus.OK);
		}
	}
}
