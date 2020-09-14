package com.example.workmanciera_newhope.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.workmanciera_newhope.R;
import com.example.workmanciera_newhope.helpers.AuthListener;
import com.example.workmanciera_newhope.helpers.Utility;

import java.util.ArrayList;
import java.util.Arrays;

public class RegisterFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "RegisterFrag.TAG";
    private AuthListener mListener;
    private String selectedState = "";

    public static RegisterFragment newInstance() {

        Bundle args = new Bundle();

        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        assert getActivity() != null;
        ImageView logoIV = getActivity().findViewById(R.id.treeLogoIV);
        logoIV.setImageBitmap(loadLogo());

        Button nextBttn = getActivity().findViewById(R.id.nextButton);
        nextBttn.setOnClickListener(this);

        populateSpinner();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof AuthListener) {
            mListener = (AuthListener) context;
        }
    }

    //convert resource into bitmap
    private Bitmap loadLogo() {
        return BitmapFactory.decodeResource(getResources(), R.drawable.new_hope_tree_logo);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nextButton) {

            validateInput();
        }
    }

    private void validateInput() {
        assert getActivity() != null;
        EditText nameET = getActivity().findViewById(R.id.nameET);
        EditText emailRegET = getActivity().findViewById(R.id.emailRegET);
        EditText passwordRegET = getActivity().findViewById(R.id.passwordRegET);
        EditText addressOneET = getActivity().findViewById(R.id.addressET);
        EditText unitET = getActivity().findViewById(R.id.unitET);
        EditText zipcodeET = getActivity().findViewById(R.id.editTextNumber);

        //Required information
        String fullName = nameET.getText().toString();
        String email = emailRegET.getText().toString();
        String password = passwordRegET.getText().toString();

        //Optional information
        String addressOne = addressOneET.getText().toString();
        String unit = unitET.getText().toString();
        String zipcode = zipcodeET.getText().toString();

        String fullAddress = "";

        if (!Utility.isPasswordStrongEnough(password)) {

            mListener.alertUser("Password must have:\n" +
                    "1 Upper Case Letter \n" +
                    "1 Lower case Letter \n" +
                    "1 Symbol (@#$%^&+=) \n" +
                    "At least 6 characters long \n" +
                    "No Spaces.");

        } else if (!Utility.isEmailValid(email)) {

            mListener.alertUser("Email must not be empty.\n " +
                    "Format: somePhrase@domain.com");

        }else if(!Utility.isNameFieldValid(fullName)){

            mListener.alertUser("Name field must not be empty.");

        } else {

            //check to see if optional fields are filled.
            if(Utility.isAddressValid(addressOne) && Utility.isZipValid(zipcode) && !selectedState.equals("")){
                if(!unit.isEmpty()){
                    fullAddress = addressOne + " " + unit + ", " + selectedState + " " + zipcode;
                } else {
                    fullAddress = addressOne + ", " + selectedState + " " + zipcode;
                }
            }

            //TODO: Create User


        }

    }

    //populates spinner and sets listener
    private void populateSpinner() {
        assert getActivity() != null;
        final ArrayList<String> states = makeStateList();
        final Spinner stateSpinner = getActivity().findViewById(R.id.stateSpinner);

        assert getContext() != null;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, states);
        stateSpinner.setAdapter(adapter);

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedState = states.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    //puts together list of states
    private ArrayList<String> makeStateList() {
        ArrayList<String> states = new ArrayList<>();
        String[] stateArray = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT",
                "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA",
                "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
                "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA",
                "WV", "WI", "WY"};
        states.addAll(Arrays.asList(stateArray));
        return states;
    }


}
