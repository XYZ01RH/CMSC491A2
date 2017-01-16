/**
 * 
 */
package edu.vcu.cmsc491.a2;

import java.util.*;
import java.io.*;

/**
 * @author rileyZ
 *
 */
public class Simple {

	private long start;
	private long duration;
	private int counter;
	ArrayList<String> simpleList = new ArrayList<String>();
	private String password;
	private Login attempt = new Login();
	
	/**
	 * Constructor
	 */
	public Simple() throws IOException {
		String filePath = new File("").getAbsolutePath();
		//User4 Password in this file - abcdefgh
		FileReader simpleReader = new FileReader(filePath + "/resources/10kCommonSimple.txt");
		BufferedReader simpleBf = new BufferedReader(simpleReader);
		String reader;

		while ((reader = simpleBf.readLine()) != null) {
			if(reader.length() == 8) {
				simpleList.add(reader);
			}
		}  simpleBf.close();
		simpleReader.close();
	}
	
	public String simpleCracker() {
		
		// timer to get 10min timeframe
		start = System.currentTimeMillis();
		duration = start + 600000;
		
		// look for a popular password
		while (System.currentTimeMillis() < duration) {	
			for (int i = 0; i < simpleList.size(); i++) {
				password = simpleList.get(i);
				counter++;
				if (attempt.login("user4", password)) {
					return password;
				}
			}
		}
		return "No Password Found";
	}
	
	public int getCount() {
		return counter;
	}
}
