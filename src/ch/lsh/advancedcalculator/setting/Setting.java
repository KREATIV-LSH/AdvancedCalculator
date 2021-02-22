package ch.lsh.advancedcalculator.setting;

public class Setting {
	
	private String PI;
	private int roundingDigits;
	
	
	public Setting(String PI, int rounding) {
		this.PI = PI;
		this.roundingDigits = rounding;
	}
	
	public String getPI() {
		return PI;
	}
	
	public void setPI(String pI) {
		PI = pI;
	}
	
	public int getRoundingDigits() {
		return roundingDigits;
	}
	
	public void setRoundingDigits(int roundingDigits) {
		this.roundingDigits = roundingDigits;
	}

}
