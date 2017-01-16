/**
 * 
 */
package edu.vcu.cmsc491.a2;

import java.io.*;
import java.util.ArrayList;
import org.apache.commons.lang3.text.WordUtils;

/**
 * @author rileyZ
 *
 */
public class A2_Bonus {
	
	private int counter;
	ArrayList<String> firstList = new ArrayList<String>();
	ArrayList<String> lastList = new ArrayList<String>();
	private String password;
	private Login attempt = new Login();

	/**
	 * 
	 */
	public A2_Bonus() throws IOException {
		
		String filePath = new File("").getAbsolutePath();
		FileReader firstReader = new FileReader(filePath + "/resources/FirstName.txt"); 
		BufferedReader firstBf = new BufferedReader(firstReader);
		
		FileReader lastReader = new FileReader(filePath + "/resources/PopularPasswords.txt");
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

public String bonusCracker() {
		
		for (int i = 0; i < lastList.size(); i++) {
			for (int j = 0; j < firstList.size(); j++) {
				password = firstList.get(j) + lastList.get(i);
				counter++;
				if (attempt.login("user6", password)) {
					return password;
				}
			}
		}
		return "Password was not found";
	}
	
	public int getCount() {
		return counter;
	}

}
