package com.automatedparking.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class LoggerFactory {
	private static final String LOG_FILE_PATH = "debug.log";
	private static final Map<Class<?>, Logger> loggers = new HashMap<>();

	private LoggerFactory() {
	}

	public static Logger getLogger(Class<?> clazz) {
		return loggers.computeIfAbsent(clazz, Logger::new);
	}

	public static class Logger {
		private final PrintStream printStream;
		private Class<?> clazz;

		private Logger(Class<?> clazz) {
			this.clazz = clazz;
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(LOG_FILE_PATH, true); // Append mode
				printStream = new PrintStream(fileOutputStream);
			} catch (IOException e) {
				throw new RuntimeException("Error creating log file", e);
			}
		}

		public void log(Object... message) {
			printStream.print(clazz.getCanonicalName() + "::");
			for (Object obj : message) {
				printStream.print(obj);
				printStream.print(" ");
			}
			printStream.println();
		}

	}
}
