package com.automatedparking.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.automatedparking.model.Car;
import com.automatedparking.model.ParkingLot;
import com.automatedparking.utils.LoggerFactory;
import com.automatedparking.utils.LoggerFactory.Logger;
import com.automatedparking.utils.Utils;

public class ParkingLotServiceImpl implements ParkingLotService {
	private static Logger logger = LoggerFactory.getLogger(ParkingLotServiceImpl.class);

	private static TreeMap<Integer, ParkingLot> parkingLots = null;

	private static int slots = 0;

	@Override
	public void createSlots(int slots) {
		logger.log("createSlots -> " + slots);
		ParkingLotServiceImpl.slots = slots;
		parkingLots = new TreeMap<>();
		for (int i = 1; i <= slots; i++) {
			parkingLots.put(i, null);
		}
	}

	@Override
	public void park(String registration, String color) {
		int slot = getFreeSlot();
		if (slot > 0) {
			Car car = new Car(registration.toUpperCase(), Utils.toTitleCaseCar(color), slot);
			ParkingLot parking = new ParkingLot(slot, car);
			parkingLots.put(slot, parking);
			System.out.println("Allocated slot number: " + slot);
			this.printParkedLots();
		} else if (slot == 0)
			System.out.println("Sorry, parking lot is full");
		else if (slot == -1) {
			System.out.println("Please, create parking lot first");
		}
	}

	private void printParkedLots() {
		if (!Objects.isNull(parkingLots)) {
			parkingLots.entrySet().forEach(t -> {
				logger.log("printParkedLots() -> [ " + t.getKey() + "," + " value :" + t.getValue() + " ] "
						+ System.lineSeparator());
			});
		}
	}

	private int getFreeSlot() {
		// if parking lot is not created yet
		if (Objects.isNull(parkingLots)) {
			return -1;
		}
		// checking if the parking lot is full or int the range
		logger.log("getFreeSlot() size ->" + parkingLots.size());
		if (parkingLots.size() >= 1 && parkingLots.size() <= slots) {
			// if the parking lot value in null that means it is free space
			Optional<Map.Entry<Integer, ParkingLot>> value = parkingLots.entrySet().stream()
					.filter(t -> t.getValue() == null).findFirst();
			if (value.isPresent()) {
				return value.get().getKey();
			}
		}
		// in case we can not park anymore parking lot full
		return 0;
	}

	@Override
	public void leaveParkingLot(Integer slot) {
		if (!Objects.isNull(parkingLots)) {
			if (!parkingLots.isEmpty() && parkingLots.get(slot) != null) {
				logger.log("leaveParkingLot() leaved -> " + parkingLots.put(slot, null));
				System.out.println("Slot number " + slot + " is free");
			} else {
				// if it is already free
				System.out.println("Given slot " + slot + " is already free");
			}
		}
	}

	@Override
	public void printStatus() {
		System.out.println(String.format("|%8s | %20s | %11s |", "Slot No.", "  Registration No.  ", "   Color   "));
		if (parkingLots != null && slots > 0) {
			parkingLots.values().stream().filter(parkingLot -> parkingLot != null).forEach(
					parkingLot -> System.out.println(String.format("|%8d | %20s | %11s |", parkingLot.getSlotNumber(),
							parkingLot.getCar().getRegistrationNumber(), parkingLot.getCar().getColor())));
		}
	}

	@Override
	public void printRegirationNumberFromColor(String color) {
		if (parkingLots != null && slots > 0) {
			List<String> rNumbers = parkingLots.values().stream()
					.filter(parkingLot -> parkingLot != null && color.equalsIgnoreCase(parkingLot.getCar().getColor()))
					.map(t -> t.getCar().getRegistrationNumber()).collect(Collectors.toList());
			if (!rNumbers.isEmpty()) {
				System.out.println(String.format("|%20s|", "  Registration No.  "));
				rNumbers.forEach(rnumber -> System.out.println(String.format("|%20s|", rnumber)));
			} else {
				System.out.println("No Car found with the given color :" + color);
			}
		}

	}

	@Override
	public void printSlotFromRegistrationNumber(String registrationNo) {
		if (parkingLots != null && slots > 0) {
			ParkingLot lot = parkingLots.values().stream()
					.filter(parkingLot -> parkingLot != null
							&& registrationNo.equalsIgnoreCase(parkingLot.getCar().getRegistrationNumber()))
					.findFirst().orElse(null);
			if (!Objects.isNull(lot)) {
				System.out.println(String.format("|%8s|", "Slot No."));
				System.out.println(String.format("|%8s|", lot.getSlotNumber()));
			} else {
				System.out.println("No Car found with the given registration No. : " + registrationNo);
			}
		}
	}

	@Override
	public void printSlotsFromColor(String color) {
		System.out.println(String.format("|%8s|", "Slot No."));
		if (parkingLots != null && slots > 0) {
			List<Integer> slots = parkingLots.values().stream()
					.filter(parkingLot -> parkingLot != null && color.equalsIgnoreCase(parkingLot.getCar().getColor()))
					.map(t -> new Integer(t.getSlotNumber())).collect(Collectors.toList());
			if (!slots.isEmpty()) {
				slots.forEach(t -> System.out.println(String.format("|%8s|", t)));
			} else {
				System.out.println("No Car found with the given color : " + color);
			}
		}
	}

}
