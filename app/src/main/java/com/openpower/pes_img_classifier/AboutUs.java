package com.openpower.pes_img_classifier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.shoravsuriyal.image_classifier3.R;

public class AboutUs extends AppCompatActivity {

    private Toolbar nToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("About us");
        setContentView(R.layout.activity_about_us);


        nToolbar=(Toolbar) findViewById(R.id.nav_action_bar);
        setSupportActionBar(nToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About Us");
    }
}
