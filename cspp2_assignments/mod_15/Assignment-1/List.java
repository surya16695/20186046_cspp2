import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * List ADT.
 */
public class List {

  /**
   * list object.
   */
  private int[] list;
  /**
   * size of the list.
   */
  private int size;
  /**
   * Constructs the object.
   */
  public List() {
    final int max = 10;
    list = new int[max];
    size = 0;
  }
  /**
   * Constructs the object.
   *
   * @param      capacity  The capacity
   */
  public List(final int capacity) {
    list = new int[capacity];
    size = 0;
  }
  /**
  * Add an element to the list.
  *
  * @param      item  The item
  */
  public void add(final int item) {
    //Inserts the specified element at the end of the list.
    if (list.length == size) {
      list = resize();
    }
    list[size++] = item;

  }

  /**
   * resizes the array.
   *
   * @return     int array.
   */
  public int[] resize() {
    return Arrays.copyOf(list, 2 * list.length);
  }
  /**
   * To determine the size of the given array.
   *
   * @return     int: size.
   */
  public int size() {
    // replace the code below to implement the size method
    return size;
  }
  /**.
   * { function_description }
   *
   * @param      index  The index
   * @param      item   The item
   */
  public void add(final int index, final int item) {
    /**.
     * { item_description }
     */
    for (int i = size; i > index; i--) {
      list[i] = list[i - 1];
    }
    list[index] = item;
    size++;

  }
  /**.
   * { function_description }
   *
   * @param      index      The index
   *
   * @throws     Exception  { exception_description }
   */
  public void remove(final int index) throws Exception {
    if (index < 0 || index >= size) {
      throw new Exception();
    }
    if (index >= 0 && index < size) {
      for (int i = index; i < size - 1; i++) {
        list[i] = list[i + 1];
      }
      size--;
    } else {
      System.out.println("Invalid Position Exception");
    }
  }
  /**
   * getter method to access an element at an index.
   *
   * @param      index  The index
   *
   * @return     int value in the list, -1 if its not there.
   */
  public int get(final int index) {
    // Replace the code below to write the code for get
    if (index < 0 || index >= size) {
      return -1;
    } else {
      return list[index];
    }
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    // Replace the code below
    if (size == 0) {
      return "[]";
    }
    String str = "[";
    int i = 0;
    for (i = 0; i < size - 1; i++) {
      str = str + list[i] + ",";
    }
    str = str + list[i] + "]";
    return str;
  }
  /**
   * checks if a given element is present in the list.
   *
   * @param      item  The item
   *
   * @return     True or False.
   */
  public boolean contains(final int item) {
    return indexOf(item) != -1;
  }
  /**
   * Searches for the first match.
   *
   * @param      item  The item
   *
   * @return     element in the given index.
   */
  public int indexOf(final int item) {
    // Replace the code below
    for (int i = 0; i < size; i++) {
      if (item == list[i]) {
        return i;
      }
    }
    return -1;
  }
  /**
   * Adds all.
   *
   * @param      newArray  The new array
   */
  public void addAll(final int[] newArray) {
    // write the logic
    for (int i = 0; i < newArray.length; i++) {
      add(newArray[i]);
    }
  }

  /**
   * calculates frequency of an element in the list.
   *
   * @param      item  The item
   *
   * @return     count, integer.
   */
  public int count(final int item) {
    // write the logic
    int c = 0;
    for (int i = 0; i < size; i++) {
      if (list[i] == item) {
        c++;
      }
    }
    return c;
  }
  /**.
   * Removes all.
   *
   * @param      newArray   The new array
   *
   * @throws     Exception  { exception_description }
   */
  public void removeAll(final int[] newArray) throws Exception {
    // write the logic
    for (int i = 0; i < newArray.length; i++) {
      for (int j = 0; j <= count(newArray[i]); j++) {
        if (contains(newArray[i])) {
          remove(indexOf(newArray[i]));
        }
      }
    }
  }
  /**.
   * { function_description }
   *
   * @param      start      The start
   * @param      end        The end
   *
   * @return     { description_of_the_return_value }
   *
   * @throws     Exception  { exception_description }
   */
  public List subList(final int start, final int end) throws Exception {
    if (start > size || end > size) {
      throw new Exception();
    }
    if (start < 0 || end < 0) {
      throw new Exception();
    }
    if (start > end) {
      throw new Exception();
    }
    if (start == end) {
      throw new Exception();
    }
    List subList = new List(end - start);
    for (int i = start; i < end; i++) {
      subList.add(this.get(i));
    }
    return subList;
  }
  /**
   * compares 2 lists.
   *
   * @param      compList  The component list
   *
   * @return     true or false.
   */
  public boolean equals(final List compList) {
    // Replace the code below
    if (size != compList.size()) {
      return false;
    } else {
      for (int i = 0; i < size; i++) {
        if (list[i] != compList.get(i)) {
          return false;
        }
      }
    }
    return true;
  }
  /*
  * Removes all the elements from list
  * Think about this case and make the method
  * the simpler.
  */
  /**
   * clears the list.
   */
  public void clear() {
    // write the logic for clear.
    for (int i = 0; i < size; i++) {
      list[i] = 0;
    }
    size = 0;
  }
  /**
   * main function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    // create an object of the list to invoke methods on it
    List l = new List();

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
      case "add":
        if (tokens.length == 2) {
          String[] t = tokens[1].split(",");
          if (t.length == 1) {
            l.add(Integer.parseInt(tokens[1]));
          }
        }
        break;
      case "size":
        System.out.println(l.size());
        break;
      case "print":
        System.out.println(l);
        break;
      case "remove":
        try {
          if (tokens.length == 2) {
            l.remove(Integer.parseInt(tokens[1]));
          }
        } catch (Exception e) {
          System.out.println("Invalid Position Exception");
        }
        break;
      case "indexOf":
        if (tokens.length == 2) {
          System.out.println(l.indexOf(
                               Integer.parseInt(tokens[1])));
        }
        break;
      case "get":
        if (tokens.length == 2) {
          System.out.println(l.get(
                               Integer.parseInt(tokens[1])));
        }
        break;
      case "contains":
        if (tokens.length == 2) {
          System.out.println(l.contains(
                               Integer.parseInt(tokens[1])));
        }
        break;
      case "addAll":
        if (tokens.length == 2) {
          String[] t1 = tokens[1].split(",");
          int[] temp = new int[t1.length];
          for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.parseInt(t1[i]);
          }
          l.addAll(temp);
        }
        break;
      case "removeAll":
        try {
          if (tokens.length == 2) {
            String[] t2 = tokens[1].split(",");
            int[] a = new int[t2.length];
            for (int i = 0; i < t2.length; i++) {
              a[i] = Integer.parseInt(t2[i]);
            }
            l.removeAll(a);
          }
        } catch (Exception r) {
          System.out.println("Invalid Position Exception");
        }
        break;
      case "subList":
        try {
          if (tokens.length != 2) {
            break;
          }
          String[] arrstring3 = tokens[1].split(",");
          List object = l.subList(Integer.parseInt(arrstring3[0]),
                                  Integer.parseInt(arrstring3[1]));
          if (object != null) {
            System.out.println(object);
          }
        } catch (Exception s) {
          System.out.println("Index Out of Bounds Exception");
        }
        break;
      case "equals":
        if (tokens.length == 2) {
          String[] lt = tokens[1].split(",");
          List l2 = new List();
          for (int k = 0; k < lt.length; k++) {
            l2.add(Integer.parseInt(lt[k]));
          }
          System.out.println(l.equals(l2));
        }
        break;
      case "clear":
        l.clear();
        break;
      case "count":
        System.out.println(l.count(Integer.parseInt(tokens[1])));
      default:
        break;
      }
    }
  }
}

