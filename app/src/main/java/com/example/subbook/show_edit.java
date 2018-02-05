/*Copyright © 2018 CMPUT301 WI18 University of Alberta - All Rights Reserved
*You may use, distribute or modify this code under terms and conditions of Code of Student Behavior at
*University of Alberta
*You can find a copy of the licence in this project.Otherwise, please contact tiannan1@ualberta.ca
*/

package com.example.subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.subbook.Add_new_content.subscriptions_set;


import static com.example.subbook.Add_new_content.subscriptions_set;


public class show_edit extends AppCompatActivity {

    private Button back_to_main;
    private Button delete_item;
    private Button edit_to_edit;
    private TextView test1;
    private TextView test2;
    private TextView test3;
    private TextView test4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_edit);

        final int i = getIntent().getIntExtra("position_val",0);
        //Bundle extra = getIntent().getExtras();
        //Bundle extras = getIntent().getExtras();
        //String po = extras.getString("positon"); // retrieve the data using keyName
        //int i = Integer.parseInt(po);

        //Toast.makeText(this,, Toast.LENGTH_SHORT).show();

        back_to_main = (Button) findViewById(R.id.edit_back);
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump_to_main();
            }
        });
        delete_item = (Button) findViewById(R.id.Delete);
        delete_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(i);
            }
        });

        edit_to_edit = (Button) findViewById(R.id.edit);
        edit_to_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_to_edit_page(i);
            }
        });


//        Toast.makeText(this,"this is text",Toast.LENGTH_LONG).show();
//        Toast.makeText(this,i,Toast.LENGTH_LONG).show();

        String name = subscriptions_set.get(i).getname();
        String date = subscriptions_set.get(i).getDate();
        Float  charge = subscriptions_set.get(i).getCharge();
        String comment = subscriptions_set.get(i).getComment();

        test1 = (TextView)findViewById(R.id.testbox1);
        test2 = (TextView)findViewById(R.id.testbox2);
        test3 = (TextView)findViewById(R.id.testbox3);
        test4 = (TextView)findViewById(R.id.testbox4);

        String name_text = "Name: " + name;
        String date_text = "Date: " + date;
        String charge_text = "Monthly Charge: " + charge.toString();
        String comment_text = "Comment: " + comment;


        test1.setText(name_text);
        test2.setText(date_text);
        test3.setText(charge_text);
        test4.setText(comment_text);




    }



    public void delete(int position){
        subscriptions_set.remove(position);
        jump_to_main();



    }



    public void jump_to_main(){
        Intent intent = new Intent(show_edit.this, MainPage.class);
        startActivity(intent);

    }


    public void go_to_edit_page(int pos){
        Intent send_item = new Intent(getApplicationContext(),Edit_item.class);
        send_item.putExtra("position",pos);
        startActivity(send_item);
        Intent intent = new Intent(show_edit.this,Edit_item.class);
        startActivity(intent);


    }
}
