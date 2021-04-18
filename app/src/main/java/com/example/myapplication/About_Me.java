package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class About_Me extends AppCompatActivity implements View.OnClickListener {
    Intent email;
    ImageView ivAboutMeReturn,ivMe;
    TextView tvAboutMe,tvEmail;
    Button btEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__me);
        tvEmail=findViewById(R.id.tvEmail);
        tvAboutMe=findViewById(R.id.tvAboutMe);
        ivMe=findViewById(R.id.ivMe);
        ivMe.setImageResource(R.drawable.me_pucture);
        ivMe.setVisibility(View.VISIBLE);
        btEmail=findViewById(R.id.btEmail);
        ivAboutMeReturn=findViewById(R.id.ivAboutMeReturn);
        ivAboutMeReturn.setOnClickListener(this);
    }


    public void Email(View view) {
        email=new Intent(Intent.ACTION_SEND);
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"urieltzuberi@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "About the app");
        email.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }

    @Override
    public void onClick(View v) {
        Intent go5= new Intent(this, MainActivity.class);
        startActivity(go5);

    }
}