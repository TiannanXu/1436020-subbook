/*Copyright © 2018 CMPUT301 WI18 University of Alberta - All Rights Reserved
*You may use, distribute or modify this code under terms and conditions of Code of Student Behavior at
*University of Alberta
*You can find a copy of the licence in this project.Otherwise, please contact tiannan1@ualberta.ca
*/

package com.example.subbook;

import java.util.Date;

/**
 * Created by Alex on 2018-02-04.
 */

public class Subscription {
    private String name;
    private String date;
    private Float charge;
    private String comment;

    public Subscription(String name, String date, Float charge, String comment){this.name = name; this.date =date; this.charge = charge; this.comment = comment;};


    public String getname(){
        return this.name;
    };

    public String getDate(){
        return this.date;
    }

    public Float getCharge(){
        return this.charge;
    }

    public String getComment() {
        return this.comment;
    }


    public String toString(){
        return name +"  "+ charge + "  " + date;
    }


}
