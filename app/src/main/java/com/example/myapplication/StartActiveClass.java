package com.example.myapplication;

import android.content.Intent;
import android.view.View;

public class StartActiveClass implements View.OnClickListener {
    private MainActivity activity;
    public StartActiveClass(MainActivity acti)
    {
        this.activity=acti;
    }
    @Override

    public void onClick(View v)
    {

        Intent go=new Intent(this.activity, Quiz_Start.class);
        activity.startActivity(go);
    }

    }

