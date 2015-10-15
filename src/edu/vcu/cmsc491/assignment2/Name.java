/**
 * 
 */
package edu.vcu.cmsc491.assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.text.WordUtils;
/**
 * @author rileyZ
 *
 */
public class Name {

	private long start;
	private long duration;
	private int counter;
	ArrayList<String> firstList = new ArrayList<String>();
	ArrayList<String> lastList = new ArrayList<String>();
	private String password;
	private Login attempt = new Login();
		
	/**
	 * Name Constructor METHOD
	 * 
	 * @param n from main method in A2Q1 as a generic test
	 * 
	 * Fills 2 array lists: one with first names from text file FirstName.txt
	 * Second with Last Names from Surnames.txt
	 * 
	 * In text files beginning of names are capitalized and the rest of the characters are lower case
	 */	
	public Name() throws IOException {
		String filePath = new File("").getAbsolutePath();
		FileReader firstReader = new FileReader(filePath + "/resources/FirstName.txt"); 
		BufferedReader firstBf = new BufferedReader(firstReader);
		
		FileReader lastReader = new FileReader(filePath + "/resources/SurNames.txt");
		BufferedReader lastBf = new BufferedReader(lastReader);

		
		String firstName;
		String lastName;
		
		while ((firstName = firstBf.readLine()) != null) {
			firstName = WordUtils.capitalizeFully(firstName);
			firstList.add(firstName);
		} firstBf.close();
		firstReader.close();
		while ((lastName = lastBf.readLine()) != null) {
			lastName = WordUtils.capitalizeFully(lastName);
			lastList.add(lastName);
		} lastBf.close();
		lastReader.close();
	}

	/**
	 * Cracks Password
	 * 
	 * Takes first name and pairs with each last name.
	 * If the combination length = 8 then it checks this with
	 * Passwords in Login.java using reflection. 
	 * If it matches password in Login.java true is returned.
	 * Else, returns false.
	 */
	
	public String nameCracker() {
		// timer to get 10min timeframe
		start = System.currentTimeMillis();
		duration = start + 600000;
				
		// look for password FirstLast name format
		while (System.currentTimeMillis() < duration) {
			for (int i = 0; i < lastList.size(); i++) {
				for (int j = 0; j < firstList.size(); j++) {
					password = firstList.get(j) + lastList.get(i);
					counter++;
					if (attempt.login("user2", password)) {
						return password;
					}
				}
			}
		}
		return "Password was not found";		
	}
	
	// Number of attempts to crack
	public int getCount() {
		return counter;
	}
}
