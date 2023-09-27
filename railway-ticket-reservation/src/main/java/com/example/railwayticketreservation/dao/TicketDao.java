package com.example.railwayticketreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.railwayticketreservation.models.Passenger;

@Repository
public interface TicketDao extends JpaRepository<Passenger, Integer>{

}
