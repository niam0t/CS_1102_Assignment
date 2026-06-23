package program.data;

import program.models.Quiz;

import java.util.List;
import java.util.Map;

import static program.utils.Utils.print;
import static program.utils.Utils.println;

public record QuizData(List<Quiz> quizList) {

    public QuizData() {
        // all the Quiz with answers and options
        this(List.of(
                new Quiz(
                        "How much is (2 + 2 = ?) :",
                        Map.of(1, "4",
                                2, "3",
                                3, "2",
                                4, "22"
                        ),
                        1
                ),

                new Quiz(
                        "What color is the Banana? :",
                        Map.of(1, "Green",
                                2, "Yellow",
                                3, "Red",
                                4, "Transparent"
                        ),
                        2
                ),

                new Quiz(
                        "What color do I like? (Select the most appropriate answer) :",
                        Map.of(1, "Blue",
                                2, "Green",
                                3, "Red",
                                4, "We dont know!"
                        ),
                        4
                ),

                new Quiz(
                        "What it capital of Dhaka? (Select the correct answer) :",
                        Map.of(1, "Bangladesh",
                                2, "Asia",
                                3, "Russia",
                                4, "Dhaka is not a country"
                        ),
                        4
                ),

                new Quiz(
                        "What is ( 1 + 2 = ? ) ?",
                        Map.of(1, "1.2",
                                2, "1",
                                3, "12",
                                4, "3"
                        ),
                        4
                )
        ));
    }

    static void displayQuestion(String question, int qNo) {
        // show question no
        print("# Question " + qNo + ":\n");

        // show question
        print("\t" + question + "\n");
    }


    public static void displayQuiz(Quiz quiz, int qNo) {
        // displays the question
        // TODO: refactor to a view model
        println("=====================================");
        displayQuestion(quiz.text, qNo);
        displayOptions(quiz.options);
        println("=====================================");
    }

    static void displayOptions(Map<Integer, String> options) {
        var keys = options.keySet().stream().sorted().mapToInt(Integer::intValue).toArray();
        for (var key : keys) {
            char qLabel = Character.toUpperCase(convertIndexToChar(key));
            println("\t\t" + qLabel + ") " + options.get(key));
        }
    }

    public static char convertIndexToChar(int index) {
        return switch (index) {
            case 1 -> 'a';
            case 2 -> 'b';
            case 3 -> 'c';
            case 4 -> 'd';
            default -> '!';
        };
    }
}



