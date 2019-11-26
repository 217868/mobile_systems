package com.example.univeristyligthhousekeeper;

public class Question {
    private String content;
    private Answers answers;

    public Question(String content, Answers answers) {
        this.content = content;
        this.answers = answers;
    }

    public String getContent() {
        return content;
    }

    Answers getAnswers() {
        return answers;
    }
}
