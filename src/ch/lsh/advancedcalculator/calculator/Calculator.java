package ch.lsh.advancedcalculator.calculator;

import javax.swing.JFrame;

public abstract class Calculator {

	private String calculator;
	private int height;
	private int width;
	
	public Calculator(String calculator, int height, int width) {
		this.calculator = calculator;
		this.height = height;
		this.width = width;
	}

	public abstract JFrame execute();

	public String getCalculator() {
		return calculator;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	private static int calculateWidth() {
		int temp = Integer.MIN_VALUE;
		for (Calculator calc : CalculatorManager.getCalculatorList()) {
			temp = Math.max(temp, calc.getCalculator().stripLeading().length());
		}
		return temp * 7 + (3 * 20);
	}
	
	private static int calculateHeight() {
		return  CalculatorManager.getCaclulatorNames().length * 20 + 60;
	}

}
