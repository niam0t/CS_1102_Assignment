package program.models;

import java.util.Map;

public class Quiz {
    public String text;
    public Map<Integer, String> options;
    public int answer;

    public Quiz(String question, Map<Integer, String> options, int answer) {
        this.text = question;
        this.options = options;
        this.answer = answer;
    }
}
