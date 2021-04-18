package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class lose extends AppCompatActivity implements View.OnClickListener {
VideoView vv1;
ImageView iv4;
String uripath;
Uri uri;
String res;
int IdVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        iv4=findViewById(R.id.iv4);
        iv4.setOnClickListener(this);
        vv1=findViewById(R.id.vv1);
        IdVideo= R.raw.losevideo;
        vv1.setVisibility(View.VISIBLE);
        uripath="android.resource://"+ getPackageName()+"/"+IdVideo;
        uri=Uri.parse(uripath);
        vv1.setVideoURI(uri);
        vv1.start();


    }

    @Override
    public void onClick(View v) {
        super.onBackPressed();
    }
}