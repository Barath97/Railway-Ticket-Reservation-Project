package com.example.railwayticketreservation.models;

public class Passenger {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String berthPreference;
	
	public Passenger() {}
	
	public Passenger(String name, int age, String gender, String berthPreference) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
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

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", berthPreference="
				+ berthPreference + "]";
	}
	
	
}
