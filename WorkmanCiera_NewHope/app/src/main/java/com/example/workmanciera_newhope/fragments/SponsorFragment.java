package com.example.workmanciera_newhope.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workmanciera_newhope.R;
import com.example.workmanciera_newhope.helpers.FragmentListener;
import com.example.workmanciera_newhope.helpers.RecyclerAdapter;

public class SponsorFragment extends Fragment {

    public static final String TAG = "SponsorsFrag.TAG";
    private FragmentListener mListener;

    public static SponsorFragment newInstance() {

        Bundle args = new Bundle();

        SponsorFragment fragment = new SponsorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sponsor_layout, container, false);

        RecyclerView rV = v.findViewById(R.id.recyle_view);
        rV.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        RecyclerAdapter adapter = new RecyclerAdapter(mListener.getSponsorList());
        rV.setAdapter(adapter);

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            mListener = (FragmentListener) context;
        }
    }
}
