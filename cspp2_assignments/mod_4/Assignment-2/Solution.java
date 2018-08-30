import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    /* Fill the main function to print resultant of addition of matrices*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m1 = s.nextInt();
        int n1 = s.nextInt();
        int m2 = s.nextInt();
        int n2 = s.nextInt();
        int[][] a = new int[m1][n1];
        for ( int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                a[i][j] = s.nextInt();
                System.out.println(Arrays.toString(a));
            }
        }
        int[][] b = new int[m2][n2];
        for ( int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                b[i][j] = s.nextInt();
                System.out.println(Arrays.toString(b));
            }
        }
        int[][] c = new int[m2][n2];
        if (m1 == m2 && n1 == n2) {
            String res = "";
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                        c[i][j] = a[i][j] + b[i][j];
                        res += c[i][j] + " ";
                    }
                    res = res.trim() + "\n";
            }
            System.out.print(res);
        } else {
            System.out.println("not possible");
        }
    }
}
