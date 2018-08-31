
// Given an String, Write a java method that returns
//the decimal value for the given binary string.
import java.util.Scanner;

import java.lang.String;

public class Solution {
	/*
	Do not modify the main function. 
	*/
	/**
    @param s Do not modify this main function.
    @return integer value.
    */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = reverse(s);
		System.out.println(reverse);
	}
	/**Write reverseString function.**/
	public static String reverse(final String s) {
    	/**@param s Do not modify this main function.**/
		String rev = "";
		for (int i = 0;i<s.length() ; i++) {
		 	
	
			rev = (s .charAt(i))+ rev;
		}
		return rev;
	}

}
