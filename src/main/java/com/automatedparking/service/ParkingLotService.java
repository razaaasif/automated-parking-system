package com.automatedparking.service;

public interface ParkingLotService {

	public void createSlots(int slots);

	public void park(String registration, String color);

	public void leaveParkingLot(Integer slot);

	public void printStatus();

	public void printRegirationNumberFromColor(String string);

	public void printSlotFromRegistrationNumber(String string);

	public void printSlotsFromColor(String string);

}
