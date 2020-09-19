//Ciera Workman
//Project 6
//MainActivity.java

package com.example.workmanciera_newhope.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.workmanciera_newhope.R;
import com.example.workmanciera_newhope.fragments.AboutCFGKFragment;
import com.example.workmanciera_newhope.fragments.AboutFragment;
import com.example.workmanciera_newhope.fragments.HomeFragment;
import com.example.workmanciera_newhope.fragments.LoginFragment;
import com.example.workmanciera_newhope.fragments.RegisterFragment;
import com.example.workmanciera_newhope.helpers.FragmentListener;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, FragmentListener {

    BottomNavigationView bottomNavigation;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.navigationBar);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        mAuth = FirebaseAuth.getInstance();

        //openLogin();
       // openAbout();
        openCFGAbout();
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
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, HomeFragment.newInstance(), HomeFragment.TAG).commit();

        bottomNavigation.setVisibility(View.VISIBLE);
    }

    public void openDonate(){

    }

    public void openList(){

    }

    @Override
    public void openAbout(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, AboutFragment.newInstance(), AboutFragment.TAG).commit();

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

    public void openCFGAbout(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, AboutCFGKFragment.newInstance(), AboutCFGKFragment.TAG).commit();

    }

    public void openWFKAbout(){

    }

    @Override
    public FirebaseAuth getAuth() {
        return mAuth;
    }

    @Override
    public void alertUser(String message) {
      new AlertDialog.Builder(this)
              .setTitle("Oops")
              .setMessage(message)
              .setPositiveButton(android.R.string.ok, null)
              .show();

    }
    @Override
    public void openRegister(){
        bottomNavigation.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, RegisterFragment.newInstance(), RegisterFragment.TAG).commit();
    }
}