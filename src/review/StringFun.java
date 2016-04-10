/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class StringFun
{
	
	
	public static boolean stringHasUniqueChars(String input) {
		if (input == null) {
			throw new IllegalArgumentException("input is null");
		}
		Set<Character> foundChars = new HashSet();
		for (int i = 0 ,size = input.length();  i < size; i++) {
			char j = input.charAt(i);
		    if (foundChars.contains(j)) {
		    	return false;
		    }
			foundChars.add(j);
		}
		return true;
	}
	
		public static String reverseString(String input) {
		String answer = "";
		if (input == null) {
			throw new IllegalArgumentException("input is null");
		}

		for (int i = 0 ,size = input.length();  i < size; i++) {
			char j = input.charAt(size-i-1);
		    answer += j;
		}
	    return answer;	
	}
	public static boolean isPermutation(String first, String second) {
		if (first == null || second == null) {
			throw new IllegalArgumentException("input is null");
		}
		if (first.length() != second.length()) {
			return false;
		}
		Map<Character, Integer> chars = new HashMap();
		for (int i = 0 ,size = first.length();  i < size; i++) { 
			char nextChar = first.charAt(i);
		    chars.put(nextChar, chars.containsKey(nextChar) ? chars.get(nextChar)+1 : 1);
		}
		for (int i = 0 ,size = second.length();  i < size; i++) { 
			char nextChar = first.charAt(i);
		    if (!chars.containsKey(nextChar)) {
		    	return false;
		    } else {
		    	chars.put(nextChar, chars.get(nextChar)-1);
		    }
		}
		for (int j : chars.values()) {
			if (j != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static String reverseWords(String originalString) {
		if (originalString == null) {
			throw new IllegalArgumentException("input is null");
		}
		StringBuilder reverseString = new StringBuilder();
		int i = originalString.length() - 1;
		int posLastSpace = originalString.length() - 1;
		int counter = 0;
		while (i >= 0) {
			if (originalString.charAt(i) == ' ' && i != posLastSpace) {
				reverseString.append(originalString.substring(i+1, i+1+counter));
				reverseString.append(" ");
				counter = 0;
			} else {
			  counter++;
			}
			i--;
		}
		if ( counter > 0) {
			reverseString.append(originalString.substring(0, counter));
		}
		return reverseString.toString();
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// determine id a string has all unique characters
		System.out.println(stringHasUniqueChars("this is a test"));
		System.out.println(stringHasUniqueChars("thiswork"));
		System.out.println(stringHasUniqueChars("thisfail"));
		// reverse a string
		System.out.println(reverseString("this is a test"));
		System.out.println(reverseString("thiswork"));
		System.out.println(reverseString("thisfail"));
		// permutations
		System.out.println(isPermutation("wait","tiaw"));
		System.out.println(isPermutation("basic","hard"));
		System.out.println(isPermutation("","super long string"));
		// reverse words
		System.out.println(reverseWords("this is a wonderful place"));
		System.out.println(reverseWords(" this is a wonderful place "));
		System.out.println(reverseWords(" this is a wonderful place    "));
		System.out.println(reverseWords("basic"));
		System.out.println(reverseWords(""));
	}
}
