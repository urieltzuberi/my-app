package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView tv1,tv2;
Button bt1;
Bitmap bitmap;
ImageView iv1;
Intent goMe,goApp,intent;
SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.bt1);
        StartActiveClass sac1=new
                StartActiveClass(this);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        iv1=findViewById(R.id.iv1);
        loadPicture();
        goApp = new Intent(this,About_App.class);
        goMe = new Intent(this,About_Me.class);
        bt1.setOnClickListener(sac1);


    }
    public void loadPicture(){
        Bitmap b = HelperFile.getAllFils(this);
        if (b!=null) {
            iv1.setImageBitmap(b);
            iv1.setVisibility(View.VISIBLE);
        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0)
        {
            if(resultCode==RESULT_OK)
                {
                    bitmap=(Bitmap)data.getExtras().get("data");
                iv1.setImageBitmap(bitmap);
                iv1.setVisibility(View.VISIBLE);
                    try {
                        FileOutputStream os = this.openFileOutput("pic.png",Context.MODE_PRIVATE);
                        bitmap.compress(Bitmap.CompressFormat.PNG,100,os);
                        os.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }






    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.xml_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         int id =item.getItemId();

        if (id == R.id.action_AboutApp) {
            Toast.makeText(this,"you selected about app", Toast.LENGTH_LONG).show();
            startActivity(goApp);

        }
        else if  (id == R.id.action_AboutMe) {
            Toast.makeText(this,"you selected about me", Toast.LENGTH_LONG).show();
            startActivity(goMe);

        }

       else  if (id == R.id.camera) {
            Toast.makeText(this,"Take a Photo", Toast.LENGTH_LONG).show();
            intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,0);



        }
        return true;


    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
    }
}