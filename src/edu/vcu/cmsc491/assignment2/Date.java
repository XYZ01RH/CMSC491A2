/**
 * Riley Hanson
 * CMSC 491 Assingment 2
 * Fall 2015
 */
package edu.vcu.cmsc491.assignment2;



/**
 * @author XYZ10RH
 *
 */
public class Date {

	private long start;
	private long duration;
	private int counter;
	private String password;
	
	private String[] months = { "Jan", "Feb", "Mar", 
			"Apr", "May", "Jun","Jul", "Aug", "Sep", 
			"Oct", "Nov", "Dec" };

	private Login attempt = new Login();


	public Date() {
	} 


	public String findDate()  {
		// timer to get 10min timeframe
		start = System.currentTimeMillis();
		duration = start + 600000;
				
		// look for date password
		while (System.currentTimeMillis() < duration) {
			// Month abbreviations
			for (int i = 0; i < 13; i++) { 
				// Days of the month
				for (int j = 1; j < 32; j++) {
					// Years 1930 - 2015
					for (int k = 1930; k < 2015; k++) {
						counter++;
						password = (String) months[i] + j + k;
						if (attempt.login("user1", password)) {
							return password;
						}					
					} 
				} 
			} 
		} 
		return "No Password Found";
	} 

	public int getCount() {
		return counter;
	}
}
