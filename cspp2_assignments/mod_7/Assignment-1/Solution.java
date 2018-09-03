import java.util.*;
class InputValidator
{
	String data1;
	InputValidator(String data) {
		this.data1 = data;
	}
	public  boolean validateData()
	{
		return (this.data1.length() >= 6);
	}
	/*Write the atrributes and methods for InputValidator*/
}
public class Solution
{
	private Solution() {

	}

	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
