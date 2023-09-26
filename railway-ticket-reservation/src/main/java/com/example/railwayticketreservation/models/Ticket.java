package com.example.railwayticketreservation.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {
	@Id
	@SequenceGenerator(name="tid_sequence",sequenceName = "tid_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tid_sequence")
	private int ticketId;
	
	private int seatNumber;
	private String berthType;
	
	@OneToOne(mappedBy = "ticket")
    private Passenger passenger;
}
