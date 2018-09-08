import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author     : Surya
 */
class Set {
    //
    // your code goes here... Good luck :-)
    //
    private static final int TEN = 10;
    /**
     * { var_description }
     */
    private int[] set;
    /**
     * { var_description }
     */
    private int size;
    /**
     * Constructs the object.
     */
    public Set() {
        set = new int[TEN];
        size = 0;
    }
    /**
     * { function_description }
     *
     * @param      item  The item
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        if (size >= set.length) {
            resize();
        }
        set[size++] = item;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * { function_description }
     */
    public void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }
    /**
     * { function_description }
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (index >= 0 && index < size) {
            return set[index];
        }
        return -1;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        if (size == 0) {
            return "{}";
        }
        String s = "{";
        int i;
        for (i = 0; i < size - 1; i++) {
            s += set[i] + ", ";
        }
        s += set[i] + "}";
        return s;
    }
    /**
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        // Replace the code below
        // return indexOf(item) != -1;
        for (int i = 0; i < size; i++) {
            if (item == set[i]) {
                return true;
            }
        }
        return false;
    }
    /**
     * { function_description }
     *
     * @param      newArray  The new array
     */
    public void add(final int[] newArray) {
        // if (size + newArray.length >= list.length) {
        //     resize();
        // }
        for (int i = 0; i < newArray.length; i++) {
        	if (contains(newArray[i]) == false) {
            	add(newArray[i]);	
        	}
        }
    }
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
    /**
     * { function_description }
     *
     * @param      newArray  The new array
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(final Set newArray) {
    	Set sot = new Set();
    	int count = 0;
    	for (int i = 0; i < newArray.size(); i++) {
			if(contains(newArray.get(i))) {
				int temp = (get(indexOf(newArray.get(i))));
				sot.add(temp); 
			}
    	}
    	if (sot.size == 0) {
    		return sot;
    	}
    	return sot;
    }
    public Set retainAll(final int[] newArray) {
    	return null;
    }
    public int[][] cartesianProduct(final Set t) {
    	return null;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
