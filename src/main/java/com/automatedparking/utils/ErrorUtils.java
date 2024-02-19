package com.automatedparking.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ErrorUtils {
	static {
		String filePath = "error.log";

		try {
			// Create a FileOutputStream to write errors to the file
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);

			// Create a PrintStream to write errors to both file and console
			PrintStream printStream = new PrintStream(fileOutputStream);

			// Redirect System.err to the PrintStream
			System.setErr(printStream);

			// Generate some errors (for demonstration)
			System.err.println("Log Started!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ErrorUtils() {

	}

}
