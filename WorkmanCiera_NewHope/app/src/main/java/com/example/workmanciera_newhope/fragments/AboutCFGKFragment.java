//Ciera Workman
//Project 6 2009
//AboutCFGKFragment.java

package com.example.workmanciera_newhope.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.workmanciera_newhope.R;
import com.example.workmanciera_newhope.helpers.Utility;

public class AboutCFGKFragment extends Fragment {

    public static final String TAG = "AboutCFGK.TAG";

    public static AboutCFGKFragment newInstance() {

        Bundle args = new Bundle();

        AboutCFGKFragment fragment = new AboutCFGKFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.center_grieving_about_layout, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        assert getActivity() != null;
        ImageView artworkImgView = getActivity().findViewById(R.id.artworkImgView);
        artworkImgView.setScaleType(ImageView.ScaleType.FIT_XY);
        artworkImgView.setImageBitmap(Utility.loadKidsArtwork(getResources()));

        //get strings
        String belief1 = getString(R.string.cfGKPoint1);
        String belief2 = getString(R.string.cfGKPoint2);
        String belief3 = getString(R.string.cfGKPoint3);
        String belief4 = getString(R.string.cfGKPoint4);

        //attach bullet points to strings and update the textviews
        TextView belief1TV = getActivity().findViewById(R.id.beliefPoint1);
        belief1TV.setText(Utility.setBulletPoint(belief1, getResources()));
        TextView belief2TV = getActivity().findViewById(R.id.beliefPoint2);
        belief2TV.setText(Utility.setBulletPoint(belief2, getResources()));
        TextView belief3TV = getActivity().findViewById(R.id.beliefPoint3);
        belief3TV.setText(Utility.setBulletPoint(belief3, getResources()));
        TextView belief4TV = getActivity().findViewById(R.id.beliefPoint4);
        belief4TV.setText(Utility.setBulletPoint(belief4, getResources()));
    }
}
