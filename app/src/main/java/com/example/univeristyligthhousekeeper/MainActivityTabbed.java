package com.example.univeristyligthhousekeeper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.univeristyligthhousekeeper.ui.main.KierunkiFragment;
import com.example.univeristyligthhousekeeper.ui.main.KolaFragment;
import com.example.univeristyligthhousekeeper.ui.main.UczelniaFragment;
import com.example.univeristyligthhousekeeper.ui.main.dummy.DummyContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.univeristyligthhousekeeper.ui.main.SectionsPagerAdapter;

public class MainActivityTabbed extends AppCompatActivity implements KolaFragment.OnListFragmentInteractionListener, KierunkiFragment.OnListFragmentInteractionListener, UczelniaFragment.OnFragmentInteractionListener {

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

        goToPollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityTabbed.this, PollActivity.class);
                MainActivityTabbed.this.startActivity(intent);
            }
        });

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}