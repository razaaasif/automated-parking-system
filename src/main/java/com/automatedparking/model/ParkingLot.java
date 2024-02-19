package com.automatedparking.model;

public class ParkingLot {
	private int slotNumber;
	private Car car;

	public ParkingLot() {
		// Auto-generated constructor stub
	}

	public ParkingLot(int slotNumber, Car car) {
		super();
		this.slotNumber = slotNumber;
		this.car = car;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return String.format("|%8s | %20s | %11s |", slotNumber, car.getRegistrationNumber(), car.getColor());
	}
}
