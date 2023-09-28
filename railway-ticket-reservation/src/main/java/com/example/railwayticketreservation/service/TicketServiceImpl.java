package com.example.railwayticketreservation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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
	
	private int totalLowerBerths=9;
	private int totalMiddleBerths=9;
	private int totalUpperBerths=9;
	private int totalRacTickets=5;
	private int totalWaitingLists=5;
	
	private List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	private List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	private List<Integer> upperBerthPositions= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9	));
	private List<Integer> racPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	private List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	
	private Queue<Integer> waitingListQueue=new LinkedList<>();
	private Queue<Integer> racListQueue=new LinkedList<>();
	private List<Integer> bookedTicketList=new ArrayList();
	
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
				seatAllocation("M",passenger);
				ticketDao.save(passenger);
				totalMiddleBerths--;
				middleBerthPositions.remove(0);
			}
			else if(passenger.getBerthPreference().equals("U")) {
				seatAllocation("U",passenger);
				ticketDao.save(passenger);
				totalUpperBerths--;
				upperBerthPositions.remove(0);
			}
			
			else if(totalLowerBerths>0) {
				seatAllocation("L",passenger);
				ticketDao.save(passenger);
				totalLowerBerths--;
				lowerBerthPositions.remove(0);
			}
			
			else if(totalMiddleBerths>0) {
				seatAllocation("M",passenger);
				ticketDao.save(passenger);
				totalMiddleBerths--;
				middleBerthPositions.get(0);
			}
			
			else if(totalUpperBerths>0) {
				seatAllocation("U",passenger);
				ticketDao.save(passenger);
				totalUpperBerths--;
				upperBerthPositions.get(0);
			}
			
			else if(totalRacTickets>0) {
				seatAllocation("RAC",passenger);
				ticketDao.save(passenger);
				totalRacTickets--;
				racPositions.get(0);
			}
			
			else if(totalWaitingLists>0) {
				seatAllocation("WL",passenger);
				ticketDao.save(passenger);
				totalWaitingLists--;
				waitingListPositions.get(0);
			}
		}
		
	}
	
	public void seatAllocation(String preference,Passenger passenger) {
		
		if (preference.equals("L")) {
            int seat = lowerBerthPositions.get(0);
            String s = String.valueOf(seat);
            passenger.setSeatNumber(preference + s);
        } 
		
		else if (preference.equals("M")) {
            int seat = middleBerthPositions.get(0);
            String s = String.valueOf(seat);
            passenger.setSeatNumber(preference + s);
        } 
		
		else if (preference.equals("U")) {
            int seat = upperBerthPositions.get(0);
            String s = String.valueOf(seat);
            passenger.setSeatNumber(preference + s);
        }
		
		else if(preference.equals("RAC")) {
			int seat = racPositions.get(0);
			String s = String.valueOf(seat);
			passenger.setSeatNumber(preference + s);
		}
		
		else if(preference.equals("WL")) {
			int seat = waitingListPositions.get(0);
			String s = String.valueOf(seat);
			passenger.setSeatNumber(preference + s); 
		}
	}

	@Override
	public void cancelTicket(int id) { 
		Optional<Passenger> passengerId=ticketDao.findById(id);
		if(passengerId.isPresent()) {
			Passenger passenger=passengerId.get();
			String seatNumber=passenger.getSeatNumber();
			String seatType	= seatNumber.substring(0, seatNumber.length()-1);
			int seatTypeNumber =Integer.parseInt(seatNumber.substring(seatNumber.length() - 1));
			switch(seatType) {
				case "L":
					ticketDao.deleteById(id);
					totalLowerBerths++;
					lowerBerthPositions.add(seatTypeNumber);
					break;
				case "M":
					ticketDao.deleteById(id);
					totalMiddleBerths++;
					middleBerthPositions.add(seatTypeNumber);
					break;
				case "U":
					ticketDao.deleteById(id);
					totalUpperBerths++;
					upperBerthPositions.add(seatTypeNumber);
					break;
				case "RAC":
					ticketDao.deleteById(id);
					break;
				case "WL":
					ticketDao.deleteById(id);
					break;
			}
			
		}
		else {
			System.out.println("Passenger id is Invalid");
		}
	}
	
}
