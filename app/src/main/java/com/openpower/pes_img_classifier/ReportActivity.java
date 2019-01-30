package com.openpower.pes_img_classifier;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.shoravsuriyal.image_classifier3.R;

public class ReportActivity extends AppCompatActivity {
    private Toolbar nToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        nToolbar=(Toolbar) findViewById(R.id.nav_action_bar);
        setSupportActionBar(nToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Report");
    }
}
