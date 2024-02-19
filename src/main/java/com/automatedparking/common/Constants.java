package com.automatedparking.common;

public class Constants {
	public enum PARKING_COMMAND {
		CREATE_PARKING_LOT("create_parking_lot"),
		PARK("park"), LEAVE("leave"),
		STATUS("status"),
		REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR("registration_numbers_for_cars_with_color"),
		SLOT_NUMBER_FOR_CAR_WITH_REGISTRATION_NUMBER("slot_number_for_car_with_registration_numbers"),
		SLOT_NUMBERS_FOR_CAR_WITH_COLOR("slot_numbers_for_car_with_color"),
		EXIT("exit");

		private String value;

		private PARKING_COMMAND(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static PARKING_COMMAND getCommandByValue(String value) {
			for (PARKING_COMMAND command : PARKING_COMMAND.values()) {
				if (command.getValue().equalsIgnoreCase(value)) {
					return command;
				}
			}

			return null;
		}

	}
}
