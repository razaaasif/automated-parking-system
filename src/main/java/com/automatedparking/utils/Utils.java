package com.automatedparking.utils;

import com.automatedparking.ParkingLotApplication;

public class Utils {
	// make it singleton no object creation
	private Utils() {
	}

	public static String nullSafeString(String str) {
		return str == null || str.trim().length() == 0 ? "" : str.trim();
	}

	public static void printErroInConsole(Object data) {
		if (data == null)
			data = ParkingLotApplication.getInput();
		System.out.println("Invalid command << " + data + " >>");
	}

	public static void printErroInConsole() {
		String data = ParkingLotApplication.getInput();
		printErroInConsole(data);
	}

	public static void printInvalidInput(Object data) {
		printErroInConsole(null);
		System.err.println(data);
		if (data instanceof Throwable) {
			Throwable err = (Throwable) data;
			err.printStackTrace();
		}
	}

	public static String toTitleCaseCar(String input) {
		StringBuilder titleCase = new StringBuilder();
		boolean nextTitleCase = true;

		for (char c : input.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				nextTitleCase = true;
			} else if (nextTitleCase) {
				c = Character.toTitleCase(c);
				nextTitleCase = false;
			} else {
				c = Character.toLowerCase(c);
			}
			titleCase.append(c);
		}

		return titleCase.toString();
	}
}
