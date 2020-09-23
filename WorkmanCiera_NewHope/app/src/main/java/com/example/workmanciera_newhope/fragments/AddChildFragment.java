package com.example.workmanciera_newhope.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.workmanciera_newhope.R;

public class AddChildFragment extends Fragment {

    public static final String TAG = "AddChildFrag.TAG";

    public static AddChildFragment newInstance() {

        Bundle args = new Bundle();

        AddChildFragment fragment = new AddChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_child_layout, container, false);
    }
}
