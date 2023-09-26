package com.example.railwayticketreservation.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TicketServiceImpl {
	private static int totalLowerBerths=10;
	private static int totalMiddleBerths=10;
	private static int tatalUpperBerths=10;
	private static int totalRacTickets=5;
	private static int totalWaitingLists=5;
	
	private Queue<Integer> waitingListQueue=new LinkedList<>();
	private Queue<Integer> racListQueue=new LinkedList<>();
	private List<Integer> bookedTicketList=new ArrayList();
	
	private List<Integer> lowerBirthPositions = new ArrayList();
	private List<Integer> middleBirthPositions = new ArrayList();
	private List<Integer> upperBirthPositions= new ArrayList();
	private List<Integer> racPositions = new ArrayList();
	private List<Integer> waitingListPositions = new ArrayList();
	
}
