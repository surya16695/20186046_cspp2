import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Surya.
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
    Private Value.
    */
    private int size;
    /**
    Private Value.
    */
    private int[] set;
    /**
    Constructs Set.
    */
    protected Set() {
        final int ten = 10;
        size = 0;
        set = new int[ten];
    }
    /**
     * { Size function }.
     *
     * @return     { Integer }.
     */
    public int size() {
        return size;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        } else {
            String st = new String("{");
            int i = 0;
            for (i = 0; i < size - 1; i++) {
                st += Integer.toString(set[i]) + ", ";
            }
            st += Integer.toString(set[i]) + "}";
            return st;
        }
    }
    /**
     * { Adds Single item to the set }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (!contains(item)) {
            if (size >= set.length) {
                set = resize(set);
            }
            set[size++] = item;
            int[] sub = new int[size];
            System.arraycopy(set, 0, sub, 0, size);
            Arrays.sort(sub);
            set = new int[size];
            set = sub.clone();
        }
    }
    /**
     * { Adds array of elements to set }.
     *
     * @param      arr   The arr
     */
    public void addAll(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }
    /**
     * { Converting to string }.
     *
     * @param      sample  The sample
     * @param      k       { Size }.
     *
     * @return     { String }.
     */
    public String converttostring(final int[] sample, final int k) {
        String st = new String("{");
        int i = 0;
        for (i = 0; i < k - 1; i++) {
            st += Integer.toString(sample[i]) + ", ";
        }
        st += Integer.toString(sample[i]) + "}";
        return st;
    }
    /**
     * { Resize }.
     *
     * @param      arr   The arr
     *
     * @return     { Integer Array }.
     */
    public int[] resize(final int[] arr) {
        int[] arr1 = Arrays.copyOf(arr, 2 * arr.length);
        return arr1;
    }
    /**
     * { SubSet }.
     *
     * @param      fromElement  The from element
     * @param      toElement    To element
     *
     * @return     { Set object }.
     */
    public Set subSet(final int fromElement, final int toElement) throws Exception {
    	if (fromElement > toElement) {
    		throw new Exception("Invalid Arguments to Subset Exception");
    	}
        Set sa = new Set();
        final int ten = 10;
        int j = 0;
        int[] sample = new int[ten];
        for (int i = 0; i < size; i++) {
            if (set[i] >= fromElement && set[i] < toElement) {
                if (j == ten) {
                    resize(sample);
                }
                sample[j] = set[i];
                j++;
            }
        }
        int[] sub = new int[j];
        System.arraycopy(sample, 0, sub, 0, j);
        Arrays.sort(sub);
        sa.set = sub.clone();
        sa.size = j;
        return sa;
    }
    /**
     * { Checks whether item contains or not }.
     *
     * @param      item  The item
     *
     * @return     { Boolean }.
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * { HeadSet }.
     *
     * @param      toElement  To element
     *
     * @return     { Set object }.
     */
    public Set headSet(final int toElement) throws Exception {
        Set sa = new Set();
        final int ten = 10;
        int j = 0;
        int[] sample = new int[ten];
        for (int i = 0; i < size; i++) {
            if (set[i] < toElement) {
                if (j == ten) {
                    resize(sample);
                }
                sample[j] = set[i];
                j++;
            }
        }
        int[] sub = new int[j];
        System.arraycopy(sample, 0, sub, 0, j);
        Arrays.sort(sub);
        sa.set = sub.clone();
        sa.size = j;
        if (sa.size() == 0) {
        	throw new Exception("Set Empty Exception");
        }
        return sa;
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        if (index < 0 || index >= this.size()) {
            return -1;
        } else {
            return set[index];
        }
    }

    /**
     * { function_description }.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(Set other) {
        Set result = new Set();
        for (int i = 0; i < this.size; i++) {
            if (other.contains(this.get(i))) {
            	System.out.println();
                result.add(other.get(i));
                System.out.println(other.get(i));
            }
        }
        return result;
    }
    /**
     * { function_description }.
     *
     * @param      arr   The arr
     *
     * @return     { description_of_the_return_value }
     */
    public Set retainAll(final int[] arr) {
        Set other = new Set();
        for (int item : arr) {
            other.add(item);
        }
        return intersection(other);
    }

    /**
     * { Last }.
     *
     * @return     { Integer }.
     */
    public int last() throws Exception {
        if (size == 0) {
            throw new Exception("Set Empty Exception");
        } else {
            return set[size - 1];
        }
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
        Scanner stdin = new Scanner(
            new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation
            //invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "print":
                System.out.println(s);
                break;
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                break;
            case "retainAll":
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "subSet":
            	try {
	                int[] intArray1 = intArray(tokens[1]);
	                int fromElement = intArray1[0];
	                int toElement = intArray1[1];
                    Set sa = new Set();
                    sa = s.subSet(fromElement, toElement);
                    System.out.println(sa);
                } catch (Exception e) {
                	System.out.println(e.getMessage());
                }
                break;
            case "headSet":
            	try {
                int toElement = Integer.parseInt(tokens[1]);
                Set sa = new Set();
                sa = s.headSet(toElement);
                System.out.println(sa);
            	} catch (Exception e) {
            		System.out.println(e.getMessage());
            	}
                break;
            case "last":
            	try {
                System.out.println(s.last());
            	} catch (Exception e) {
            		System.out.println(e.getMessage());
            	}
                break;
            default:
                break;
            }
        }
    }
}

