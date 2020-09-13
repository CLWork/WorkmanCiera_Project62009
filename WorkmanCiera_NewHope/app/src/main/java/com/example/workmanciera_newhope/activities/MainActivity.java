//Ciera Workman
//Project 6
//MainActivity.java

package com.example.workmanciera_newhope.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.workmanciera_newhope.R;
import com.example.workmanciera_newhope.fragments.LoginFragment;
import com.example.workmanciera_newhope.helpers.AuthListener;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, AuthListener {

    BottomNavigationView bottomNavigation;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.navigationBar);
        bottomNavigation.setOnNavigationItemSelectedListener(this);

        openLogin();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homePage:
                openHome();
                return true;

            case R.id.listPage:
                openList();
                return true;

            case R.id.donatePage:
                openDonate();
                return true;

            case R.id.aboutPage:
                openAbout();
                return true;

            case R.id.settingPage:
                openSetting();
                return true;
        }
        return false;
    }


    @Override
    public void openHome(){

    }

    public void openDonate(){

    }

    public void openList(){

    }

    public void openAbout(){

    }

    public void openSponsors(){

    }

    public void openSetting(){

    }

    @Override
    public void openLogin(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, LoginFragment.newInstance(), LoginFragment.TAG).commit();

        bottomNavigation.setVisibility(View.GONE);
    }

    public void openRegister(){

        bottomNavigation.setVisibility(View.GONE);
    }
}