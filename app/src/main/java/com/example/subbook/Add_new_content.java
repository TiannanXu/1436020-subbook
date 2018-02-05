/*Copyright © 2018 CMPUT301 WI18 University of Alberta - All Rights Reserved
*You may use, distribute or modify this code under terms and conditions of Code of Student Behavior at
*University of Alberta
*You can find a copy of the licence in this project.Otherwise, please contact tiannan1@ualberta.ca
*/
package com.example.subbook;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Add_new_content extends AppCompatActivity {
    public static String filename = "filename";
    private Button back;
    private Button done;
    private TextView name_input;
    private TextView date_input;
    private TextView charge_input;
    private TextView comment_input;

    public static ArrayList<Subscription> subscriptions_set = new ArrayList<Subscription>();
    private static final String TAG = "Add_new_content";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_content);
        back = (Button) findViewById(R.id.Back_in_add);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    back_to_main();
                }
        });
        done = (Button) findViewById(R.id.done_in_add);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_get();
            }
        });



    }
    public void back_to_main() {
        Intent back_new_intent = new Intent(Add_new_content.this,MainPage.class);
        startActivity(back_new_intent);

    }
    public void text_get() {
        name_input = (TextView) findViewById(R.id.enter_name);
        date_input = (TextView) findViewById(R.id.enter_date);
        charge_input = (TextView) findViewById(R.id.enter_charge);
        comment_input = (TextView) findViewById(R.id.enter_comment);
        String get_name = name_input.getText().toString();
        String date_string = date_input.getText().toString();
        String get_charge = charge_input.getText().toString();
        Float get_charge_true = Float.parseFloat(get_charge);
        String get_comment = comment_input.getText().toString();
        Subscription new_sub = new Subscription(get_name,date_string,get_charge_true,get_comment);
        Boolean no_error = constraint(get_name,date_string,get_charge_true,get_comment);
        if (no_error){
            subscriptions_set.add(new_sub);
            back_to_main();

        }



    }
    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        Boolean Correct = Boolean.TRUE;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
                Correct = Boolean.FALSE;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return Correct;
    }

    public boolean constraint(String name,String date,float charge,String comment){
        Boolean can_still = Boolean.TRUE;

        if (name.length() > 20) {
            Toast.makeText(this,"This name is to long, make one less then 20 characters",Toast.LENGTH_LONG).show();
            can_still = Boolean.FALSE;
        }
//        if (date.length() != 10){
//            Toast.makeText(this,"Date length is not right",Toast.LENGTH_LONG).show();
//            can_still = Boolean.FALSE;
//        }
        if (charge < 0) {
            Toast.makeText(this, "Charge show be positive", Toast.LENGTH_SHORT).show();
            can_still = Boolean.FALSE;
        }
        if (comment.length() > 30){
            Toast.makeText(this, "Comment should less than 30 characters", Toast.LENGTH_SHORT).show();
            can_still = Boolean.FALSE;
        }
        if (isValidFormat("yyyy-MM-dd",date) == Boolean.FALSE){

            Toast.makeText(this, "Wrong format, use yyyy-MM-dd", Toast.LENGTH_SHORT).show();
            can_still = Boolean.FALSE;

        }

//        if (date.length() == 10){
//            if (date.substring(4) != "-"){
//                Toast.makeText(this, "Wrong format, use yyyy-MM-dd", Toast.LENGTH_SHORT).show();
//                can_still = Boolean.FALSE;
//            } else if (date.substring(7) != "-"){
//                Toast.makeText(this, "Wrong format, use yyyy-MM-dd", Toast.LENGTH_SHORT).show();
//                can_still = Boolean.FALSE;
//            } else {
//                String year_str = date.substring(0,3);
//                String month_str = date.substring(5,6);
//                String day_str = date.substring(8,9);
//                Boolean year_wrong = Boolean.FALSE;
//                Boolean month_wrong = Boolean.FALSE;
//                Boolean day_wrong = Boolean.FALSE;
//                if (year_wrong = year_str.contains(".")){
//                    Toast.makeText(this, "Invaild character in year", Toast.LENGTH_SHORT).show();
//                    can_still = Boolean.FALSE;
//                } else if (year_wrong = year_str.contains("/")) {
//                    Toast.makeText(this, "Invaild character in year", Toast.LENGTH_SHORT).show();
//                    can_still = Boolean.FALSE;
//                }
//                if (month_wrong = month_str.contains(".")){
//                    Toast.makeText(this, "Invaild character in month", Toast.LENGTH_SHORT).show();
//                    can_still = Boolean.FALSE;
//                } else if (month_wrong = month_str.contains("/")) {
//                    Toast.makeText(this, "Invaild character in month", Toast.LENGTH_SHORT).show();
//                    can_still = Boolean.FALSE;
//                }
//                if (day_wrong = day_str.contains(".")){
//                    Toast.makeText(this, "Invaild character in day", Toast.LENGTH_SHORT).show();
//                    can_still = Boolean.FALSE;
//                } else if (day_wrong = day_str.contains("/")) {
//                    Toast.makeText(this, "Invaild character in day", Toast.LENGTH_SHORT).show();
//                    can_still = Boolean.FALSE;
//                }
//
//
//            }
//
//        }

        return can_still;
    }

}
