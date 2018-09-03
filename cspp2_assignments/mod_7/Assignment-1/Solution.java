import java.util.Scanner;
/**
 * Class for input validator.
 */
final class InputValidator {
    /**
     * { var_description }.
     */
    private static final int SIX = 6;
    private String data;
    /**
     * Constructs the object.
     * @param      datum  The data
     * nothing.
     */
    InputValidator(final String datum) {
        this.data = datum;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public  boolean validateData() {
        return (this.data.length() >= SIX);
    }
    /*Write the atrributes and methods for InputValidator.*/
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
