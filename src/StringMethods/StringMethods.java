package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length()>s2.length()) {
			return s1;
		}
			return s2;	
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		String newS="";
		if(s.contains("underscores")) {
			s = s.replace(' ', '_');
		}
		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String[] names = {s1, s2, s3};
		for(int i = 0; i < names.length; i++) {
			for(int j = 0; j < names[i].length(); j++) {
				if(names[i].charAt(j)==' ') {
					names[i] = names[i].substring(j+1, names[i].length());
				}
			}
		}
		
		int low = 500;
		int lowest = -1;
		for(int i = 0; i < names.length; i++) {
			if(names[i].charAt(0)<low) {
				low = names[i].charAt(0);
				lowest = i;
			}
		}
		System.out.println(s1);
		
		String[] johns = {s1, s2, s3};
		for(int i = 0; i < johns.length; i++) {
			johns[i] = johns[i].trim();
		}
		
		if(lowest == 0) {
			return johns[0];
		}
		else if(lowest == 1) {
			return johns[1];
		}
		else if(lowest == 2) {
			return johns[2];
		}
		return "None";	
			
			
		}
	
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))){
				sum = sum + Integer.parseInt(Character.toString(s.charAt(i)));
			}
		}
		return sum;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int counter = 0;
		for(int i = 0; i < s.length(); i++) {
			if(i<s.length()-substring.length()+1) {
			if(s.substring(i,i+substring.length()).equals(substring)) {
				counter++;
			}
			}
		}
		return counter;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		byte keyb = (byte) key;
		String encrypted = Utilities.encrypt(s.getBytes(), keyb);
		return encrypted;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		byte keyb = (byte) key;
		String dc = Utilities.decrypt(s, keyb);
		return dc;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int counter = 0;
		for(int i = 0; i < s.length(); i++) {
			if(i>substring.length()) {
			if(s.charAt(i)==' ' && s.substring(i-substring.length(), i).equals(substring)) {
				counter++;
			}
			}
		}
		return counter;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int counter = 0;
		int firstOc = 0;
		int lastOc = 0;
		for(int i = 0; i < s.length(); i++) {
			if(i<s.length()-substring.length()+1) {
			if(s.substring(i,i+substring.length()).equals(substring)) {
				counter++;
				if(counter==1) {
					firstOc = i+substring.length();
				}
				else if(counter>1) {
					System.out.println("reinitializing last Oc");
					lastOc = i;
				}
			}
			}
		}
		System.out.println(s.substring(firstOc, lastOc));
		System.out.println(counter);
		return lastOc-firstOc;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String ss = "";
		String bs="";
		String news="";
		
		for(int i = 0; i < s.length(); i++) {
			if(Character.isLetter(s.charAt(i))&& s.charAt(i)!='â') {
				ss = ss+ Character.toString(s.charAt(i));
			}
		}
		System.out.println(ss);
		for(int i = ss.length()-1; i>=0; i--) {
				bs = bs + Character.toString(ss.charAt(i));
				news = news + Character.toString(ss.charAt(ss.length()-1-i));
		}
		if(news.toUpperCase().equals(bs.toUpperCase())) {
			System.out.println(news+" = "+bs);
			return true;
		}
		return false;
		
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
