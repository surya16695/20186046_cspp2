import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;


/**
 * Class for set.
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
    * private variable size of int type.
    */
    private int size;
    /**
     * private array of int type.
     */
    private int[] array;
    /**
     * Constructor for set object.
     */
    Set() {
        size = 0;
        final int variable = 10;
        array = new int[variable];
    }
    /**
     * size method.
     *
     * @return    returns the size of array.
     */
    public int size() {
        return size;
    }
    /**
     * contains method.
     *
     * @param      searchVariable  The search variable
     *
     * @return returns true if the element is in array.
     */
    public boolean contains(final int searchVariable) {
        for (int i = 0; i < size; i++) {
            if (array[i] == searchVariable) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a string representation of the array.
     *
     * @return     String representation of the array.
     */
    public String toString() {
       if (size == 0) {
            return "{}";
        }
        String resultantString = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            resultantString = resultantString + array[i] + ", ";
        }
        resultantString = resultantString + array[i] + "}";
        return resultantString;
    }
    /**
     * adds the new element to the array.
     *
     * @param      variable  The variable
     */
    public void add(final int variable) {
         int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] != variable) {
                count++;
            }
        }
        if (count == size) {
            array[size++] = variable;
        }
    }
    /**
     * add the new array to old array.
     *
     * @param      newArray  The new array
     */
    public void add(final int[] newArray) {
         if (newArray.length > array.length) {
            array = resize();
        }
           for (int i : newArray) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (array[j] != i) {
                    count++;
                }
            }
            if (count == size) {
                array[size++] = i;
            }
        }
    }
    /**
     * resize method.
     *
     * @return returns the resized array.
     */
    public int[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }
    /**
     * intersection method.
     *
     * @param      inputSet  The input set
     *
     * @return returns the intersection set of two sets.
     */
    public Set intersection(final Set inputSet) {
        Set outputSet = new Set();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < inputSet.size; j++) {
                if (this.array[i] == inputSet.array[j]) {
                    outputSet.add(array[i]);
                }
            }
        }
        return outputSet;
    }
    /**
     * retainall method.
     *
     * @param      intArray  The int array
     *
     * @return     returns the elements present in both sets.
     */
    public Set retainAll(final int[] intArray) {
        Set outputSet = new Set();
        for (int i : this.array) {
            for (int j = 0; j < intArray.length; j++) {
                if (i == intArray[j]) {
                    outputSet.add(i);
                }
            }
        }
        return outputSet;
    }
    /**
     * cartesian product method.
     *
     * @param      outputSet  The output set
     *
     * @return     returns the cartesian product.
     */
    public int[][] cartesianProduct(final Set outputSet) {
       int numberOfElements = this.size * outputSet.size;
        int[][] newArray;
        newArray = new int[numberOfElements][2];
        int i = 0;
            for (int k = 0; k < this.size; k++) {
                for (int j = 0; j < outputSet.size; j++) {

                newArray[i][0] = this.array[k];
                newArray[i][1] = outputSet.array[j];
                i++;

                }
            }

    return newArray;
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
                // System.out.println(s);
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
                int a = s.size();
                intArray = intArray(tokens[2]);
                t.add(intArray);
                int b = t.size();
                if (a == 0 || b == 0) {
                    System.out.println("null");
                } else {
    System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                }

                break;
                default:
                break;
            }
        }
    }
}




