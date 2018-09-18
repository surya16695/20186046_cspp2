import java.util.Scanner;
/**
 * Class for question.
 */
final class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
        this.questiontext = question1;
        this.choices = choices1;
        this.correctAnswer = correctAnswer1;
        this.maxMarks = maxMarks1;
        this.penalty = penalty1;
    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    // public boolean evaluateResponse(final String choice) {
    //     String[] c = choice.split(" ");
    //     if (this.correctAnswer.equals(c[1])) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        this.response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**.
     * { var_description }
     */
    private List<Question> question;
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    // private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        question = new List<Question>();
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        question.add(q);
        size += 1;
    }
    /**.
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The quarter
     *
     * @throws     Exception  { exception_description }
     */
    public void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) throws Exception {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        int qc = q;
        if (qc == 0) {
            throw new Exception("Quiz does not have questions");
        }
        final int num = 3, num1 = 4, num2 = 5;
        while (qc > 0) {
            String line = scan.nextLine();
            String[] array = line.split(":");
            if (array.length == num2 && array[0].length() != 0
             && array[1].length() != 0 && array[2].length() != 0
              && array[num].length() != 0 && array[num1].length() != 0) {
                String[] answers = array[1].split(",");
                if (answers.length >= 2) {
                    if (Integer.parseInt(array[2]) >= 1
                        && Integer.parseInt(array[2])
                        <= answers.length) {
                        if (Integer.parseInt(array[num]) > 0) {
                            if (Integer.parseInt(array[num1]) <= 0) {
                                quiz.addQuestion(new
                                    Question(array[0], answers,
                                     Integer.parseInt(array[2]),
                                     Integer.parseInt(array[num]),
                                    Integer.parseInt(array[num1])));
                            } else {
                                throw new Exception(
                                    "Invalid penalty for " + array[0]);
                            }
                        } else {
                            throw new Exception(
                                "Invalid max marks for " + array[0]);
                        }
                    } else {
                        throw new Exception("Error! Correct answer "
                            + "choice number is out of"
                            + " range for " + array[0]);
                    }
                } else {
                    throw new Exception(array[0] + " does not have"
                        + " enough answer choices");
                }
            } else {
                throw new Exception("Error! Malformed question");
            }
            qc--;
        }
        System.out.println(q + " are added to the quiz");
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        for (int i = 0; i < question.size(); i++) {
            System.out.println(question.get(i).getQuestionText()
             + "(" + question.get(i).getMaxMarks() + ")");
            int j = 0;
            String[] c = question.get(i).getChoice();
            for (j = 0; j < c.length - 1; j++) {
                System.out.print(c[j] + "\t");
            }
            System.out.println(c[c.length - 1]);
            System.out.println();
            String line = scan.nextLine();
            question.get(i).setResponse(line);
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        int total = 0;
        if (question.size() > 0) {
            for (int i = 0; i < question.size(); i++) {
                System.out.println(question.get(i).getQuestionText());
                String[] choic = question.get(i).getChoice();
                if (question.get(i).getResponse().equals(
                    choic[question.get(i).getCorrectAnswer() - 1])) {
                    System.out.println(" Correct Answer! - Marks Awarded: "
                     + question.get(i).getMaxMarks());
                    total += question.get(i).getMaxMarks();
                } else {
                    System.out.println(" Wrong Answer! - Penalty: "
                     + question.get(i).getPenalty());
                    total += question.get(i).getPenalty();
                }
            }
            System.out.println("Total Score: " + total);
        }
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    // public Question getQuestion(final int index) {
    //     return question[index];
    // }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        return s;
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
                try {
                    System.out.println("|----------------|");
                    System.out.println("| Load Questions |");
                    System.out.println("|----------------|");
                    q.loadQuestions(s, q, Integer.parseInt(tokens[1]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                q.startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                q.displayScore(q);
                break;
                default:
                break;
            }
        }
    }
}



