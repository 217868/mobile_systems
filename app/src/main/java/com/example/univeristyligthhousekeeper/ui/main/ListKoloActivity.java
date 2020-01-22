package com.example.univeristyligthhousekeeper.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.univeristyligthhousekeeper.DatabaseModel.DatabaseAccess;
import com.example.univeristyligthhousekeeper.DatabaseModel.KoloNaukowe;
import com.example.univeristyligthhousekeeper.LogoHelper;
import com.example.univeristyligthhousekeeper.MainActivityTabbed;
import com.example.univeristyligthhousekeeper.R;

import static android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD;

public class ListKoloActivity extends AppCompatActivity {
    DatabaseAccess databaseAccess;
    TextView nameTextView;
    TextView descriptionTextView;
    ImageView koloLogoImageView;
    KoloNaukowe koloNaukowe;
    Button backButton2;

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_result);

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());


        databaseAccess.open();
        koloNaukowe = databaseAccess.getKoloNaukowe(getIntent().getIntExtra("SELECTED_ID", 0));
        databaseAccess.close();

        nameTextView = findViewById(R.id.nameTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        descriptionTextView.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
       koloLogoImageView = findViewById(R.id.wydzialLogoImageView);
        backButton2 = findViewById(R.id.backButton2);

       koloLogoImageView.setImageResource(LogoHelper.getKoloLogo(koloNaukowe.getId()));

        nameTextView.setText(koloNaukowe.getKoloNaukowe());
        descriptionTextView.setText(koloNaukowe.getOpisKolaNaukowego());

        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListKoloActivity.this, MainActivityTabbed.class);
                ListKoloActivity.this.startActivity(intent);
            }
        });
    }

}
