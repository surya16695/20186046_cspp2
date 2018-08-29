import java.util.Scanner;
/**
 *do not modify this main function.
 * @author Supriya
 */
public final class Solution {
    /**
    *Private constructor.
    */
    private Solution() {
        //We are not using this constructor.
    }
    /**
    *@variable FOUR variable.
    */
    private static final int FOUR = 4;
    /**
     *do not modify this main function.
     *@param args variable
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /**
     *Need to write the rootsOfQuadraticEquation function and print output.
     *@param a variable a
     *@param b variable b
     *@param c variable c
     */
    public static void rootsOfQuadraticEquation(final int a,
                                                final int b,
                                                final int c) {
        long det = (b * b) - (FOUR * a * c);
        double root1 = (-b + Math.sqrt(det)) / (2 * a);
        double  root2 = (-b - Math.sqrt(det)) / (2 * a);
        System.out.println(root1 + " " + root2);
        }
    }

