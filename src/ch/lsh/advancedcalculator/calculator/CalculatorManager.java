package ch.lsh.advancedcalculator.calculator;

import java.util.ArrayList;

import ch.lsh.advancedcalculator.calculator.impl.*;
import ch.lsh.advancedcalculator.calculator.impl.grahping.CalculatorGrahping;

public class CalculatorManager {
	
	private static ArrayList<Calculator> calculatorList = new ArrayList<Calculator>();
	
	public static void setupCalculators() {
		addCalculator(new CalculatorAreaVolumeCircumference());
		addCalculator(new CalculatorInLine());
		addCalculator(new CalculatorGrahping());
	}
	
	private static void addCalculator(Calculator calc) {
		calculatorList.add(calc);
	}
	
	public static ArrayList<Calculator> getCalculatorList() {
		return calculatorList;
	}
	
	public static String[] getCaclulatorNames() {
		ArrayList<String> temp = new ArrayList<String>();
		for (Calculator calc : getCalculatorList()) {
			temp.add(calc.getCalculator());
		}
		return temp.toArray(new String[0]);
	}
	
	public static Calculator getCalculatorByName(String name) {
		for (Calculator calc : getCalculatorList()) {
			if(calc.getCalculator().equalsIgnoreCase(name)) {
				return calc;
			}
		}
		return null;
	}

}
