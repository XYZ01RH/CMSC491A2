/**
 * 
 */
package edu.vcu.cmsc491.a2;

import java.io.*;
import java.util.*;

/**
 * @author rileyZ
 *
 */
public class A2Q2 {

	private String password;
	private boolean valid;
	private int length;
	
	// instantiate constructor
	public A2Q2() {
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	private void getLength(String pw) {
		
		if (pw.length() < 7) {
			setValid(false);
			
		} else {
			length = pw.length();
			try {
				getSimple(pw);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	private void getSimple(String pw) throws IOException {
		ArrayList<String> simpListQ2 = new ArrayList<String>();
		String filePath = new File("").getAbsolutePath();
		FileReader simpleRQ2 = new FileReader(filePath + "/resources/10kCommonSimple.txt");
		BufferedReader simpleBQ2 = new BufferedReader(simpleRQ2);
		String reader;

		while ((reader = simpleBQ2.readLine()) != null) {
			if(reader.length() > 7 && reader.length() < 20) {
				simpListQ2.add(reader);
			}
		}  simpleBQ2.close();
		simpleRQ2.close();
		
		for (int i = 0; i < simpListQ2.size(); i++) {
			String check = simpListQ2.get(i);
			
			if(password == check) {
				setValid(false);
			} else {
				setValid(true);
			}
		}
			
			
	}

	// checkPassword sets valid to true or false
	private void setValid(boolean b) {
		valid = b;
		
	}

	
	private boolean getValid() {
		return valid;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		A2Q2 newPassword = new A2Q2();
		boolean done = false;
		Scanner in = new Scanner(System.in);
		String pw = "";
		
		while(done == false) {
			System.out.println("Please choose a new password: ");
			pw = in.next();
			
			newPassword.getLength(pw);
			
			if( newPassword.getValid() == false ) {
				continue;
			} else {
				
				newPassword.getSimple(pw);
				if (newPassword.getValid() == false) {
					continue;
				} else {
					System.out.println("Congratulations your new password is set.");
					done = true;
					break;
				}
			}
			
		}
		in.close();
	}
}
