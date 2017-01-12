package com.example.hatice.bigcalculator;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     Thread timer= new Thread(){

         @Override
         public void run() {

        try{

            sleep(5000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        finally {

            Intent intent= new Intent(getApplicationContext(),CalculatorActivity.class);
            startActivity(intent);

        }

         }
     };

        timer.start();

    }


}
