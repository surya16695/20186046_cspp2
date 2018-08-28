import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int base = scan.nextInt();
		int height = scan.nextInt();
		areaOfTriangle(base, height);
	}
	/*
	Need to fill the areaOfTriangle function and print the output
	of fahrenheit.
	*/
	public static void areaOfTriangle(final int base, final int height) {
		double area = 0.5 * base * height;
		System.out.println(area);
	}
}