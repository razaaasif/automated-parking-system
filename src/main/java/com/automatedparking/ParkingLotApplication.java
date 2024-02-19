package com.automatedparking;

import java.util.Scanner;

import com.automatedparking.common.Constants.PARKING_COMMAND;
import com.automatedparking.model.InputData;
import com.automatedparking.service.InputProcessorService;
import com.automatedparking.service.InputProcessorServiceImpl;
import com.automatedparking.utils.LoggerFactory;
import com.automatedparking.utils.LoggerFactory.Logger;
import com.automatedparking.utils.Utils;

public class ParkingLotApplication {
	private static String input = null;
	private static Logger logger = LoggerFactory.getLogger(ParkingLotApplication.class);
	private static InputProcessorService service = new InputProcessorServiceImpl();

	public static void main(String[] args) {
		// this method will load out errorUtils class for logging error in error.log
		loadErrorClass();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Automated Parking System.");
		System.out.println("Type 'exit' to quit.");

		do {
			System.out.print("$ ");
			System.out.flush();
			input = scanner.nextLine().trim();
			logger.log("input => " + input);

			if (!input.isEmpty()) {
				InputData data = createInputData(input);
				// if the command not found the throw error
				if (data.getCommand() != null) {
					if (data.getCommand() == PARKING_COMMAND.EXIT) {
						System.exit(0);
					}
					performAction(data);
				} else {
					Utils.printErroInConsole(input);
				}
			}
		} while (!input.equalsIgnoreCase("exit"));

		scanner.close();
	}

	private static void loadErrorClass() {
		try {
			Class.forName("com.automatedparking.utils.ErrorUtils");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static InputData createInputData(String input) {
		String[] commands = Utils.nullSafeString(input).split("[,\\s!$]+");
		InputData data = new InputData();
		PARKING_COMMAND command = PARKING_COMMAND.getCommandByValue(commands[0]);
		data.setCommand(command);
		data.setData(commands);
		return data;
	}

	private static void performAction(InputData data) {
		logger.log("performAction ->  " + data);

		switch (data.getCommand()) {
		case CREATE_PARKING_LOT:
			service.createParkingLot(data);
			return;
		case PARK:
			service.park(data);
			return;
		case LEAVE:
			service.leaveParkingLot(data);
			return;
		case STATUS:
			service.printStatus();
			return;
		case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR:
			service.printRegirationNumberFromColor(data);
			return;
		case SLOT_NUMBER_FOR_CAR_WITH_REGISTRATION_NUMBER:
			service.printSlotFromRegistrationNumber(data);
			return;
		case SLOT_NUMBERS_FOR_CAR_WITH_COLOR:
			service.printSlotsFromColor(data);
			return;
		default:
			Utils.printInvalidInput(data);
			return;

		}
	}

	public static String getInput() {
		return input;
	}
}
