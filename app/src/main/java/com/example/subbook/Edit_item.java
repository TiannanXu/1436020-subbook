/*Copyright © 2018 CMPUT301 WI18 University of Alberta - All Rights Reserved
*You may use, distribute or modify this code under terms and conditions of Code of Student Behavior at
*University of Alberta
*You can find a copy of the licence in this project.Otherwise, please contact tiannan1@ualberta.ca
*/
package com.example.subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.subbook.Add_new_content.subscriptions_set;

public class Edit_item extends AppCompatActivity {
    private TextView edit_name_box;
    private TextView edit_year_box;
    private TextView edit_charge_box;
    private TextView edit_comment_box;
    private Button Edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        final int i = getIntent().getIntExtra("position",0);
        Edit = (Button) findViewById(R.id.done_edit);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_get(i);
                Intent intent = new Intent(Edit_item.this,MainPage.class);
                startActivity(intent);

            }
        });




    }
    public void text_get(int pos) {
        edit_name_box = (TextView)findViewById(R.id.edit_name);
        edit_year_box = (TextView)findViewById(R.id.edit_date);
        edit_charge_box = (TextView)findViewById(R.id.edit_charge);
        edit_comment_box = (TextView)findViewById(R.id.edit_comment);
        String get_name = edit_name_box.getText().toString();
        String date_string = edit_year_box.getText().toString();
        String get_charge = edit_charge_box.getText().toString();
        Float get_charge_true = Float.parseFloat(get_charge);
        String get_comment = edit_comment_box.getText().toString();
        Subscription new_sub = new Subscription(get_name, date_string, get_charge_true, get_comment);
        subscriptions_set.remove(pos);
        subscriptions_set.add(pos, new_sub);
    }

}

