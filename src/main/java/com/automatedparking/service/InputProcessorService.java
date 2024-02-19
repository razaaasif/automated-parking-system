package com.automatedparking.service;

import com.automatedparking.model.InputData;

public interface InputProcessorService {
	public void createParkingLot(InputData data);

	public void park(InputData input);

	public void leaveParkingLot(InputData input);

	public void exit();

	// Registration numbers of all cars of a particular color.
	public void printRegirationNumberFromColor(InputData input);

	// Slot number in which a car with a given registration number is parked.
	public void printSlotFromRegistrationNumber(InputData input);

	// Slot numbers of all slots where a car of a particular color is parked.
	public void printSlotsFromColor(InputData input);

	public void printStatus();
}
