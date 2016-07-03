package com.teamhimalaya.diettrack;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gyapan on 7/2/2016.
 */
public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=2000;  //Duration of splashscreen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, MenuActivity.class);
                overridePendingTransition(android.R.animator.fade_out,android.R.animator.fade_in);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
