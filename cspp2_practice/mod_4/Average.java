
import java.util.Scanner;
/** Function in intializing here.**/
public final class Average {
    /** Creating a class.**/
    private Average() {
        /**Doc of no use.**/
    }
    /**
     @param args Do not modify this main function.
    **/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        double t = 0;
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            t = t + a[i];
        }
        double average = t / a.length;
        System.out.println(average);
}
}
