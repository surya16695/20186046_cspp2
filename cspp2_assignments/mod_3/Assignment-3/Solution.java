
import java.util.Scanner;
/*
    Do not modify this main function.
    */
public class Solution {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcd = gcd(n1,n2);
        System.out.println(gcd);
    }
    /*
    Need to write the gcd function and print the output.
    */
    public static int gcd(int a, int b) {
        int gcd = 0;      
        for (int i = 1;  i <= a && i <= b; i++) {
            if ((a%i == 0) && (b%i == 0)) {
                gcd = i;
            }
        }
        return gcd;
    }
}
