package program;

import interfaces.Runnable;
import program.data.QuizData;
import program.models.Quiz;

import java.util.Scanner;

import static program.utils.Utils.print;
import static program.utils.Utils.println;


final public class Program implements Runnable {
    static Quiz[] allQuiz = null;

    // this obj is for user input
    static Scanner scanner = null;

    static int correctAnswer = 0;


    @Override
    public void run() {

        // make sure necessary things are properly initialize
        var initFailMsg = "Program is not initialized yet! Please Run 'app.init()' before using the the Program";
        assert scanner != null : initFailMsg;
        assert allQuiz != null : initFailMsg;

        _run();

        displayResult();
    }

    @Override
    public void dispose() {
        scanner.close();
    }

    @Override
    public void init() {
        // init all the quiz from the QuizData record
        if (allQuiz == null) allQuiz = new QuizData().quizList().toArray(Quiz[]::new);
        // initialize necessary obj for getting user input
        scanner = new Scanner(System.in);
    }

    void _run() {
        // iter through all the quiz
        for (int qNo = 0; qNo < allQuiz.length; qNo++) {
            var quiz = allQuiz[qNo]; // the quiz
            char answer = QuizData.convertIndexToChar(quiz.answer); // the quiz answer
            display(quiz, qNo + 1); // show to user
            char input = getUserInput(); // get the user input with validation

            if (input == answer) correctAnswer += 1; // track correct answer
        }
    }

    void displayResult() {
        // calculate the ratio
        double result = (correctAnswer / (double) allQuiz.length) * 100;
        println("");
        println("|=====================================|");
        if (result == 100) {
            println("\tCongrats!"); // shows only when result = 100%
            print("\t");
        }
        println("\tYour score is " + result + "%");
        if (result != 100) println("\tBetter luck next time."); // shows only when result < 100
        println("|=====================================|");
    }

    char getUserInput() {
        Character ch = null;
        while (ch == null) {
            print("Enter correct answer [A|B|C|D]:> ");
            // lowercase the input for easier validation
            char input = Character.toLowerCase(scanner.next().charAt(0));

            switch (input) {
                // in case of valid input initialize `ch` variable to return with
                case 'a', 'b', 'c', 'd' -> {
                    ch = input;
                }
                default ->
                        println("'" + input + "' : " + "Invalid choice! please input one of the option from A,B,C or D.");
            }
        }
        return ch;
    }


    void display(Quiz quiz, int qNo) {
        QuizData.displayQuiz(quiz, qNo);
    }

}
