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
                loadQuestions(s, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, Integer.parseInt(tokens[1]));
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
    public static String[] quText = new String[10];
    public static String[] qChoice = new String[10];
    public static String[] qiCorrect = new String[10];
    public static String[] qzMax = new String[10];
    public static String[] negative = new String[10];
    public static String[] quChoice = new String[10];
    public static String[] quResponse = new String[10];
    public static int size = 0;
    public static void loadQuestions(final Scanner s, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class.
        Quiz qui = new Quiz();
        for (int i = 0; i < questionCount; i++) {
            String line = s.nextLine();
            String[] tokens = line.split(":");
            if (tokens.length != 5) {
                System.out.println("Error! Malformed question");
            } else {
                System.out.println(questionCount+"are added to the quiz");
                quText[i] = (tokens[0]);
                qChoice[i] = tokens[1].replace(",","    ");
                qChoice[i].split(",");
                qiCorrect[i] = tokens[2];
                qzMax[i] = tokens[3];
                negative[i] = tokens[4];
                // System.out.println(qi[i]);
                size++;
            }
        }
    }
            

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        if (size == 0) {
            System.out.println("Quiz does not have questions");           
        } else {
            for (int i = 0; i < answerCount; i++) {
                System.out.println(quText[i]+"("+qzMax[i]+")");
                System.out.println(qChoice[i]);
                String line = s.nextLine();
                String[] tokens = line.split(" ");
                quChoice[i] = (tokens[0]);
                quResponse[i] = (tokens[1]);
            }
        }
    }
    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        int sum = 0;
        for (int i = 0; i < size; i++) {
            System.out.println(quText[i]);
            if (Integer.parseInt(quResponse[i]) != Integer.parseInt(qiCorrect[i])) {
                if (Integer.parseInt(qzMax[i]) < 0) {
                    System.out.println("Invalid max marks for"+quText[i]);
                } else {
                    System.out.println(" Correct Answer! - Marks Awarded:"+qzMax[i]);
                    sum = sum + (Integer.parseInt(qzMax[i]));
                }
            } else {
                if (Integer.parseInt(negative[i]) >= 0) {
                    System.out.println("Invalid penalty for"+quText[i]);
                }
                System.out.println("Wrong Answer! - Penalty:"+negative[i]);
                sum = sum + (Integer.parseInt(negative[i]));
            }
        }
        System.out.println("Total Score: "+sum);
    }
}
