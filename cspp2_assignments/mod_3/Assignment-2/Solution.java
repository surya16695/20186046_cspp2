
import java.util.Scanner;
/*
    Do not modify this main function.
    */
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        String temp = "";
        for (int i = 1; i <= n; i++) {
            temp = temp + i;
        }
        for ( int i = 0; i < temp.length(); i++ ) {
            if (temp.charAt(i) == ('7')) {
                count += 1;             
            }
        }
        System.out.println(count);
    }
}