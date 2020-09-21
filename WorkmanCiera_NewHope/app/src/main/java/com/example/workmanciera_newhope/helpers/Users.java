//Ciera Workman
//Project 6 2009
//Users.java


package com.example.workmanciera_newhope.helpers;

public class Users {
    final String fullName;
    final String email;
    String address;

    public Users(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
