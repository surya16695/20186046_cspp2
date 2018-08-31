
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		for(int i=0;i<=n;i++){
			String s=sc.next();
			int res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static int binaryToDecimal (String s) {
		int sum = 0;
		int k = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '1') {
				sum += Math.pow(2, k);
				k += 2;
				// System.out.println(sum);
			}
		}
		return (sum);
	}

}
