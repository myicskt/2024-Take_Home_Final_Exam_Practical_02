package practical_02;

import java.io.File;

public class FilePathChecker {
	private File file;

	// create a construct
	public FilePathChecker(File file) {
		this.file = file;

	}

	public boolean checkFileIsExist() {
		return file.exists();

	}

}
