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
		char[] s1First = {'z','z', 'z'};
		String[] strings = {s1, s2, s3};

		for(int i = 0; i<s1.length()-1; i++) {
			if(s1.charAt(i)==' '&&s1.charAt(i-1)!=' '&&s1.charAt(i+1)!=' ') {
				s1First[0] = s1.charAt(i+1);
			}	
		}
		for(int i = 0; i<s2.length()-1; i++) {
			if(s2.charAt(i)==' '&&s2.charAt(i-1)!=' '&&s2.charAt(i+1)!=' ') {
				s1First[1] = s2.charAt(i+1);
			}	
		}
		for(int i = 0; i<s2.length()-1; i++) {
			if(s3.charAt(i)==' '&&s3.charAt(i-1)!=' '&&s3.charAt(i+1)!=' ') {
				s1First[2] = s3.charAt(i+1);
			}	
		}
		int lowest = s1First[0];
		char lowestC = 'z';
		for(int i = 0; i < 3; i++) {
			if(lowest > s1First[i]) {
				System.out.println("New lowest: "+s1First[i]+" Old lowest: "+lowestC);
				lowestC = s1First[i];
				lowest = i;
			}
		}
		return strings[lowest];
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)>47&&s.charAt(i)<58) {
				sum = sum+ Integer.parseInt(s.substring(i,i));
				System.out.println(sum+"+"+ Integer.parseInt(s.substring(i,i)));
			}
		}
		return sum;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		return 0;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		return null;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return null;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		return 0;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		return 0;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
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
