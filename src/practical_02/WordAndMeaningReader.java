package practical_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordAndMeaningReader {
	private static Scanner sn;
	private static File file;

	WordAndMeaningReader(File file) {
		this.file = file;
	}

	public Map<String, String> dictionaryData() {
		Map<String, String> dictionary = new HashMap();
		String data;
		try {
			sn = new Scanner(file);
			while (sn.hasNextLine()) { // remove the
				// whitespace before/after
				data = sn.nextLine().trim();
				// ignore blank line
				if (data.length() > 0) {
					String[] word = data.split("-");
					// insert the lint into map as key and value
					dictionary.put(word[0].trim().toLowerCase(), word[1].trim());
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return dictionary;

	}
}
