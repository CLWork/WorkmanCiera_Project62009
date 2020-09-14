//Ciera Workman
//Project 6 2009
//Utility.java

package com.example.workmanciera_newhope.helpers;


import android.text.TextUtils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public static boolean isPasswordStrongEnough(String p) {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        p = p.trim();

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher m = pattern.matcher(p);

        return m.matches();
    }

    public static boolean isPasswordValid(String p){
        p = p.trim();
        return !p.isEmpty();
    }

    public static boolean isEmailValid(String e){
        e = e.trim();
        return !TextUtils.isEmpty(e) && android.util.Patterns.EMAIL_ADDRESS.matcher(e).matches();
    }

    public static boolean isNameFieldValid(String n){
        n = n.trim();

        return !n.isEmpty() && !n.matches(".*\\d.*");

    }

    public static boolean isAddressValid(String a1){
        a1 = a1.trim();
        return !a1.isEmpty();
    }

    public static boolean isZipValid(String z){
        z = z.trim();
        return !z.isEmpty();
    }



}
