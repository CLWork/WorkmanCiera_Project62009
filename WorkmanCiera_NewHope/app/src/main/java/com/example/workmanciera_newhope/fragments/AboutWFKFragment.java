package com.example.workmanciera_newhope.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.workmanciera_newhope.R;

public class AboutWFKFragment extends Fragment {

    public static final String TAG = "AboutWFK.TAG";

    public static AboutWFKFragment newInstance() {

        Bundle args = new Bundle();

        AboutWFKFragment fragment = new AboutWFKFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wishes_about_layout, container, false);
    }
}
