package com.example.univeristyligthhousekeeper.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.univeristyligthhousekeeper.DatabaseModel.DatabaseAccess;
import com.example.univeristyligthhousekeeper.DatabaseModel.Kierunek;
import com.example.univeristyligthhousekeeper.R;

import java.util.List;

public class QuizResultActivity extends AppCompatActivity {

    TextView resultTextView;
    DatabaseAccess databaseAccess;
    List<Kierunek> kierunki;
    Kierunek selectedKierunek;
    String resultString;
    TextView kierunekDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        resultString = getIntent().getStringExtra("RESULT");

        databaseAccess.open();
        kierunki = databaseAccess.getKierunki();
        databaseAccess.close();
        for (Kierunek k: kierunki) {
            if (resultString.contains(k.getKierunek())) selectedKierunek = k;
        }

        resultTextView = findViewById(R.id.resultTextView);
        kierunekDescriptionTextView = findViewById(R.id.kierunekDescriptionTextView);
        if (selectedKierunek != null)
            kierunekDescriptionTextView.setText(selectedKierunek.getOpisKierunku());
        resultTextView.setText(resultString);
    }
}
