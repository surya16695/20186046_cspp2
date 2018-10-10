import java.util.Scanner;
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
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s,
        final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount <= 0) {
            System.out.println("Quiz does not have questions");
            return;
        }
        for (int i = 0; i < questionCount; i++) {
            String line = s.nextLine();
            String[] tokens = line.split(":");
            try {
                if (tokens[0].equals("")) {
                    System.out.println("Error! Malformed question");
                    throw new Exception();
                }
                quiz.addQuestion(tokens[0]);
                final int seventeen = 17;
                if (tokens[1].length() < seventeen) {
                    System.out.println(tokens[0]
                     + " does not have enough answer choices");
                    return;
                }
                quiz.addChoices(tokens[1].replace(",", "\t"));
                final int four = 4;
                if (Integer.parseInt(tokens[2]) > four) {
System.out.println(
"Error! Correct answer choice number"
 + " is out of range for question text " + (i + 1));
                    return;
                }
                int index = Integer.parseInt(tokens[2]) - 1;
                String[] temporaryArray = tokens[1].split(",");
                quiz.addAnswer(temporaryArray[index]);
                final int three = 3;
                if (Integer.parseInt(tokens[three]) < 0) {
                    System.out.println("Invalid max marks for " + tokens[i]);
                    return;
                }
                quiz.addMaximumMarks(Integer.parseInt(tokens[three]));
                if (Integer.parseInt(tokens[four]) > 0) {
                    System.out.println("Invalid penalty for " + tokens[i]);
                    return;
                }
                quiz.addPenalty(Integer.parseInt(tokens[four]));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error! Malformed question");
                return;
            } catch (Exception e) {
                return;
            }
        }
        System.out.println(questionCount + " are added to the quiz");
    }
    /**
     * Starts a quiz.
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz,
     final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        quiz.displayQuizQuestions();
        for (int i = 0; i < answerCount; i++) {
            String line = s.nextLine();
            quiz.addUserAnswer(line);
        }
    }

    /**
     * Displays the score report.
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        quiz.displayScore();
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * questions list.
     */
    private List<String> questions = new List<String>();
    /**
     * answers list.
     */
    private List<String> answers = new List<String>();
    /**
     * maximum marks list.
     */
    private List<Integer> maxMarks = new List<Integer>();
    /**
     * penalty marks list.
     */
    private List<Integer> penaltyMarks = new List<Integer>();
    /**
     * choices list.
     */
    private List<String> choices = new List<String>();
    /**
     * input answers list.
     */
    private List<String> inputAnswers = new List<String>();
    /**
     * Adds a question.
     *
     * @param      question  The question
     */
    void addQuestion(final String question) {
        questions.add(question);
    }
    /**
     * Adds an answer.
     *
     * @param      answer  The answer
     */
    void addAnswer(final String answer) {
        answers.add(answer);
    }
    /**
     * Adds choices.
     *
     * @param      choice  The choice
     */
    void addChoices(final String choice) {
        choices.add(choice);
    }
    /**
     * Adds maximum marks.
     *
     * @param      maximumMarks  The maximum marks
     */
    void addMaximumMarks(final int maximumMarks) {
        maxMarks.add(maximumMarks);
    }
    /**
     * Adds a penalty.
     *
     * @param      penalty  The penalty
     */
    void addPenalty(final int penalty) {
        penaltyMarks.add(penalty);
    }
    /**
     * displays the quiz questions.
     */
    void displayQuizQuestions() {
        if (questions.size() != 0
         && answers.size() != 0
          && choices.size() != 0 && maxMarks.size() != 0
         && penaltyMarks.size() != 0) {
            for (int i = 0; i < questions.size(); i++) {
                System.out.println(questions.get(i)
                 + "(" + maxMarks.get(i) + ")");
                System.out.println(choices.get(i));
                System.out.println();
            }
        }
    }
    /**
     * Adds an user answer.
     *
     * @param      answer  The answer
     */
    void addUserAnswer(final String answer) {
        inputAnswers.add(answer);
    }
    /**
     * displays the score.
     */
    void displayScore() {
        if (questions.size() != 0 &&  answers.size()
         != 0 && choices.size() != 0 && maxMarks.size()
         != 0 && penaltyMarks.size() != 0) {
            int score = 0;
            for (int i = 0; i < answers.size(); i++) {
                System.out.println(questions.get(i));
                if (answers.get(i).equals(inputAnswers.get(i))) {
                    System.out.println(
            " Correct Answer! - Marks Awarded: " + maxMarks.get(i));
                    score += maxMarks.get(i);
                } else {
                    System.out.println(
            " Wrong Answer! - Penalty: " + penaltyMarks.get(i));
                    score += penaltyMarks.get(i);
                }
            }
            System.out.println("Total Score: " + score);
        }
    }

}


