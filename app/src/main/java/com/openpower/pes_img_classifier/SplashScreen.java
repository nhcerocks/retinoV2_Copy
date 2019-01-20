package com.openpower.pes_img_classifier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.shoravsuriyal.image_classifier3.R;

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home_intent = new Intent(getApplicationContext(),Login.class);
                startActivity(home_intent);
                finish();
            }
        },SPLASH_TIME_OUT);


    }
}
