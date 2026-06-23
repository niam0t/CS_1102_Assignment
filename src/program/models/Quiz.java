package program.models;

import java.util.Map;

public class Quiz {
    public String text;
    public Map<Integer, String> options;
    // TODO: refactor it to char
    public int answer;

    public Quiz(String question, Map<Integer, String> options, int answer) {
        this.text = question;
        this.options = options;
        this.answer = answer;
    }
}
