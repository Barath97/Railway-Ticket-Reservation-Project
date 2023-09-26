package com.example.railwayticketreservation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Passenger {
	@Id
	@SequenceGenerator(name="pid_sequence",sequenceName = "pid_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pid_sequence")
	private int id;
	private String name;
	private int age;
	private String gender;
	private String berthPreference;
	
		
	
}
