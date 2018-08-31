import java.util.Scanner;
/**
* Class for Concatenate.
*/
public final class Concatenate {
   /**
    * Constructs the object.
    */
   private Concatenate() {

   }
   /**.
    * { function_description }
    *
    * @param      args  The arguments
    */
   public static void main(final String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       System.out.println("Hello " + str + "!");
   }
}
