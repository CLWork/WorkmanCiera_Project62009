package com.example.workmanciera_newhope.helpers;

import com.google.firebase.auth.FirebaseAuth;

public interface AuthListener {

    void openHome();
    void openLogin();
    void openRegister();
    void alertUser(String message);
    FirebaseAuth getAuth();

}