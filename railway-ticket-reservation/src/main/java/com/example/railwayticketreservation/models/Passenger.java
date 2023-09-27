package com.example.railwayticketreservation.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ticketId")
	private Ticket ticket;
	
	public Passenger() {}
	
	public Passenger(String name, int age, String gender, String berthPreference, Ticket ticket) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.berthPreference = berthPreference;
		this.ticket = ticket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBerthPreference() {
		return berthPreference;
	}

	public void setBerthPreference(String berthPreference) {
		this.berthPreference = berthPreference;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", berthPreference="
				+ berthPreference + ", ticket=" + ticket + "]";
	}
	
	
	
}
