package com.example.univeristyligthhousekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.univeristyligthhousekeeper.ui.main.QuizResultActivity;

public class PollActivity extends AppCompatActivity {

    LinearLayout questionsListLayout;
    Button nextButton;
    Quiz quiz;
    boolean isSecondQuiz = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        quiz = new Quiz("firstquiz.txt", getAssets());
        isSecondQuiz = getIntent().getBooleanExtra("IS_SECOND", false);

        if (!isSecondQuiz)
            quiz = new Quiz("firstquiz.txt", getAssets());
        else {
            quiz = new Quiz(getIntent().getStringExtra("RESULT"), getAssets());
        }

        nextButton = findViewById(R.id.backButton2);

        if(isSecondQuiz) nextButton.setText("Wynik");

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSecondQuiz) {
                    runResult(quiz.calcualtePoints());
                }
                else {
                    runSecondQuiz(quiz.calcualtePoints());
                }
            }
        });


        questionsListLayout = findViewById(R.id.questionsListLayout);
        for (int i = 0; i < quiz.GetQuestionList().size(); i++) {
            final int x = i;
            View view = getLayoutInflater().inflate(R.layout.question, null);

            TextView questionName = view.findViewById(R.id.questionNameTextView);
            View tick1 = view.findViewById(R.id.tick1);
            View tick2 = view.findViewById(R.id.tick2);
            View tick3 = view.findViewById(R.id.tick3);
            View tick4 = view.findViewById(R.id.tick4);
            View tick5 = view.findViewById(R.id.tick5);

            ImageView tick1Full = tick1.findViewById(R.id.tickFull);
            ImageView tick2Full = tick2.findViewById(R.id.tickFull);
            ImageView tick3Full = tick3.findViewById(R.id.tickFull);
            ImageView tick4Full = tick4.findViewById(R.id.tickFull);
            ImageView tick5Full = tick5.findViewById(R.id.tickFull);

            final ImageView[] ticks = {tick1Full, tick2Full, tick3Full, tick4Full, tick5Full};

            tick1Full.setVisibility(View.GONE);
            tick2Full.setVisibility(View.GONE);
            tick3Full.setVisibility(View.GONE);
            tick4Full.setVisibility(View.GONE);
            tick5Full.setVisibility(View.GONE);

            tick1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pickAnswer(x, ticks, 1);
                }
            });

            tick2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pickAnswer(x, ticks, 2);
                }
            });

            tick3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pickAnswer(x, ticks, 3);
                }
            });

            tick4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pickAnswer(x, ticks, 4);
                }
            });

            tick5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pickAnswer(x, ticks, 5);
                }
            });


            questionName.setText((x + 1) + ". " + quiz.GetQuestion(x).getContent());

            questionsListLayout.addView(view);
        }
    }

    void pickAnswer(int questionNumber, ImageView[] views, int answerNumber) {
        for(ImageView iv : views) {
            iv.setVisibility(View.GONE);
        }
        views[answerNumber - 1].setVisibility(View.VISIBLE);
        quiz.SetUserAnswer(questionNumber, answerNumber - 1);
        Log.wtf("Question: ", quiz.GetQuestion(questionNumber).getContent() + " | Answer: " + answerNumber);
    }

    void runResult(String result) {
        Intent intent = new Intent(this, QuizResultActivity.class);
        Log.wtf("RESULT: ", result);
        intent.putExtra("RESULT", result);
        this.startActivity(intent);
    }

    void runSecondQuiz(String quizName) {
        Intent intent = new Intent(this, PollActivity.class);
        Log.wtf("RESULT: ", quizName);
        intent.putExtra("RESULT", quizName);
        intent.putExtra("IS_SECOND", true);
        this.startActivity(intent);
    }
}
