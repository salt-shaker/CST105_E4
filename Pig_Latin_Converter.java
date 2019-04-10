package pigLatinConverter;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // import the ArrayList class

public class Pig_Latin_Converter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Variables
		String data = "";

		// Open File
		try {
			File myObj = new File(
					"C:\\Users\\Sashae\\eclipse-workspace\\pigLatinConverter\\src\\pigLatinConverter\\words.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data += " " + myReader.nextLine();
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Split words of text file
		String tempArray[] = data.split(" ");

		// Remove empty lines and special chars from array
		ArrayList<String> primaryArray = new ArrayList<String>();

		for (int i = 0; i < tempArray.length; i++) {

			// Strip Special Chars
			tempArray[i] = tempArray[i].replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "");

			// Remove White Space
			if (tempArray[i].matches("^[a-zA-Z0-9]+$")) {
				primaryArray.add(tempArray[i]);
			}

		}

		// Create Pig Latin Conversion
		ArrayList<String> pgcArray = new ArrayList<String>();

		for (String pgc : primaryArray) {

			// Find where vowels begin
			if (pgc.matches("^[aeiouAEIOU](.*)")) {
				pgcArray.add(pgc + "way");
			} else if (pgc.matches("^(.)[aeiouAEIOU](.*)")) {
				pgcArray.add(pgc.replaceAll("^(.)", "") + pgc.charAt(0) + "ay");
			} else if (pgc.matches("^(.)(.)[aeiouAEIOU](.*)")) {
				pgcArray.add(pgc.replaceAll("^(.)(.)", "") + pgc.charAt(0) + pgc.charAt(1) + "ay");
			} else if (pgc.matches("^(.)(.)(.)[aeiouAEIOU](.*)")) {
				pgcArray.add(pgc.replaceAll("^(.)(.)(.)", "") + pgc.charAt(0) + pgc.charAt(1) + pgc.charAt(2) + "ay");
			} else if (pgc.matches("^(.)(.)(.)(.)[aeiouAEIOU](.*)")) {
				pgcArray.add(pgc.replaceAll("^(.)(.)(.)(.)", "") + pgc.charAt(0) + pgc.charAt(1) + pgc.charAt(2)
						+ pgc.charAt(3) + "ay");
			} else if (pgc.matches("^(.)(.)(.)(.)(.)[aeiouAEIOU](.*)")) {
				pgcArray.add(pgc.replaceAll("^(.)(.)(.)(.)(.)", "") + pgc.charAt(0) + pgc.charAt(1) + pgc.charAt(2)
						+ pgc.charAt(3) + pgc.charAt(4) + "ay");
			} else {
				pgcArray.add(pgc.substring(pgc.length() - 1) + pgc.substring(0, pgc.length() - 1) + "ay");
			}
		}

		System.out.printf("  %-20s %-20s %n", "Original", "Pig Latin");
		System.out.println("----------------------------------------------------------");
		for (int i = 0; i < primaryArray.size(); i++) {
			//System.out.println(primaryArray.get(i) + " is also " + pgcArray.get(i));
			System.out.printf("  %-20s %-20s %n", primaryArray.get(i), pgcArray.get(i));
		}

	} // End Method
} // End Class
