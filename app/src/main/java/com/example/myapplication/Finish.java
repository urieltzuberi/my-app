package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Finish extends AppCompatActivity {
    Intent goHome, Takeit;
    TextView tvPoint, tvMistakes, tvThanks,tv_your_mistakes;
    Button btReturnHome;
    SharedPreferences sp;
    String[] value1;
    int x = 0, mis,res;
    String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        tvPoint = findViewById(R.id.tvPoint);
        tvMistakes = findViewById(R.id.tvMistakes);
        tvThanks = findViewById(R.id.tvThanks);
        tv_your_mistakes = findViewById(R.id.tv_your_mistakes);
        btReturnHome = findViewById(R.id.btReturnHome);

         Takeit = getIntent();
         res = Takeit.getIntExtra("Point", 0);
         tvPoint.setText("Total Point:" + res);
        tvMistakes.setText(Save_Load_Error.load_error(this));


    }

    public void ReturnHome(View view) {
        goHome = new Intent(this, MainActivity.class);
        startActivity(goHome);
    }
}