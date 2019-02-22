package com.example.saif.shop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Splash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        final SharedPreferences sharedpreferences = getSharedPreferences("loginDetails", Context.MODE_PRIVATE);
        SharedPreferences checkpreferences= getSharedPreferences("firstTime",MODE_PRIVATE);
        boolean firststart= checkpreferences.getBoolean("firstStart",true);
        final String name = sharedpreferences.getString("customerName", Login.customerName);
        if(firststart) {
            SharedPreferences preferences= getSharedPreferences("firstTime",MODE_PRIVATE);
            SharedPreferences.Editor editor= preferences.edit();
            editor.putBoolean("firstStart",false);
            editor.apply();
            Intent intent = new Intent(Splash.this, Login.class);
            startActivity(intent);
            finish();

        }

        else{
            Thread timer = new Thread() {
                @Override
                public void run() {

                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (Login.checkuser==true ) {
                            Intent intent = new Intent(Splash.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {

                            Intent intent = new Intent(Splash.this, Login.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            };
            timer.start();
        }
    }
}
