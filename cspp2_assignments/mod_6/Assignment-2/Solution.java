import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    private static final int hundered = 100;
    private static final int fifty = 50;
    /**
     * Constructs the object.
    **/
    private Solution() {
        //not used
    }
    /**
     * Function to round the elements of a matrix to the nearest 100.
     *
     * @param      a        Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns  Number of columns
     *private static final int SIX = 6;
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
     final int rows, final int columns) {

    // write ypur code here
        int[][] c = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int d = a[i][j] / hundered;
                int e = a[i][j] % hundered;
                if (e < fifty) {
                    c[i][j] = d * hundered;
                }
                if (e > fifty) {
                    c[i][j] = (d + 1) * hundered;
                }
            }
        }
        return c;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
