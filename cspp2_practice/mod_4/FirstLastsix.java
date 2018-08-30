import java.util.Scanner;
// import java.util.Arrays;
/** To import the methods from the java Directory.**/
public final class FirstLastsix {
    /**
    To process the problem we have to take a class declaration.
    **/
    private static final int SIX = 6;
    /**
    Declaring the value of 6.
    **/
    private FirstLastsix() {
    }
    /**
     @param args Do not modify this main function.
    **/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int b = s.nextInt();
            array[i] = b;
        }
        // System.out.println(array);
        if (array[0] == SIX || array[n - 1] == SIX) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
