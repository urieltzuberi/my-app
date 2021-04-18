package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class About_App extends AppCompatActivity implements View.OnClickListener {
ImageView ivAboutAppReturn;
TextView tvAboutApp,tvSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__app);
        ivAboutAppReturn=findViewById(R.id.ivAboutAppReturn);
        tvAboutApp=findViewById(R.id.tvAboutApp);
        tvSMS=findViewById(R.id.tvSMS);
        ivAboutAppReturn.setOnClickListener(this);
    }

    public void SMS(View view) {
        String messege ="";
        String PhoneNum="0546647494";
        Intent intent=new Intent();
        intent.setAction(intent.ACTION_VIEW);
        Uri data= Uri.parse("sms:"+PhoneNum);
        intent.setData(data);
        intent.putExtra("sms boudy",messege);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent returnHome = new Intent(this, MainActivity.class);
        startActivity(returnHome);
    }
}