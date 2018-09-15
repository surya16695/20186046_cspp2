import java.util.Scanner;
import java.util.Arrays;

class Quiz {
    private String [] quizs;
    private int size;
    public Quiz() {
        quizs = new String[10];
        size = 0;  
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
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }

    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static String[] qu = new String[10];
    public static String[] q = new String[10];
    public static String[] qi = new String[10];
    public static String[] qz = new String[10];
    public static int size = 0;
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class.
        Quiz qui = new Quiz();
        System.out.println(questionCount+"are added to the quiz");
        for (int i = 0; i < questionCount; i++) {
            String line = s.nextLine();
            String[] tokens = line.split(":");
            qu[i] = (tokens[0]);
            // quizs.add(qu[i]);
            q[i] = tokens[1].replace(",","    ");
            q[i].split(",");
            qz[i] = tokens[2];
            qi[i] = tokens[3];
            System.out.println(qi[i]);
            // qui.add(q[i]);
            size++;
            // System.out.println(qu[i]);
            // System.out.println(q[i]);
        }
    }
            

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        for (int i = 0; i < answerCount; i++) {
            System.out.println(qu[i]+"("+qi[i]+")");
            System.out.println(q[i]);
        }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }
}