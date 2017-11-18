package com.example.salman.dynmicxml;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.*;
import java.io.BufferedReader;


/**
 * Created by Salman on 11/16/2017.
 */

public class myFileReader
{
    private String str;
    InputStream is;
    private final Context context;
    AssetManager am;





    myFileReader(Context cont, String st){
        context = cont;
        am = context.getAssets();
        try {
            is = am.open(st);
            //Toast.makeText(context, "Loaded", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }



        str=readTextFile();



    }


    private String readTextFile() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = is.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return outputStream.toString();
    }

    public String getString()
    {
        return str;
    }




}




