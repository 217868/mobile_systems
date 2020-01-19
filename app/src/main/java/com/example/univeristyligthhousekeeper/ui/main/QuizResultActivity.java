package com.example.univeristyligthhousekeeper.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.univeristyligthhousekeeper.R;

public class QuizResultActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        resultTextView = findViewById(R.id.resultTextView);

        resultTextView.setText(getIntent().getStringExtra("RESULT"));
    }
}
