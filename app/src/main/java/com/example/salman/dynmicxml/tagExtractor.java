package com.example.salman.dynmicxml;

import android.util.Log;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Salman on 11/17/2017.
 */

public class tagExtractor {
    //private static final String TAG = "Tesing";


    ArrayList<tag> tagList;
    String[] tmp;

    String[] parts;

    ArrayList<String> testing;
    String testString;


    tagExtractor() {
        tagList = new ArrayList();
        testing = new ArrayList<>();
        testString = "";
    }


    public void extractTags(String str) {
        parts = str.split("(?<=>)");
        //Log.d(TAG, "extract: hello parsing");

    }

    public String[] getParts() {
        return parts;
    }

    public String[] getTmp() {
        return tmp;
    }


    public void stringToTagObject() {

        for (int i = 3; i < parts.length - 3; i++) {
            tag tmpTag = new tag();
            tmp = parts[i].split("\" ");


            //name
            int x = 0;
            while (tmp[0].charAt(x) != '"') x++;
            x++;
            if (x > 1) {

                String subStr = tmp[0].substring(0, x);
                tmp[0] = tmp[0].replaceAll(subStr, "");

                tmpTag.name = tmp[0];
            }

            //label
            x = 0;
            while (tmp[1].charAt(x) != '"') x++;
            x++;
            if (x > 1) {

                String subStr = tmp[1].substring(0, x);
                tmp[1] = tmp[1].replaceAll(subStr, "");

                tmpTag.label = tmp[1];
            }

            //type
            x = 0;
            while (tmp[2].charAt(x) != '"') x++;
            x++;
            if (x > 1) {

                String subStr = tmp[2].substring(0, x);
                tmp[2] = tmp[2].replaceAll(subStr, "");

                tmpTag.type = tmp[2];
            }


            //required
            x = 0;
            while (tmp[3].charAt(x) != '"') x++;
            x++;

            if (x > 1) {

                String subStr = tmp[3].substring(0, x);
                tmp[3] = tmp[3].replaceAll(subStr, "");

                tmpTag.required = tmp[3];
            }


            /**********/

            //min
            x = 0;
            while (tmp[4].charAt(x) != '"') x++;
            x++;

            if (x > 1) {

                String subStr = tmp[4].substring(0, x);
                tmp[4] = tmp[4].replaceAll(subStr, "");

                if (tmp[4].length() != 0) tmpTag.min = Integer.parseInt(tmp[4]);
            }

            //max
            x = 0;
            while (tmp[5].charAt(x) != '"') x++;
            x++;

            if (x > 1) {

                String subStr = tmp[5].substring(0, x);
                tmp[5] = tmp[5].replaceAll(subStr, "");

                if (tmp[5].length() != 0) tmpTag.max = Integer.parseInt(tmp[5]);
            }

            //integer
            x = 0;
            while (tmp[6].charAt(x) != '"') x++;
            x++;

            if (x > 1) {

                String subStr = tmp[6].substring(0, x);
                tmp[6] = tmp[6].replaceAll(subStr, "");

                tmpTag.integer = tmp[6];
            }


            //options


            x = 0;
            int y;

            while (tmp[7].charAt(x) != '"') x++;
            x++;
            y = x;
            while (tmp[7].charAt(y) != '"') y++;


            if (x > 1) {

                tmp[7] = tmp[7].substring(x, y);
                tmpTag.options = tmp[7].split("\\|");


            }


            testString += tmpTag.type + '\n';


/**/

            tagList.add(tmpTag);


        }
    }


    public ArrayList<tag> getTagList() {
        return tagList;
    }


}
