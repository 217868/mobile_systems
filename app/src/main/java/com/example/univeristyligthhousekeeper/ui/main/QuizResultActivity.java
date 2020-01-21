package com.example.univeristyligthhousekeeper.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.univeristyligthhousekeeper.DatabaseModel.DatabaseAccess;
import com.example.univeristyligthhousekeeper.DatabaseModel.Kierunek;
import com.example.univeristyligthhousekeeper.DatabaseModel.Wydzial;
import com.example.univeristyligthhousekeeper.LogoHelper;
import com.example.univeristyligthhousekeeper.MainActivityTabbed;
import com.example.univeristyligthhousekeeper.R;

import java.util.List;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class QuizResultActivity extends AppCompatActivity {

    TextView resultKierunekTextView;
    TextView resultWydzialTextView;
    DatabaseAccess databaseAccess;
    List<Kierunek> kierunki;
    Kierunek selectedKierunek;
    Wydzial selectedWydzial;
    String resultString;
    TextView kierunekDescriptionTextView;
    Button backButton;
    ImageView wydzialLogoImageView2;

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

        databaseAccess.open();
        selectedWydzial = databaseAccess.getWydzial(selectedKierunek.getWydzialId());
        databaseAccess.close();

        resultKierunekTextView = findViewById(R.id.resultKierunekTextView);
        resultWydzialTextView = findViewById(R.id.resultWydzialTextView);
        kierunekDescriptionTextView = findViewById(R.id.kierunekDescriptionTextView);
        wydzialLogoImageView2 = findViewById(R.id.wydzialLogoImageView2);
        backButton = findViewById(R.id.backButton2);
        if (selectedKierunek != null) {
            kierunekDescriptionTextView.setText(selectedKierunek.getOpisKierunku());
            kierunekDescriptionTextView.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
            resultKierunekTextView.setText(selectedKierunek.getKierunek());
            resultWydzialTextView.setText(selectedWydzial.getWydzial());
            wydzialLogoImageView2.setImageResource(LogoHelper.getWydzialLogo(selectedKierunek.getWydzialId()));
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizResultActivity.this, MainActivityTabbed.class);
                QuizResultActivity.this.startActivity(intent);
            }
        });

    }
}
