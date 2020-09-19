package com.example.workmanciera_newhope.fragments;

import android.opengl.Matrix;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        assert getActivity() != null;
        ImageView artworkImgView = getActivity().findViewById(R.id.artworkImgView);
        artworkImgView.setScaleType(ImageView.ScaleType.FIT_XY);
        artworkImgView.setImageBitmap(Utility.loadKidsArtwork(getResources()));
    }
}
