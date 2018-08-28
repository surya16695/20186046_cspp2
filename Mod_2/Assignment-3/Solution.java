import java.util.Scanner;

public class Solution {
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        int result=power(base,exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
    public static int power(final int b, final int e){
        if (e > 0) {
            return b * (power(b, e-1));
        } else {
            return 1;
        }
    }
}
