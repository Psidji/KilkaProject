package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class QuizActivity extends AppCompatActivity {

    private TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        File file = new File("/");
        System.out.println(123 + Arrays.toString(file.listFiles()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        question = findViewById(R.id.question);
        quiz();
    }


    private void quiz(){
        InputStream inputStream = getResources().openRawResource(R.raw.quiz_questions);
        try (Scanner sc = new Scanner(inputStream)) {
            while (sc.hasNext()) {
                String[] message = sc.nextLine().split(":");
                String key = message[0], body = message[1];

                System.out.println(key + " " + body);
                question.setText(key + " " + body);
            }
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}