
// Given an String, Write a java method that returns
//the decimal value for the given binary string.
import java.util.Scanner;

import java.lang.String;

/**
 * Class for solution.
 */
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
    /**
     * { function_description }
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static String reverse(final String s) {
        /**@param s Do not modify this main function.**/
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev = rev + (s .charAt(i));
        }
        return rev;
    }

}
