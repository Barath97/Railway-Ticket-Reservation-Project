package com.example.railwayticketreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.railwayticketreservation.models.ErrorMessage;
import com.example.railwayticketreservation.models.Passenger;
import com.example.railwayticketreservation.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("alltickets")
	public ResponseEntity<?> getAlltickets(){
		try {
			List<Passenger> allTickets=ticketService.getAlltickets();
			if(allTickets.isEmpty()) {
				ErrorMessage errorMessage=new ErrorMessage(200,"There is no ticket Booked yet");
				return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
			}else {
				return new ResponseEntity<List<Passenger>>(allTickets,HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/bookticket")
	public ResponseEntity<?> bookTicket(@RequestBody Passenger passenger){
		try {
			boolean isBookingSuccessful=ticketService.bookTicket(passenger);
			if(isBookingSuccessful) {
				return new ResponseEntity<String>("Ticket Booked Successfully",HttpStatus.OK);
			}else {
				ErrorMessage errorMessage = new ErrorMessage(500, "Ticket Booking Failed: Ticket is full");
	            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch(Exception e) {
			ErrorMessage errorMessage=new ErrorMessage(500,"Ticket Booking Failed");
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@GetMapping("/passenger/{id}")
	public ResponseEntity<?> ticketDetails(@PathVariable int id) {
		try {
			Passenger getPassenger=ticketService.ticketDetails(id);
			if(getPassenger==null) {
				ErrorMessage errorMessage=new ErrorMessage(500,"Ticket Id is Invalid");
				return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Passenger>(getPassenger,HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> cancelTicket(@PathVariable int id){
		try {
			ResponseEntity<?> passenger=ticketDetails(id);
			if(passenger==null) {
				ErrorMessage errorMessage=new ErrorMessage(500,"Ticket Id is Invalid");
				return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
			}else {
				ticketService.cancelTicket(id);
				return new ResponseEntity<String>("Ticket cancelled Succesfully",HttpStatus.OK);
			}
			
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
