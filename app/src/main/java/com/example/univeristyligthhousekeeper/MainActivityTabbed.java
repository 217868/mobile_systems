package com.example.univeristyligthhousekeeper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.univeristyligthhousekeeper.DatabaseModel.DatabaseAccess;
import com.example.univeristyligthhousekeeper.DatabaseModel.JednostkaNadrzednaKN;
import com.example.univeristyligthhousekeeper.DatabaseModel.Kierunek;
import com.example.univeristyligthhousekeeper.DatabaseModel.Wydzial;
import com.example.univeristyligthhousekeeper.ui.main.KierunkiFragment;
import com.example.univeristyligthhousekeeper.ui.main.KolaFragment;
import com.example.univeristyligthhousekeeper.ui.main.UczelniaFragment;
import com.example.univeristyligthhousekeeper.ui.main.dummy.DummyContent;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.univeristyligthhousekeeper.ui.main.SectionsPagerAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MainActivityTabbed extends AppCompatActivity implements KolaFragment.OnListFragmentInteractionListener, KierunkiFragment.OnListFragmentInteractionListener, UczelniaFragment.OnFragmentInteractionListener {

    DatabaseAccess databaseAccess;
    Button goToPollButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabbed);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        goToPollButton = findViewById(R.id.goToPollButton);
        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());

        goToPollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseAccess.open();
                List<Wydzial> wydzialy = databaseAccess.getWydzialy();
                List<Kierunek> kierunki = databaseAccess.getKierunki();
                for (Wydzial w : wydzialy) {
                    Log.d("My tag", w.getId() + ". " + w.getWydzial());
                }
                databaseAccess.close();

               for (Kierunek k : kierunki) {
                   Log.d("My tag", k.getId() + ". " + k.getWydzialId() + " " + k.getKierunek() + " " + k.getOpisKierunku());

               }
                Intent intent = new Intent(MainActivityTabbed.this, PollActivity.class);
                MainActivityTabbed.this.startActivity(intent);
            }
        });

    }

    @Override
    public void onListFragmentInteraction(Wydzial item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(JednostkaNadrzednaKN item) {

    }
}