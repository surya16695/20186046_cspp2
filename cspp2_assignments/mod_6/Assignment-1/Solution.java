
import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }

    /**
     * Determines if prime.
     *
     * @param      n     { parameter_description }
     *
     * @return     True if prime, False otherwise.
     */
    public static boolean isPrime(final int n) {
        boolean flag = false;
        for (int i = 2; i <= n / 2; i++) {
            // condition for nonprime number
            if (n % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    /**
     * { printing composite numbers }.
     *
     * @param      n     { parameter_description }
     */
    static void oddComposites(final int n) {
    // write your code here
        for (int i = 2; i < n; i++) {
            if (i % 2 != 0) {
                isPrime(i);
                if (isPrime(i) == true) {
                    System.out.println(i);
                }
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}
