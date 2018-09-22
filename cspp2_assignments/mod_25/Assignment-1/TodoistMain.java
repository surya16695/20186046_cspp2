import java.util.Scanner;
import java.util.Arrays;

class Todoist {
    private List<Task> t;
    Todoist(){
        t = new List<Task>();

    }
    public void addTask (Task task) {
        t.add(task);
    }
    public void getNextTask(String taskname) {
        int j = 0;
        for (int i = 0; i < t.size(); i++) {
            Task ta = t.get(i);
            if (ta.getassignedTo().equals(taskname)) {
                if (ta.getimportant().equals("Important") &&
                ta.getimportant().equals("Urgent") && ta.getstatus().equals("todo") ) {
                    // Task tas = new Task(ta.getTitle(), ta.getassignedTo(), ta.gettimeToComplete(),
                    //  ta.getimportant(), ta.geturgent(), ta.getstatus());
                    j = 1;
                    ta.toString();
                }
            }
        }
        if (j != 1) {
            System.out.println("null");
        }
    }

    public int totalTime4Completion() {
        int sum = 0;
        for (int i = 0; i < t.size(); i++) {
            Task tas = t.get(i);
            if (tas.getstatus().equals("todo")) {
                sum += tas.gettimeToComplete();
            }
        }

        return sum;
    }
    public String toString() {
        String a = "";
        for (int i = 0; i < t.size(); i++) {
            a += t.get(i)+"\n";   
        }
        return a;
    }

}
class Task {
    private String title;
    private String assignedTo;
    private int timeToComplete;
    private String important;
    private String urgent;
    private String status;
    Task() {

    }
    Task(String tit, String assigned, int time,
        String imp, String urge, String stat) {
        this.title = tit;
        this.assignedTo = assigned;
        this.timeToComplete = time;
        this.important = imp;
        this.urgent = urge;
        this.status = stat;

    }
    public String toString() {
        String s = "";
        s += title+", "+assignedTo+", "+timeToComplete;
        s += ", "+important+", "+urgent+", "+status;
        return s;       
    }
    public String getTitle() {
        return this.title;
    }    
    public String getassignedTo() {
        return this.assignedTo;
    }    
    public String getimportant() {
        return this.important;
    }    
    public String geturgent() {
        return this.urgent;
    }    
    public int gettimeToComplete() {
        return this.timeToComplete;
    }    
    public String getstatus() {
        return this.status;
    }
}
/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    todo.getNextTask(tokens[1]);
                break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[3]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        if (tokens[1].length() == 0) {
            throw new Exception("Title not provided");
        }
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        if (Integer.parseInt(tokens[3]) < 0) {
            throw new Exception("Invalid timeToComplete "+tokens[3]);
        }
        boolean important = tokens[4].equals("y");
        String impty = "";
        String urgen = "";
        if ( important) {
            impty = "Important";
        }else {
            impty = "Not Important";
        }  
        boolean urgent = tokens[5].equals("y");
        if ( urgent ) {
            urgen = "Urgent";
        }else {
            urgen = "Not Urgent";
        }
        if (tokens[6].equals("todo") || tokens[6].equals("done")) {
            String status = tokens[6];
        }else {
            throw new Exception("Invalid status "+tokens[6]);
        }
        return new Task(
            title, assignedTo, timeToComplete, impty, urgen, tokens[6]);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
