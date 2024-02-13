package practical_02;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainDictionary {
	private static String filepath;
	private static File file;
	private static Map<String, String> map;
	private static Scanner scanner;

	private static FilePathChecker filechecker;
	private static WordAndMeaningReader reader;

	public static void main(String[] args) {

		filepath = "src\\resource\\dataofdictionarytextfile.text";
		file = new File(filepath);
		filechecker = new FilePathChecker(file);
		reader = new WordAndMeaningReader(file);
		map = new HashMap();
		scanner = new Scanner(System.in);
		System.out.println("Enter the word to get meaning ");
		System.out.println("example aple,table,orange ");

		String input = scanner.next().toLowerCase();

		if (filechecker.checkFileIsExist() == true) {

			map = reader.dictionaryData();
			if (map.containsKey(input) == true) {
				System.out.println(input.toUpperCase());
				String[] meaning = map.get(input).split(",");
				for (int i = 0; i < meaning.length; i++) {
					System.out.println("\t meaning " + (i + 1) + " : " + meaning[i].trim());
				}
			} else {
				System.out.println("could not found the word : " + input);
			}
		} else {
			System.out.println("File is not exist ");
			System.out.println("Curent file path: " + filepath);

		}

	}

}
