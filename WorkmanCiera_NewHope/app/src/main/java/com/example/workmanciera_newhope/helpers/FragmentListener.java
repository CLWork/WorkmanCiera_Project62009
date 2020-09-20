package com.example.workmanciera_newhope.helpers;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public interface FragmentListener {

    void openHome();
    void openLogin();
    void openRegister();
    void openAbout();
    void openCFGAbout();
    void openWFKAbout();
    void openSponsors();
    void alertUser(String message);
    FirebaseAuth getAuth();
    ArrayList<Sponsors> getSponsorList();

}
