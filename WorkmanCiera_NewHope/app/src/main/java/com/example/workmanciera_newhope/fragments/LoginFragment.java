//Ciera Workman
//Project 6 2009
//LoginFragment.java

package com.example.workmanciera_newhope.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.workmanciera_newhope.R;
import com.example.workmanciera_newhope.helpers.FragmentListener;
import com.example.workmanciera_newhope.helpers.Utility;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class LoginFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "LoginFrag.Tag";
    private static final String EMAIL = "email";
    private boolean loginTapped = false;
    private Context mContext;
    private LoginButton fbLoginBttn;
    private CallbackManager callbackManager;
    private FragmentListener mListener;
    FirebaseAuth auth;



    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_layout, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callbackManager = CallbackManager.Factory.create();
        mContext = context;
        if (context instanceof FragmentListener) {
            mListener = (FragmentListener) context;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        assert getActivity() != null;

        //logo area
        ImageView logoImage = getActivity().findViewById(R.id.logoImageView);
        logoImage.setImageBitmap(loadLogo());

        //in app login button
        Button loginBttn = getActivity().findViewById(R.id.loginButton);
        loginBttn.setOnClickListener(this);

        Button registerBttn = getActivity().findViewById(R.id.registerButton);
        registerBttn.setOnClickListener(this);

        //Facebook button
        fbLoginBttn = (LoginButton) getActivity().findViewById(R.id.fbLoginBttn);
        fbLoginBttn.setPermissions(Arrays.asList("email", "public_profile"));
        fbLoginBttn.setFragment(this);
        fbLoginBttn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getContext(), "Facebook Login Success!", Toast.LENGTH_SHORT).show();

                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Toast.makeText(getContext(), "Facebook Login Cancelled!", Toast.LENGTH_SHORT).show();
                mListener.openLogin();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getContext(), "Facebook Login Failed!", Toast.LENGTH_SHORT).show();
                Log.e(TAG, error.toString());
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        //Result forwarded to callbackManager
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loginButton:
                validateUserInput();

                break;
            case R.id.registerButton:
                mListener.openRegister();

                break;
            default:
                Toast.makeText(getContext(), "Unknown error occurred", Toast.LENGTH_SHORT).show();
        }
    }

    //convert resource into bitmap
    private Bitmap loadLogo() {
        return BitmapFactory.decodeResource(getResources(), R.drawable.new_hope_logo);
    }

    private void validateUserInput() {
        assert getActivity() != null;
        EditText emailET = getActivity().findViewById(R.id.emailAddressET);
        EditText passwordET = getActivity().findViewById(R.id.passwordET);

        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();

        if (!Utility.isEmailValid(email)) {
            mListener.alertUser("Email must not be empty.\n " +
                    "Valid Format: somePhrase@domain.com");
        } else if (!Utility.isPasswordValid(password)) {
            mListener.alertUser("Password must have: \n " +
                    "1 Upper Case Letter \n" +
                    "1 Lower case Letter \n" +
                    "1 Symbol (@#$%^&+=) \n" +
                    "At least 6 characters long \n" +
                    "No Spaces.");
        } else {
           signInUser(email, password);

        }

    }

    private void signInUser(String e, final String p){
        auth = mListener.getAuth();
        auth.signInWithEmailAndPassword(e, p).addOnCompleteListener((Activity) mContext, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                    mListener.openHome();
                } else {
                    Toast.makeText(getContext(), "Login Failed.", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, Objects.requireNonNull(task.getException()).toString());
                }
            }
        });
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);
        final FirebaseAuth mAuth = mListener.getAuth();
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(Objects.requireNonNull(getActivity()), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Log.d(TAG, "signInWithCredential:success");
                            mListener.openHome();

                        } else {

                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(getContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}
