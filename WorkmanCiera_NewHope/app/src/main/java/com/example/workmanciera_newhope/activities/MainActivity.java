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
import com.example.workmanciera_newhope.fragments.AboutWFKFragment;
import com.example.workmanciera_newhope.fragments.DonationsFragment;
import com.example.workmanciera_newhope.fragments.HomeFragment;
import com.example.workmanciera_newhope.fragments.LoginFragment;
import com.example.workmanciera_newhope.fragments.RegisterFragment;
import com.example.workmanciera_newhope.fragments.SponsorFragment;
import com.example.workmanciera_newhope.helpers.FragmentListener;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.workmanciera_newhope.helpers.Sponsors;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

//All Information about New Hope for Kids is from the official website.
//1 image is from Unsplash named dandelion_girl
//All other images have been provided by New Hope.

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, FragmentListener {

    BottomNavigationView bottomNavigation;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    final ArrayList<Sponsors> sponsorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.navigationBar);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        FirebaseUser currentUser = mAuth.getCurrentUser();


        //user is still logged in, open home page.
//        if(currentUser != null){
//            openHome();
//        } else{
//            //user is not logged in, open login.
//            openLogin();
//         }

        openHome();

    }

    //For Tab Navigation - Opens corresponding fragments
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


    //INTERFACE METHODS - OPENING FRAGMENTS \\
    @Override
    public void openHome(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, HomeFragment.newInstance(), HomeFragment.TAG).commit();

        bottomNavigation.setVisibility(View.VISIBLE);
    }

    public void openDonate(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, DonationsFragment.newInstance(), DonationsFragment.TAG).commit();
    }

    public void openList(){

    }

    @Override
    public void openAbout(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, AboutFragment.newInstance(), AboutFragment.TAG).commit();

    }

    @Override
    public void openSponsors(){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, SponsorFragment.newInstance(), SponsorFragment.TAG).commit();

    }

    public void openSetting(){

    }

    @Override
    public void openLogin(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, LoginFragment.newInstance(), LoginFragment.TAG).commit();

        bottomNavigation.setVisibility(View.GONE);
    }

    @Override
    public void openCFGAbout(){
        getSupportFragmentManager().beginTransaction().addToBackStack(AboutCFGKFragment.TAG)
                .replace(R.id.frameLayout, AboutCFGKFragment.newInstance(), AboutCFGKFragment.TAG).commit();

    }

    @Override
    public void openWFKAbout(){
        getSupportFragmentManager().beginTransaction().addToBackStack(AboutWFKFragment.TAG)
                .replace(R.id.frameLayout, AboutWFKFragment.newInstance(), AboutWFKFragment.TAG).commit();
    }

    @Override
    public void openRegister(){
        bottomNavigation.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, RegisterFragment.newInstance(), RegisterFragment.TAG).commit();
    }


    //INTERFACE METHODS - GETTING VARIABLES
    @Override
    public FirebaseAuth getAuth() {
        return mAuth;
    }

    @Override
    public ArrayList<Sponsors> getSponsorList(){
        return sponsorList;
    }

    //INTERFACE METHOD - UTILITY METHOD
    @Override
    public void alertUser(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();

    }

    //Pops fragments from back stack.
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}