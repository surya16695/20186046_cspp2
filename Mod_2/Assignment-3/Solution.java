import java.util.Scanner;
/* to find the given numbers power with an exp value*/
public class Solution {
    /* To consider inputs*/
    private Solution(){
        /* not using the function*/
    }
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);  
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
    public static long power(final int b, final int e) {
        if (e > 0) {
            return b * (power(b, e - 1));
        } else {
            return 1;
        }
    }
}

