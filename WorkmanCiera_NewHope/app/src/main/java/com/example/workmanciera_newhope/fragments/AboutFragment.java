//Ciera Workman
//Project 6 2009
//AboutFragment.java
package com.example.workmanciera_newhope.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.workmanciera_newhope.R;
import com.example.workmanciera_newhope.helpers.FragmentListener;
import com.example.workmanciera_newhope.helpers.Utility;

public class AboutFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "AboutFrag.TAG";
    private FragmentListener mListener;

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

        TextView centerTV = getActivity().findViewById(R.id.cFGKLinkHeader);
        TextView wishTV = getActivity().findViewById(R.id.wFkLinkHeader);
        TextView viewSponsorsTV = getActivity().findViewById(R.id.linkToSponsorsTV);

            centerTV.setOnClickListener(this);
            wishTV.setOnClickListener(this);
            viewSponsorsTV.setOnClickListener(this);


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            mListener = (FragmentListener) context;
        }
    }

    //opens subpages on click
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cFGKLinkHeader:
                mListener.openCFGAbout();
                break;
            case R.id.wFkLinkHeader:
                mListener.openWFKAbout();
                break;
            case R.id.linkToSponsorsTV:
                mListener.openSponsors();
                break;

        }
    }
}
