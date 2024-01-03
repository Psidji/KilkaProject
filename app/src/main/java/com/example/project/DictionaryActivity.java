package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DictionaryActivity extends AppCompatActivity {

    private TextView words;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        words = findViewById(R.id.words);
        getWordsDictionary();
    }

    private void getWordsDictionary(){
        try {
            InputStream fileInput = getResources().openRawResource(R.raw.textnew);
            InputStreamReader streamReader = new InputStreamReader(fileInput);
            BufferedReader bR = new BufferedReader(streamReader);

            StringBuffer sB = new StringBuffer();
            String lines;
            while ((lines  = bR.readLine()) != null) {
                sB.append(lines).append("\n");
            }
            words.setText(sB);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}