import java.util.*;
class InputValidator
{
    /**
     * { var_description }
     */
    String data1;
    InputValidator(String data) {
        this.data1 = data;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public  boolean validateData()
    {
        return (this.data1.length() >= 6);
    }
    /*Write the atrributes and methods for InputValidator*/
}
/**
 * Class for solution.
 */
public class Solution
{
    /**
     * Constructs the object.
     */
    private Solution() {

    }

    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);     
        System.out.println(i.validateData());

    }

}
