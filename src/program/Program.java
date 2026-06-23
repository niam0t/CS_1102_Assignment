package program;

import interfaces.Runnable;
import program.data.QuizData;
import program.models.Quiz;

import java.util.Scanner;

import static program.utils.Utils.print;
import static program.utils.Utils.println;


final public class Program implements Runnable {
    static Quiz[] allQuiz = null;
    static Scanner scanner = null;
    static int correctAnswer = 0;


    @Override
    public void run() {
        init();

        var initFailMsg = "Program is not initialized yet! Please Run 'Program.init()' before using the the Program";
        assert scanner != null : initFailMsg;
        assert allQuiz != null : initFailMsg;

        _run();
        displayResult();

        dispose();

    }

    @Override
    public void dispose() {
        scanner.close();
    }

    @Override
    public void init() {
        if (allQuiz == null) allQuiz = new QuizData().quizList().toArray(Quiz[]::new);
        scanner = new Scanner(System.in);
    }

    void _run() {
        for (int qNo = 0; qNo < allQuiz.length; qNo++) {
            var quiz = allQuiz[qNo];
            char answer = QuizData.convertIndexToChar(quiz.answer);
            display(quiz, qNo + 1);
            char input = getUserInput();

            if (input == answer) correctAnswer += 1;
        }
    }

    void displayResult() {
        double result = (correctAnswer / (double) allQuiz.length) * 100;
        println("");
        println("|=====================================|");
        if (result == 100) {
            println("\tCongrats!");
            print("\t");
        }
        println("\tYour score is " + result + "%");
        if (result != 100) println("\tBetter luck next time.");
        println("|=====================================|");
    }

    char getUserInput() {
        Character ch = null;
        while (ch == null) {
            print("Enter correct answer [A|B|C|D]:> ");
            char input = Character.toLowerCase(scanner.next().charAt(0));
            switch (input) {
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
