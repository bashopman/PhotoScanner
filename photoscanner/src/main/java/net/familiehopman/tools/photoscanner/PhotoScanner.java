package net.familiehopman.tools.photoscanner;

import java.io.File;
import java.util.Collection;

import net.familiehopman.tools.photoscanner.config.AppConfig;
import net.familiehopman.tools.photoscanner.scanners.DirectoryScanner;

public class PhotoScanner 
{
    private AppConfig appConfig;

	public static void main( String[] args )
    {
    	PhotoScanner photoScanner = new PhotoScanner();
    	photoScanner.loadConfig();
    	photoScanner.run();
    }

	private void loadConfig() {
		appConfig = AppConfig.load();
	}

	private void run() {
		Collection<File> foundFiles = DirectoryScanner.findFiles(appConfig.getPhotoFolder(), new String[]{"jpg"});
//		for (File file : foundFiles) {
//			System.out.println(file.getAbsolutePath());
//		}
		System.out.println(String.format("Found %d files", foundFiles.size()));
	}
}
