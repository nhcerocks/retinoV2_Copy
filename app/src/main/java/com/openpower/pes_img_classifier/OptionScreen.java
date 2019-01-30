package com.openpower.pes_img_classifier;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.shoravsuriyal.image_classifier3.R;

public class OptionScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button test;
    Button report;
    Button info;
    Button aboutus;
    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    private Toolbar nToolbar;
    TextView name;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn);

        test = (Button)findViewById(R.id.btTest);
        report =(Button)findViewById(R.id.btReport);
        info = (Button)findViewById(R.id.btInfo);
        aboutus = (Button) findViewById(R.id.btAbout);

        nToolbar=(Toolbar) findViewById(R.id.nav_action_bar);

        setSupportActionBar(nToolbar);

        NavigationView navigationView= (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(this);


        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this,nDrawerLayout,R.string.open,R.string.close);

        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");
        //getSupportActionBar().setTextColor(getResources().getColor(android.R.color.white));

        name = (TextView)findViewById(R.id.tv_name);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        name.setText("Hello "+email);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //img= (ImageView)findViewById(R.id.imageView);
        /*img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart = new Intent(getApplicationContext(),Cart.class);
                startActivity(cart);
            }
        });*/
        NavigationView navigation = (NavigationView) findViewById(R.id.navigation_menu);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_header_user);
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //String email = user.getEmail();
        navUsername.setText(email);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ReportActivity.class);
                startActivity(i);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Info.class);
                startActivity(i);
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AboutUs.class);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(nToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_abt){

            Intent in = new Intent(this,AboutUs.class);
            startActivity(in);
            return false;

        }

        if(id == R.id.nav_sync)
        {
            Intent in = new Intent(this,SyncServ.class);
            startActivity(in);
            return false;

        }

        if(id == R.id.nav_reports)
        {
            Intent in = new Intent(this,ReportActivity.class);
            startActivity(in);
            return false;

        }
        if(id == R.id.nav_acct)
        {
            Intent in = new Intent(this,Account.class);
            startActivity(in);
            return false;

        }

        if(id == R.id.nav_logout){
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
            //NavigationView navigation = (NavigationView) findViewById(R.id.navigation_menu);
            //View headerView = navigation.getHeaderView(0);
            //TextView navUsername = (TextView) headerView.findViewById(R.id.nav_header_user);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            Intent in = new Intent(this,Login.class);
            startActivity(in);
            return false;

        }
        return false;
    }

    @Override
    public void onBackPressed() {
        //This is an inbuilt function that executes the following code when the back button is pressed
        //android.os.Process.killProcess(android.os.Process.myPid());
        moveTaskToBack(true);
        return;
    }

}
