import java.util.Scanner;
/** to find the given numbers power with an exp value**/
public final class Solution {
    /** To consider inputs.**/
    private Solution() {
        /* not using the function.*/
    }
    /**
    @param args Do not modify this main function.
    */
    public static void main(final String[] args) {
        /** Assigns values.**/
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    @param b long Need to write the power function and print the output.
    @param e long Need to write the power function and print the output.
    @return long Need to write the power function and print the output.
    **/
    public static long power(final int b, final int e) {
        /** To evaluate the exponential function.**/
        if (e > 0) {
            return b * (power(b, e - 1));
        } else {
            return 1;
        }
    }
}

