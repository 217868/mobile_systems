package com.example.univeristyligthhousekeeper;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Quiz quiz = new Quiz("firstquiz.txt", getAssets());
        String nowyquiz;
        nowyquiz = quiz.calcualtePoints();
        Quiz drugiquiz = new Quiz(nowyquiz,getAssets());

        }
    }

