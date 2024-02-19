package com.automatedparking.service;

import com.automatedparking.model.InputData;
import com.automatedparking.utils.LoggerFactory;
import com.automatedparking.utils.Utils;
import com.automatedparking.utils.LoggerFactory.Logger;

public class InputProcessorServiceImpl implements InputProcessorService {
	private static Logger logger = LoggerFactory.getLogger(InputProcessorServiceImpl.class);

	private static ParkingLotService service = new ParkingLotServiceImpl();

	@Override
	public void createParkingLot(InputData data) {
		logger.log("InputProcessorServiceImpl -> " + data);
		if (data.getData().length > 2) {
			Utils.printErroInConsole();
			return;
		}
		// our second input will contain the slots to be created
		// convert it to number and call service to create slots
		try {
			int slots = Integer.parseInt(data.getData()[1]);
			service.createSlots(slots);
			System.out.println("Created a parking lot with " + slots + " slots");

		} catch (NumberFormatException e) {
			Utils.printInvalidInput(data.getData());
		}
	}

	@Override
	public void park(InputData input) {
		try {
			String registration = input.getData()[1];
			String color = input.getData()[2];
			service.park(registration, color);
		} catch (Exception e) {
			Utils.printInvalidInput(e);
		}

	}

	@Override
	public void leaveParkingLot(InputData input) {
		if (input.getData().length > 2) {
			Utils.printErroInConsole();
			return;
		}
		try {
			service.leaveParkingLot(Integer.parseInt(input.getData()[1]));
		} catch (Exception e) {
			Utils.printInvalidInput(e);
		}

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printRegirationNumberFromColor(InputData input) {
		if (input.getData().length > 2) {
			Utils.printErroInConsole();
			return;
		}
		try {
			service.printRegirationNumberFromColor(input.getData()[1]);
		} catch (Exception e) {
			Utils.printInvalidInput(e);
		}
	}

	@Override
	public void printSlotFromRegistrationNumber(InputData input) {
		if (input.getData().length > 2) {
			Utils.printErroInConsole();
			return;
		}
		try {
			service.printSlotFromRegistrationNumber(input.getData()[1]);
		} catch (Exception e) {
			Utils.printInvalidInput(e);
		}
	}

	@Override
	public void printSlotsFromColor(InputData input) {
		if (input.getData().length > 2) {
			Utils.printErroInConsole();
			return;
		}
		try {
			service.printSlotsFromColor(input.getData()[1]);
		} catch (Exception e) {
			Utils.printInvalidInput(e);
		}
	}

	@Override
	public void printStatus() {
		service.printStatus();

	}

}
