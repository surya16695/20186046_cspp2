import java.util.Scanner;
/**
<<<<<<< HEAD
 *@author Surya.
=======
 *@author. 
>>>>>>> da111cdb9d8da910a8300881d4cc85bb99c50cb1
 */
public final class Factorial {
    /*
    *Do not modify this main function.
    */
    /**
    * Empty Constructor.
    */
    private Factorial() {
        //Iam not using this constructor
    }
    /**
    * Main function to print.
    * @param args is the parameter for this function
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        int factorial = fact(number);
        System.out.println(factorial);
    }
    /**
    * { function_description }.
    *
    * @param n is the parameter of this method.
    *
    * @return we are returning n
    */
    public static int fact(final int num) {

        if ((num == 0) || (num == 1)) {
            return 1;
        } else {
            return num * fact(num - 1);
        }
    }
}
