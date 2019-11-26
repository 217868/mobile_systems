package com.example.univeristyligthhousekeeper;

public class Answers {
    private int [][] answers;

    public Answers(int[][] arr) {
        answers = arr;
    }

    int getAnswer(int view, int type) {

        return answers[view][type];
    }
}
