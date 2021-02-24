package ch.lsh.advancedcalculator.main;

import ch.lsh.advancedcalculator.calculator.CalculatorManager;
import ch.lsh.advancedcalculator.frame.FrameSelectCalculator;
import ch.lsh.advancedcalculator.setting.Setting;
import ch.lsh.advancedcalculator.setting.SettingsLoader;
import ch.lsh.advancedcalculator.setting.SettingsManager;

public class Main {

	public static void main(String[] args) {
		if(!SettingsLoader.doesSettingExist("default")) {
			SettingsManager.updateSetting("default", new Setting("3.141592653589793238462643383279502", 6));
		}
		CalculatorManager.setupCalculators();
		FrameSelectCalculator selectCalculatorFrame = new FrameSelectCalculator();
	}

}
