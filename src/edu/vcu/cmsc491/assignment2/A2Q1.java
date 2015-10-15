/**
 * Riley Hanson
 * CMSC 491: Assignment2 Question1
 * Fall 2015
 * 
 * 1 CRACK PASSWORDS
 * (25 pts) Implement a password cracking program to find the passwords of 5 users offline. The login method is provided in Login.class. Please write a Java program A2Q1.java, so that:
 * (1) The program can crack the passwords for "user1", "user2", ..., "user5".
 * (2) Run the program with user names as input and output the password of the user, number of tries, and time used in cracking. For example,
 * > java A2Q1 user1
 * the password for user1 is: xxxxx
 * number of tries: 89947
 * time used: 29 seconds
 * Hint: All passwords are 8 characters long. Through some social engineering effort, we know that the password for user1 is a birth date; the password for user2 is a person’s name; the password for user3 is a few words concatenated; the password for user4 is simple; the pass- word for user5 is popular. Your program should terminate automatically if run for more than 10 minutes without a successful guess. Note that the Login.class for testing may be different than we sample Login.class.
 */
package edu.vcu.cmsc491.assignment2;

import java.io.IOException;

/**
 * @author XYZ01RH
 *
 */
public class A2Q1 {
	public String password;
	public int tryCount = 0;
	public A2Q1(){
		
	}
	
	/** crackPasswords METHOD
	 * @param u - switch of 5 users from Login.class to find
	 * 
	 * from args[0] main assigned which of 5 users to crack password 
	 * for knowing how password is layed out from HINT 
	 * (see Comment lines 1 -15 for assignment instructions)
	 */
	public String crackPasswords(String u){
		
		switch (u) {

		//User1 Password is a Date
		case "user1":

			Date date = new Date();
			password = date.findDate();
			tryCount = date.getCount();
			return password;
		
		//User2 Password is a first and last Name 
		case "user2":
			
			try {
				Name name = new Name();
				password = name.nameCracker();
				tryCount = name.getCount();
				return password;
			} catch (IOException e) {
				e.printStackTrace();
			}

		 //User3 Password is a concatination of Words
		 case "user3":
			try {
				Words w = new Words();
				password = w.checkWord();
				tryCount = w.getCount();
				return password;
			} catch (IOException e) {
				e.printStackTrace();
			}

		//User4 Password is a Simple Password
		case "user4":
			try {
				Popular simple = new Popular();
				//password = simple.simpleCracker();
				tryCount = simple.getCount();
				return password;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return password;

		//User5 Password is a known Popular Password
		case "user5":
			try {
			Popular popular = new Popular();
			//String user = "user5";
			password = popular.popularCracker();
			tryCount = popular.getCount();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return password;

		// Only checks user1 - user5, invalid input error
		default:
			System.out.println("Invalid username, please enter a user: ");
			return "Error: Username not found";
		}

	}


	public static void main(String[] args)  {
		
		A2Q1 passcrack = new A2Q1();
		String user = args[0];
		long startTime = System.currentTimeMillis();
		String password = passcrack.crackPasswords(user);
		long endTime = (System.currentTimeMillis() - startTime) / 1000;
		
		System.out.println("The password for " + user + " is: " + password);
		System.out.println("The time elapsed is: " + endTime + " seconds");
		System.out.println("Number of tries: " + passcrack.tryCount);
		


	}

}
