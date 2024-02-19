package com.automatedparking.model;

public class Car {
	private String registrationNumber;
	private String color;
	private int slotNumber;

	public Car() {
		// Auto-generated constructor stub
	}

	public Car(String registrationNumber, String color, int slotNumber) {
		super();
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.slotNumber = slotNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getParkingNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

}
