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
	private String trainNumber;
	private String berthPreference;
	private String seatNumber;
	
	public Passenger() {}


	public Passenger(String name, int age, String gender, String trainNumber, String berthPreference) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.trainNumber = trainNumber;
		this.berthPreference = berthPreference;
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

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}


	public String getTrainNumber() {
		return trainNumber;
	}


	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}


	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", trainNumber="
				+ trainNumber + ", berthPreference=" + berthPreference + ", seatNumber=" + seatNumber + "]";
	}

	
	
	
}
