/**
 * Riley Hanson
 * CMSC 491 Assingment 2
 * Fall 2015
 */
package edu.vcu.cmsc491.assignment2;

import java.io.*;
import java.util.*;

/**
 * @author XYZ01RH
 *
 */
public class Words {
	
	private long start;
	private long duration;
	private int counter;
	ArrayList<String> wordList = new ArrayList<String>();
	private String password;
	private Login attempt = new Login();
	
	public Words() throws IOException {
		String filePath = new File("").getAbsolutePath();
		FileReader wordReader = new FileReader(filePath + "/resources/top10000.txt"); 
		BufferedReader wordBf = new BufferedReader(wordReader);
		
		String word;
		
		while((word = wordBf.readLine()) != null) {
			if(word.length() < 7) {
				wordList.add(word);
			}
		} wordBf.close();
		wordReader.close();
	}

	/**
	 * 
	 * @return
	 */
	public String checkWord() {
		// looking for 3 concatenated words
		String word1;
		String word2;
		String word3;
		
		// timer to get 10min timeframe
		start = System.currentTimeMillis();
		duration = start + 600000;
		
		// look for password of 3 words together with in time frame
		while (System.currentTimeMillis() < duration) {
			for (int i = 0; i < wordList.size(); i++) {
				for (int j = 0; j < wordList.size(); j++) {
					for (int k = 0; k < wordList.size(); k++) {
						word1 = wordList.get(i);
						word2 = wordList.get(j);
						word3 = wordList.get(k);

						counter++;
						password = word1 + word2 + word3;
						
						if (word1.length() + word2.length() + word3.length() == 8) {
							if (attempt.login("user3", password)) {
								return password;
							}
						} else { continue;}
					}
				}
			}
		}
		return "No Password Found";				
	}
	// number of attempts until found (or until timer stopped)
	public int getCount() {
		return counter;
	}
}
