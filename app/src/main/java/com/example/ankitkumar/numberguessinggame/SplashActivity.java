package com.example.ankitkumar.numberguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    int number;
    int count;
    boolean found;

    String res = "";

    EditText edit;
    TextView showcount;

    public void setCount(){
        count = 7;
    }

    public void decreaseCount(){
        count--;
    }

    public void getRandom(){
        Random rand = new Random();
        number = rand.nextInt(50) + 1;
    }

    public void function(View view){

        try{
            edit = (EditText) findViewById(R.id.box);
            Log.i("box",edit.getText().toString());
            int val = Integer.parseInt(edit.getText().toString().trim());

            if(val < number){
                res = "number you guessed is lower";
            } else if(val == number){
                res = "Hurray! you guessed it right";
                found = true;
                getRandom();
                setCount();
//                Log.i("random number",Integer.toString(number));
            } else {
                res = "number you guessed is higher";
            }

            if(!found && count > 0){
                decreaseCount();
            } else {
                found = false;
            }

            if(count == 0) {
                getRandom();
                setCount();
                res = "Actual number is " + Integer.toString(number) + " try again";
//                Log.i("random number", Integer.toString(number));
            }

        } catch(NumberFormatException e){
            res = "Please Enter a number b/w 1-50";
            decreaseCount();
        }
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        edit.getText().clear();
        showcount.setText(Integer.toString(count));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        found = false;
        showcount = (TextView)findViewById(R.id.chance);
        showcount.setText("7");
        getRandom();
        setCount();
//        Log.i("random number",Integer.toString(number));
    }
}
