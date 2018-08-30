/**
*Add two matrices.
**/
import java.util.Scanner;
/**
*used to take inputs.
**/
public final class Solution {
    /**
    *empty constructor.
    **/
    private Solution() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        int m1, n1, m2, n2;
        Scanner s = new Scanner(System.in);
        m1 = s.nextInt();
        n1 = s.nextInt();
        int[][] a = new int[m1][n1];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                a[i][j] = s.nextInt();
            }
        }

        m2 = s.nextInt();
        n2 = s.nextInt();
        int[][] b = new int[m2][n2];
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                b[i][j] = s.nextInt();
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
