package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class Quiz_Start extends AppCompatActivity implements View.OnClickListener {
    ImageView iv2, iv3;
    TextView tv3, tv4,tv5;
    EditText et2;
    Button bt4 ,btyes,btno,bt5;
    Dialog d;
    int count=0, x = 0, mistake=0;
    MediaPlayer mp3;
    int[] AudioID1=new int[2];
    SharedPreferences sp;
    Intent goFinish;
    String Mistake;

    FinelQuiz[] arr=new FinelQuiz[10];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__start);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        et2 = findViewById(R.id.et2);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        btyes=findViewById(R.id.btyes);
        btno=findViewById(R.id.btno);



        arr[0]=new FinelQuiz(new Words( R.drawable.rsz_bed,R.raw.bed,"Bed"));
        arr[1]=new FinelQuiz(new Words( R.drawable.rsz_cat,R.raw.cat,"Cat"));
        arr[2]=new FinelQuiz(new Words( R.drawable.rsz_dad,R.raw.dad,"Dad"));
        arr[3]=new FinelQuiz(new Words( R.drawable.rsz_dog,R.raw.dog,"Dog"));
        arr[4]=new FinelQuiz(new Words( R.drawable.rsz_earth,R.raw.earth,"Earth"));
        arr[5]=new FinelQuiz(new Words( R.drawable.rsz_hello,R.raw.hello,"Hello"));
        arr[6]=new FinelQuiz(new Words( R.drawable.rsz_mom,R.raw.mom,"Mom"));
        arr[7]=new FinelQuiz(new Words( R.drawable.rsz_moon,R.raw.moon,"Moon"));
        arr[8]=new FinelQuiz(new Words( R.drawable.rsz_muose,R.raw.mouse,"Mouse"));
        arr[9]=new FinelQuiz(new Words( R.drawable.rsz_sun,R.raw.sun,"Sun"));

        sp=getSharedPreferences("Words",0);

        AudioID1[0] = R.raw.clap;
        AudioID1[1] = R.raw.lozer;


        iv2.setImageResource(arr[x].getWords().getImageId());
        iv2.setVisibility(View.VISIBLE);
        iv3.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {

        mp3 = MediaPlayer.create(this,arr[x].getWords().getSoundId());
        mp3.start();

    }


    public void Check(View view) {


        if (et2.getText().toString().equals(arr[x].getWords().getWord())) {
            x = x + 1;
            iv2.setImageResource(arr[x].getWords().getImageId());
            mp3 = MediaPlayer.create(this, AudioID1[0]);
            mp3.start();
            count=count+5;
            et2.setText("");



        } else {
            Toast.makeText(this, "טעיתם,נסו שוב(הקפידו על אות גדולה).", Toast.LENGTH_LONG).show();
            Save_Load_Error.save_error(this ,et2.getText().toString());
           SharedPreferences.Editor editor=sp.edit();
            editor.putInt( "Count",sp.getInt("Count",0)+1);
            editor.commit();
            mp3 = MediaPlayer.create(this, AudioID1[1]);
            mp3.start();
            Intent go5 = new Intent(this, lose.class);
            go5.putExtra("key",x);
            startActivity(go5);


        }
        tv5.setText("Point: "+ count);

    }


    public void finish(View view) {
        d= new Dialog(this);
        d.setContentView(R.layout.dialogbox);
        d.setCancelable(true);
        bt5=d.findViewById(R.id.bt5);
        btyes=d.findViewById(R.id.btyes);
        btno=d.findViewById(R.id.btno);
        d.show();
        btyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("QuizStart", "onClick: open ");
                    Intent goFinish= new Intent(Quiz_Start.this,Finish.class);
                    goFinish.putExtra("Point",count);
                    startActivity(goFinish);
                Log.e("QuizStart", "onClick: finish ");

            }
        });
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });


    }

}