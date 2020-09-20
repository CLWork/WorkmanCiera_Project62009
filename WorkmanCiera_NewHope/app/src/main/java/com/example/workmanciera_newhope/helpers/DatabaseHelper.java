package com.example.workmanciera_newhope.helpers;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DatabaseHelper {

    private static final String TAG = "dBHelper";

    public static ArrayList<Sponsors> getSponsorInfo(){

        final ArrayList<Sponsors> sponsorFromDB = new ArrayList<>();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Sponsors").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot s : snapshot.getChildren()) {
                    Sponsors spon = s.getValue(Sponsors.class);

                    assert spon != null;
                    sponsorFromDB.add(spon);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("MAIN", error.getMessage());
            }
        });

            return sponsorFromDB;
    }

    //save method for the ability to add new sponsors
    public static void saveSponsorInfo(ArrayList<Sponsors> sponsorsList){

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        for(int i = 0; i < sponsorsList.size(); i++){
            mDatabase.child("Sponsors").child(sponsorsList.get(i).getName()).setValue(sponsorsList.get(i));
        }

    }

    //TODO: Get user data for profile
    public static void getUserProfileData(){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot s : snapshot.getChildren()) {
                    Users u = s.getValue(Users.class);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("MAIN", error.getMessage());
            }
        });
    }

    //TODO: Save updated user data

}
