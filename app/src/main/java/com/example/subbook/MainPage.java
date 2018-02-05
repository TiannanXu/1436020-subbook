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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.subbook.Add_new_content.subscriptions_set;

public class MainPage extends AppCompatActivity {

    private Button add;
    private ListView main_list;
    private TextView List_length;
    private TextView charge_sum;
    private float total = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        add = (Button) findViewById(R.id.ADD_buttom);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_add_new_content();
            }
        });
        main_list = (ListView)findViewById(R.id.listview_box);

        ArrayAdapter<Subscription> adapter = new ArrayAdapter<Subscription>(this,android.R.layout.simple_list_item_1,subscriptions_set);

        main_list.setAdapter(adapter);
        main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                open_show_edit(position);
            }
        });

        set_num_in_list();
        cal_sum();




    }

    public void open_add_new_content() {
        Intent add_new_intent = new Intent(MainPage.this, Add_new_content.class );
        startActivity(add_new_intent);
    }

    public void open_show_edit(int position){
        Intent send_item = new Intent(getApplicationContext(),show_edit.class);
        send_item.putExtra("position_val",position);
        //Intent intent = new Intent(MainPage.this, show_edit.class);
        //intent.putExtra("position_val",position);
        startActivity(send_item);
        Intent show_edit_page = new Intent(MainPage.this,show_edit.class);
        startActivity(show_edit_page);

    }
    public void set_num_in_list () {
        List_length = (TextView)findViewById(R.id.length_display);
        int len = subscriptions_set.size();
        String display_length = "Number of subscription in list:" + len;
        List_length.setText(display_length);

    }

    public void cal_sum() {
        charge_sum = (TextView) findViewById(R.id.Sum);
        for (int i = 0; i < subscriptions_set.size(); i++) {
            total += subscriptions_set.get(i).getCharge();
        }
        String Print_total = "Total Charge is " + total + " dollars";
        charge_sum.setText(Print_total);
    }

}