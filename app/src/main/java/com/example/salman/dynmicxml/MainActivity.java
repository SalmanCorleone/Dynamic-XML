package com.example.salman.dynmicxml;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    myFileReader mfr;
    String str;
    TextView tv;
    tagExtractor tagX;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.mainText);

        new processData().execute();


        LinearLayout ll= (LinearLayout)findViewById(R.id.activity_main);
        EditText et= new EditText(this);
        et.setHeight(20);
        et.setWidth(300);
        ll.addView(et);





        /*
        Thread t=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };






        t.start();
        */





    }


    private class processData extends AsyncTask<Void, Void, String>
    {


        @Override
        protected String doInBackground(Void... params) {
            mfr=new myFileReader(getApplicationContext(),"input.xml");
            tagX=new tagExtractor();
            tagX.extractTags(mfr.getString());
            tagX.stringToTagObject();


           //String[] tmp= tagX.getTmp();
           // return tmp[7];

            return tagX.testString;
        }

        @Override
        protected void onPostExecute(String st) {

            if(st!=null)tv.setText(st);
            return;

        }
        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }






}
