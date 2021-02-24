package ch.lsh.advancedcalculator.setting;

import ch.lsh.advancedcalculator.util.FileUtils;

public class SettingsManager {
	
	private static Setting activeSetting = null;
	private static String rootPath = System.getProperty("user.home") + "\\.advanced_calculator";
	
	public static Setting getLoadedSetting() {
		return activeSetting;
	}
	
	public static int loadSetting(String settingName) {
		if(checkRootPath()) {
			if(FileUtils.exists(rootPath + "\\" + settingName + ".json"));
		} else {
			if(!createRootPath()) {
				loadDefaultSetting();
				return 2;
			}
			loadSetting(settingName);
		}
		return 0;
	}
	
	private static boolean checkRootPath() {
		return FileUtils.exists(rootPath);
	}
	
	private static boolean createRootPath() {
		boolean temp = FileUtils.createFolder(rootPath);
		return temp;
	}
	
	private static void loadDefaultSetting() {
		Setting setting = new Setting("3.141592653589793238462643383279502", 6);
		activeSetting = setting;
	}
	
}
