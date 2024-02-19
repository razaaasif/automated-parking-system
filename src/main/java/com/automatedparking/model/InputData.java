package com.automatedparking.model;

import java.util.Arrays;
import java.util.List;

import com.automatedparking.common.Constants.PARKING_COMMAND;

public class InputData {
	private PARKING_COMMAND command;
	private String[] data;

	public PARKING_COMMAND getCommand() {
		return command;
	}

	public void setCommand(PARKING_COMMAND command) {
		this.command = command;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "InputData [command=" + command + ", data=" + Arrays.toString(data) + "]";
	}

}
