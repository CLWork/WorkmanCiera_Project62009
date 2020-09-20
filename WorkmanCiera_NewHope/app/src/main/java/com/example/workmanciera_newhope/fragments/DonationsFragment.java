package com.example.workmanciera_newhope.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.workmanciera_newhope.R;

public class DonationsFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "DonationsFrag.TAG";

    public static DonationsFragment newInstance() {

        Bundle args = new Bundle();

        DonationsFragment fragment = new DonationsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.donation_buttons_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        assert getActivity() != null;
        Button amazonBttn = getActivity().findViewById(R.id.amazonBttn);
        Button walmartBttn = getActivity().findViewById(R.id.walmartBttn);
        Button targetBttn = getActivity().findViewById(R.id.targetBttn);

        amazonBttn.setOnClickListener(this);
        walmartBttn.setOnClickListener(this);
        targetBttn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);

        //pulls specific url, converts to uri and sets to intent
        switch(v.getId()){

            case R.id.donateBttn:
                String donateURL = "https://newhopeforkids.org/donate/";
                intent.setData(Uri.parse(donateURL));

            case R.id.newHopeBttn:
                String newHopeURL = "https://newhopeforkids.org/ways/lists/";
                intent.setData(Uri.parse(newHopeURL));
                break;
            case R.id.amazonBttn:
                String amazonURL = "https://www.amazon.com/hz/wishlist/ls/38UT0Y0RVKMH2?ref_=wl_share";
                intent.setData(Uri.parse(amazonURL));
                break;
            case R.id.walmartBttn:
                String walmartURL = "https://www.walmart.com/registry/registryforgood/363d9769-e1fb-4d56-8b11-7469381d47ba/view";
                intent.setData(Uri.parse(walmartURL));
                 break;
            case R.id.targetBttn:
                String targetURL = "https://www.target.com/gift-registry/giftgiver?registryId=2b950eb86f87499f8a450bf85342543b&amp;lnk=registr";
                intent.setData(Uri.parse(targetURL));
                break;
        }

        //makes sure there is an app to open intent
        if(intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
