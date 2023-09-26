package com.example.railwayticketreservation.service;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	private List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	private List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	private List<Integer> upperBerthPositions= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	private List<Integer> racPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	private List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	
}
