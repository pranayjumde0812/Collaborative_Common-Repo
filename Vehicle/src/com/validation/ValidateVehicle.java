package com.validation;

import java.util.ArrayList;

import com.color.Color;
import com.exception.ColorNotFoundException;
import com.exception.DuplicateChasisException;
import com.exception.PollutionExceededException;

public class ValidateVehicle {
	public static String duplicateChasis(String chasisNo, ArrayList<String> ch) throws DuplicateChasisException {
		if (ch.contains(chasisNo) == true) {
			throw new DuplicateChasisException("chasisNo alreday present");
		}
		return chasisNo;
	}

	public static double pollutionValidation(double pollutionLevel) throws PollutionExceededException {
		if (pollutionLevel > 20) {
			throw new PollutionExceededException("pollution level exceeded the limit");
		}
		return pollutionLevel;
	}

	public static Color colorValidation(String name) throws ColorNotFoundException {
		for (Color c : Color.values()) {
			if (c.name().equalsIgnoreCase(name)) {
				return c;
			}
		}
		throw new ColorNotFoundException("Color is not present in the list");

	}
}
