package com.example.salman.dynmicxml;

/**
 * Created by Salman on 11/17/2017.
 */

public class tag {


    String name;
    String label;
    String type;
    String required;

    int min;
    int max;
    String integer;
    String[] options;

    tag()
    {
        name="";
        label="";
        type="";
        required="";

        min=-1;
        max=-1;
        integer="";
        options=null;
    }


}
