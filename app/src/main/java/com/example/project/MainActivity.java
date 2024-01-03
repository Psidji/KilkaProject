package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    public String asd;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(System.getProperty("user.dir"));
        button = findViewById(R.id.button3);
        button.setText(System.getProperty("user.dir"));
    }

    public void toLobby(View v){
        Intent intent = new Intent(this, LobbyActivity.class);
        startActivities(new Intent[]{intent});

    }
}