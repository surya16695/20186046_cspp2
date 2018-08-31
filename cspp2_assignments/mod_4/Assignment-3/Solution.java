import java.util.Scanner;
// Given an String, Write a java method that returns the decimal value
//for the given binary string.
/**
*TO create a soltion.
**/
public final class Solution {
    /**
    *TO create a soltion.
    **/
    private Solution() {
        /* not using the function.*/
    }
    /*
    Do not modify this main function.
    */
    /**
    @param args Do not modify this main function.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int res = binaryToDecimal(s);
            /**Write binaryToDecimal function.**/
            System.out.println(res);
        }
    }
    public static int binaryToDecimal(final String s) {
        /**Write binaryToDecimal function.**/
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum += Math.pow(2, s.length() - i - 1);
                /**System.out.println(sum).**/
            }
        }
        return (sum);
    }

}
