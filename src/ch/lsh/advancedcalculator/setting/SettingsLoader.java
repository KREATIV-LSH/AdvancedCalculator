package ch.lsh.advancedcalculator.setting;

import com.google.gson.Gson;

import ch.lsh.advancedcalculator.util.FileUtils;

public class SettingsLoader {
	
	private static Setting activeSetting = null;
	private static String rootPath = System.getProperty("user.home") + "\\.advanced_calculator\\setting";
	
	public static Setting getLoadedSetting() {
		return activeSetting;
	}
	
	public static int updateSetting(String settingName, Setting setting) {
		if(checkRootPath()) {
			if(FileUtils.exists(rootPath + "\\" + settingName + ".json")) {
				if(setting != null) {
					Gson gson = new Gson();
					String json = gson.toJson(setting);
					if(gson.fromJson(json, Setting.class) != null) {
						FileUtils.removeFile(rootPath + "\\" + settingName + ".json");
						FileUtils.saveFile(rootPath + "\\" + settingName + ".json", json);
					} else {
						return 3;
					}
				} else {
					return 3;
				}
			} else {
				return 1;
			}
		} else {
			if(!createRootPath()) {
				return 2;
			}
			updateSetting(settingName, setting);
		}
		return 0;
	}
	
	public static int addSetting(String settingName, Setting setting) {
		if(checkRootPath()) {
			if(!FileUtils.exists(rootPath + "\\" + settingName + ".json")) {
				if(setting != null) {
					Gson gson = new Gson();
					String json = gson.toJson(setting);
					if(gson.fromJson(json, Setting.class) != null) {
						FileUtils.saveFile(rootPath + "\\" + settingName + ".json", json);
					} else {
						return 3;
					}
				} else {
					return 3;
				}
			} else {
				return 1;
			}
		} else {
			if(!createRootPath()) {
				return 2;
			}
			addSetting(settingName, setting);
		}
		return 0;
	}
	
	public static int loadSetting(String settingName) {
		if(checkRootPath()) {
			if(FileUtils.exists(rootPath + "\\" + settingName + ".json")) {
				String content = FileUtils.readFile(rootPath + "\\" + settingName + ".json");
				if(content != "" && content != null) {
					Gson gson = new Gson();
					Setting fromJson = gson.fromJson(content, Setting.class);
					if(fromJson != null) {
						activeSetting = fromJson;
					} else {
						return 3;
					}
				} else {
					return 3;
				}
			} else {
				return 1;
			}
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
	
	public static boolean doesSettingExist(String settingName) {
		return FileUtils.exists(rootPath + "\\" + settingName + ".json");
	}
	
	private static boolean createRootPath() {
		boolean temp = FileUtils.createFolder(rootPath);
		return temp;
	}
	
	public static void loadDefaultSetting() {
		Setting setting = new Setting("3.141592653589793238462643383279502", 6);
		activeSetting = setting;
	}
	
}
