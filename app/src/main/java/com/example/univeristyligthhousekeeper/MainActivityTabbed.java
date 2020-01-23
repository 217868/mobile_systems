package com.example.univeristyligthhousekeeper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.univeristyligthhousekeeper.DatabaseModel.DatabaseAccess;
import com.example.univeristyligthhousekeeper.DatabaseModel.JednostkaNadrzednaKN;
import com.example.univeristyligthhousekeeper.DatabaseModel.Kierunek;
import com.example.univeristyligthhousekeeper.DatabaseModel.KoloNaukowe;
import com.example.univeristyligthhousekeeper.DatabaseModel.Wydzial;
import com.example.univeristyligthhousekeeper.ui.main.KierunkiFragment;
import com.example.univeristyligthhousekeeper.ui.main.KolaFragment;
import com.example.univeristyligthhousekeeper.ui.main.ListKoloActivity;
import com.example.univeristyligthhousekeeper.ui.main.ListResultActivity;
import com.example.univeristyligthhousekeeper.ui.main.UczelniaFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.example.univeristyligthhousekeeper.ui.main.SectionsPagerAdapter;

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

        viewPager.setCurrentItem(1);

        goToPollButton = findViewById(R.id.goToPollButton);
        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());

        goToPollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivityTabbed.this, PollActivity.class);
                MainActivityTabbed.this.startActivity(intent);
            }
        });

    }

    @Override
    public void onListFragmentInteraction(Kierunek item) {
        Intent intent = new Intent(this, ListResultActivity.class);
        intent.putExtra("SELECTED_ID", item.getId());
        this.startActivity(intent);
    }

    @Override
    public void onListFragmentInteraction(Wydzial item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(KoloNaukowe item) {
        Intent intent = new Intent(this, ListKoloActivity.class);
        intent.putExtra("SELECTED_ID", item.getId());
        this.startActivity(intent);
    }

    @Override
    public void onListFragmentInteraction(JednostkaNadrzednaKN item) {

    }

}