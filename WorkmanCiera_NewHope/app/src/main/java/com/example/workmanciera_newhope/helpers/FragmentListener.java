package com.example.workmanciera_newhope.helpers;

import com.google.firebase.auth.FirebaseAuth;

public interface FragmentListener {

    void openHome();
    void openLogin();
    void openRegister();
    void openAbout();
    void alertUser(String message);
    FirebaseAuth getAuth();

}
