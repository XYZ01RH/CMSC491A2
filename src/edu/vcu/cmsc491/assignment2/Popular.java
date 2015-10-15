/**
 * Riley Hanson
 * CMSC 491 Assingment 2
 * Fall 2015
 *
 */
package edu.vcu.cmsc491.assignment2;

import java.util.*;
import java.io.*;

/**
 * @author XYZ01RH
 *
 */

public class Popular {
	
	private long start;
	private long duration;
	private int counter;
	ArrayList<String> popularList = new ArrayList<String>();
	ArrayList<String> simpleList = new ArrayList<String>();
	private String password;
	private Login attempt = new Login();
	
	public Popular() throws IOException {
		String filePath = new File("").getAbsolutePath();
		FileReader popularReader = new FileReader(filePath + "/resources/PopularPasswords.txt"); 
		BufferedReader popularBf = new BufferedReader(popularReader);
//		FileReader simpleReader = new FileReader(filePath + "/resources/top10000.txt");
//		BufferedReader simpleBf = new BufferedReader(simpleReader);
		String reader;

		
		while ((reader = popularBf.readLine()) != null) {
			if(reader.length() == 8) {
				popularList.add(reader);
				simpleList.add(reader);
			} else {
				simpleList.add(reader);
			}
		} popularBf.close();
		popularReader.close();
//		
//		while ((reader = simpleBf.readLine()) != null) {
//			simpleList.add(reader);
//		} simpleBf.close();
//		simpleReader.close();
	}
		
	public String popularCracker() {
		// timer to get 10min timeframe
		start = System.currentTimeMillis();
		duration = start + 600000;
				
		// look for a popular password
		while (System.currentTimeMillis() < duration) {	
			for (int i = 0; i < popularList.size(); i++) {
				//for (int j = 0; j < popularList.size(); j++) {
				password = popularList.get(i);
				counter++;
				if (attempt.login("user5", password)) {
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
