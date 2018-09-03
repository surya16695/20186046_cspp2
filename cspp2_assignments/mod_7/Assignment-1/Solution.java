import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { var_description }.
     */
    private static final int SIX = 6;
    String data;
    InputValidator(final String data) {
        this.data = data;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public  boolean validateData()
    {
        return (this.data.length() >= SIX);
    }
    /*Write the atrributes and methods for InputValidator*/
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);     
        System.out.println(i.validateData());

    }

}
