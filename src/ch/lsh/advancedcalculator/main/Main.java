package ch.lsh.advancedcalculator.main;

import ch.lsh.advancedcalculator.calculator.CalculatorManager;
import ch.lsh.advancedcalculator.frame.FrameSelectCalculator;

public class Main {

	public static void main(String[] args) {
		CalculatorManager.setupCalculators();
		FrameSelectCalculator selectCalculatorFrame = new FrameSelectCalculator();
	}

}
