package net.familiehopman.tools.photoscanner.scanners;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class DirectoryScanner {

	private static final boolean INCLUDE_SUBDIRECTORIES = true;
	
	private DirectoryScanner() {}
	
	public static Collection<File> findFiles(String directoryName, final String[] extensions) {
		File directory = new File(directoryName);
		
		return FileUtils.listFiles(directory, extensions, INCLUDE_SUBDIRECTORIES);
	}
}
