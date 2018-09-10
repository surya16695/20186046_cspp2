import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Surya.
 */
class SortedSet {
    // your code goes here... Good luck :-) Thanks.
    /**
     * set array.
     */
    private int[] set;
    /**
     * size variable.
     */
    private int size;

    /**
     * Constructs the object.
     */
    SortedSet() {
        set = new int[2];
        size = 0;
        sort();
    }
    /**
     * return number of elements in Set.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }

    /**
     * returns true if element is in Set.
     * otherwise false.
     *
     * @param      element  The element
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int element) {
        for (int setElement : set) {
            if (setElement == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        StringBuffer sb = new StringBuffer("{");
        int i;
        for (i = 0; i < size - 1; i++) {
            sb.append(set[i] + ", ");
        }
        sb.append(set[i]);
        sb.append("}");
        return sb.toString();
    }

    /**
     * adds element to the end of the Set.
     *
     * @param      element  The element
     */
    public void add(final int element) {
        if (size == set.length) {
            resize();
        }
        if (!contains(element)) {
            set[size++] = element;
        }
    }

    /**
     * resizes the Set object with double size.
     */
    private void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     */
    public void sort() {
        Arrays.sort(set);

    }
    /**
     * add all elements to Set
     * in the given array.
     *
     * @param      elements  The elements
     */
    public void add(final int[] elements) {
        sort();
        for (int element : elements) {
            add(element);
        }
    }

    /**
     * return element at given index.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    private int get(final int index) {
        return set[index];
    }

    /**
     * return common elements in both Sets.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public SortedSet intersection(final SortedSet that) {
        if (that.size() == 0 || this.size() == 0) {
            return new SortedSet();
        }
        SortedSet newSet = new SortedSet();
        for (int i = 0; i < this.size(); i++) {
            if (that.contains(this.set[i])) {
                newSet.add(this.set[i]);
            }
        }
        return newSet;
    }

    /**
     * return Set object with element in the given argument
     * elements.
     *
     * @param      elements  The elements
     *
     * @return     { description_of_the_return_value }
     */
    public SortedSet retainAll(final int[] elements) {
        SortedSet newSet = new SortedSet();
        newSet.add(elements);
        return this.intersection(newSet);
    }

    /**
     * return 2d array of cartesian product.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int[][] cartesianProduct(final SortedSet that) {
        if (that.size() == 0 || this.size() == 0) {
          return null;
        }
        int[][] cartesianProduct = new int[this.size() * that.size()][2];
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < that.size(); j++) {
                cartesianProduct[count][0] = this.get(i);
                cartesianProduct[count++][1] = that.get(j);
            }
        }
        return cartesianProduct;
    }
    /**
     * subSet.
     *
     * @param      start  The start
     * @param      end    The end
     *
     * @return     { description_of_the_return_value }
     */
    public SortedSet subSet(final int start, final int end) {
        SortedSet l = new SortedSet();
        if (start <= 0 || end <= 0) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        }
        if (start > size || end > size) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        }
        if (start > end) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        } else {
            for (int i = start; i < end; i++) {
                    l.add(set[i]);
            }
            return l;
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
        SortedSet s = new SortedSet();
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
                case "addAll":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new SortedSet();
                SortedSet t = new SortedSet();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new SortedSet();
                t = new SortedSet();
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
