package com.example.railwayticketreservation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.railwayticketreservation.dao.TicketDao;
import com.example.railwayticketreservation.models.Passenger;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketDao ticketDao;
	
	private int totalLowerBerths=10;
	private int totalMiddleBerths=10;
	private int totalUpperBerths=10;
	private int totalRacTickets=5;
	private int totalWaitingLists=5;
	
	private Queue<Integer> waitingListQueue=new LinkedList<>();
	private Queue<Integer> racListQueue=new LinkedList<>();
	private List<Integer> bookedTicketList=new ArrayList();
	
	private List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	private List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	private List<Integer> upperBerthPositions= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	private List<Integer> racPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	private List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	
	@Override
	public void bookTicket(Passenger passenger) {
		 
		if(totalWaitingLists==0) {
			 System.out.println("No tickets avaiable");
		}
		
		if((passenger.getBerthPreference().equals("L") && totalLowerBerths>0)||
		   (passenger.getBerthPreference().equals("M") && totalMiddleBerths>0)||
		   (passenger.getBerthPreference().equals("U") && totalUpperBerths>0)) {
			
			if(passenger.getBerthPreference().equals("L")) {
				 seatAllocation("L",passenger);
				 ticketDao.save(passenger);
				 totalLowerBerths--;
				 lowerBerthPositions.remove(0);
			}
			else if(passenger.getBerthPreference().equals("M")) {
				ticketDao.save(passenger);
				totalMiddleBerths--;
				middleBerthPositions.remove(0);
			}
			else if(passenger.getBerthPreference().equals("U")) {
				ticketDao.save(passenger);
				totalUpperBerths--;
				upperBerthPositions.remove(0);
			}
		}
		
	}
	
	public void seatAllocation(String preference,Passenger passenger) {
		if (preference.equals("L")) {
            int seat = lowerBerthPositions.get(0);
            String s = String.valueOf(seat);
            passenger.setSeatNumber(preference + s);
        } else if (preference.equals("M")) {
            int seat = middleBerthPositions.get(0);
            String s = String.valueOf(seat);
            passenger.setSeatNumber(preference + s);
        } else if (preference.equals("U")) {
            int seat = upperBerthPositions.get(0);
            String s = String.valueOf(seat);
            passenger.setSeatNumber(preference + s);
        }
	}
	
}
