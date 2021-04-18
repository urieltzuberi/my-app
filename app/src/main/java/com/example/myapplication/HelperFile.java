package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelperFile
{
    public static void writeFileToInternalStorage(Context context, Bitmap bitmap, String filename)
    {

        try {
            FileOutputStream os = context.openFileOutput(filename,Context.MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,os);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Bitmap readFileFromInternalStorage(Context context,String filename)
    {
        Bitmap b=null;
        try {
            InputStream in = context.openFileInput(filename);

            b= BitmapFactory.decodeStream(in);
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static Bitmap getAllFils(Context context)
    {
        String b1 = "pic.png";
        Bitmap b = readFileFromInternalStorage(context,b1);
        return b;
    }
}
