import java.util.Scanner;
    /**
    finding the sum of numbers till n.
    **/
public final class SumOfNumber {
    /** To consider inputs.**/
    private Solution() {
        /** not using the function.*/
    }
    /**
    @param args Do not modify this main function.
    **/
    public static void main(final String[] args) {
        /**
        finding the sum of numbers till n.
        **/
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int result = sum(n1);
        System.out.println(result);
    }
    public static int sum(final int n) {
        /**
        sum.
        **/
        int sum = (n * (n + 1) / 2);
        return sum;
    }
}
