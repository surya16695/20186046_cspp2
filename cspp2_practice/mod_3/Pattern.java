import java.util.Scanner;
/** Printing a pattern.**/
public final class Pattern {
   /** Printing a pattern.**/
    private Pattern() {
        /* not using the function.*/
    }
    /**
    @param args Do not modify this main function.
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(count + " ");
                count += 1;
            }
            System.out.println();
        }
    }
}
