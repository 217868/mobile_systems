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
import com.example.univeristyligthhousekeeper.LogoHelper;
import com.example.univeristyligthhousekeeper.MainActivityTabbed;
import com.example.univeristyligthhousekeeper.R;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class ListResultActivity extends AppCompatActivity {

    DatabaseAccess databaseAccess;
    TextView nameTextView;
    TextView descriptionTextView;
    ImageView wydzialLogoImageView;
    Kierunek kierunek;
    Button backButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_result);

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());


        databaseAccess.open();
        kierunek = databaseAccess.getKierunek(getIntent().getIntExtra("SELECTED_ID", 0));
        databaseAccess.close();

        nameTextView = findViewById(R.id.nameTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        descriptionTextView.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        wydzialLogoImageView = findViewById(R.id.wydzialLogoImageView);
        backButton2 = findViewById(R.id.backButton2);

        wydzialLogoImageView.setImageResource(LogoHelper.getWydzialLogo(kierunek.getWydzialId()));

        nameTextView.setText(kierunek.getKierunek());
        descriptionTextView.setText(kierunek.getOpisKierunku());

        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListResultActivity.this, MainActivityTabbed.class);
                ListResultActivity.this.startActivity(intent);
            }
        });
    }


}
