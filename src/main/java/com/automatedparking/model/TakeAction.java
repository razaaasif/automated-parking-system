package com.automatedparking.model;

public class TakeAction {
	private static TakeAction action = null;

	private TakeAction() {
	}

	public static TakeAction getAction() {
		if (action == null) {
			action = new TakeAction();
		}
		return action;
	}

}
