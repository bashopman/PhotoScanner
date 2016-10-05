package net.familiehopman.tools.photoscanner.config;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

public class AppConfig {

	private static final String CONFIG_RESOURCE = "config/config.json";
	private static final Logger LOGGER = Logger.getLogger(AppConfig.class.getSimpleName());
	private String photoFolder;

	public String getPhotoFolder() {
		return photoFolder;
	}

	public void setPhotoFolder(String photoFolder) {
		this.photoFolder = photoFolder;
	}
	
	public static AppConfig load() {
		AppConfig appConfig = null;
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(AppConfig.class.getClassLoader().getResourceAsStream(CONFIG_RESOURCE), "UTF-8");
			appConfig = new Gson().fromJson(inputStreamReader, AppConfig.class);
		} catch (UnsupportedEncodingException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		return appConfig;
	}
}
