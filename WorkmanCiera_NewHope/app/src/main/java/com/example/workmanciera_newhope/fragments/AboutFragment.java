package com.example.workmanciera_newhope.fragments;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.workmanciera_newhope.R;
import com.example.workmanciera_newhope.helpers.Utility;

public class AboutFragment extends Fragment {

    public static final String TAG = "AboutFrag.TAG";

    public static AboutFragment newInstance() {

        Bundle args = new Bundle();

        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.about_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        assert getActivity() != null;
        ImageView logo = getActivity().findViewById(R.id.imageView);
        logo.setImageBitmap(Utility.loadLargeLogo(getResources()));


        //TODO: Fix textview cut off text problem

    }
}
