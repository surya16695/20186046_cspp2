
import java.util.Scanner;
/** imports the values from the java library**/
public class BiggerEqualSmaller {
    /**Consider the Values to compare**/
    public static void main(final String[] args){
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int t = s.nextInt();
        if (r == t) {
            System.out.println("Equal numbers.");       
        } else if (r > t) {
                System.out.println(r + " is greater than " + t);
        } else {
            System.out.println(r + " is less than " + t);
        }
    }
}