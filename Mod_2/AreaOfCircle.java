
import java.util.Scanner;
/**
*hyrdfjyh.
*/
public class AreaOfCircle {
/**
*hyrdfjyh.
*@param args is parameter for this function.
*/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Radius");
        double r = s.nextDouble();
        double a = area(r);
        System.out.println(a);
    }
    /**
    *hyrdfjyh.
    *@param r is parameter for this function.
    *@return double
    */
    public static double area(final double r) {
        return pi() * r * r;
    }
    /**
    *hyrdfjyh.
    *@return double
    */
    public static double pi() {
        final float pii = 3.14;
        return pii;
    }
}
