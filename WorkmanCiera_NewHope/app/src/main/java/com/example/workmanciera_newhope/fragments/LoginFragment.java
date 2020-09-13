package com.example.workmanciera_newhope.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.workmanciera_newhope.R;
import com.example.workmanciera_newhope.helpers.AuthListener;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;
import java.util.Collections;

public class LoginFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "LoginFrag.Tag";
    private static final String EMAIL = "email";
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private AuthListener mListener;


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

        if(context instanceof AuthListener){
            mListener = (AuthListener) context;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        assert getActivity() != null;
        ImageView logoImage = getActivity().findViewById(R.id.logoImageView);
        logoImage.setImageBitmap(loadLogo());

        //Facebook button
        loginButton = (LoginButton) getActivity().findViewById(R.id.login_button);
        loginButton.setReadPermissions(Collections.singletonList(EMAIL));
        loginButton.setFragment(this);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getContext(), "Facebook Login Success!", Toast.LENGTH_SHORT).show();
                mListener.openHome();
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
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private Bitmap loadLogo(){
       return BitmapFactory.decodeResource(getResources(), R.drawable.new_hope_logo);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

        }
    }
}
