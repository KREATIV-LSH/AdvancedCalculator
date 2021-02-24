package ch.lsh.advancedcalculator.setting;

public class SettingsManager {
	
	public static Setting loadedSetting(String name) {
		int result = SettingsLoader.loadSetting(name);
		if(result == 0) {
			return SettingsLoader.getLoadedSetting();
		} else if(result == 1) {
			System.err.println("Setting doesnt exists! " + name);
			SettingsLoader.loadDefaultSetting();
			return SettingsLoader.getLoadedSetting();
		} else if(result == 2) {
			System.err.println("Could not create root path!");
			SettingsLoader.loadDefaultSetting();
			return SettingsLoader.getLoadedSetting();
		} else if(result == 3) {
			System.err.println("Invalid or corrupted setting file!");
			SettingsLoader.loadDefaultSetting();
			return SettingsLoader.getLoadedSetting();
		} else {
			System.err.println("Invalid load result!");
			System.exit(0);
			return null;
		}
	}
	
	
	public static void updateSetting(String name, Setting setting) {
		int result = SettingsLoader.addSetting(name, setting);
		if(result != 0) {
			result = 10;
			result = SettingsLoader.updateSetting(name, setting);
			if(result == 1) {
				System.err.println("Settings file doesnt exists!");
			} else if(result == 2) {
				System.err.println("Could not create root path!");
			} else if(result == 3) {
				System.err.println("Invalid or corrupted setting JSON!");
			} else {
				System.err.println("Invalid update result!");
				System.exit(0);
			}
		}
	}

}
