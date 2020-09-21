//Ciera Workman
//Project 6 2009
//RecyclerAdapter.java


package com.example.workmanciera_newhope.helpers;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workmanciera_newhope.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseError;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;

public class SponsorAdapter extends FirebaseRecyclerAdapter<Sponsors, SponsorAdapter.SponsorHolder> {
    final FirebaseRecyclerOptions<Sponsors> options;
    final Context context;
    FragmentListener mListener;

    public SponsorAdapter(@NonNull FirebaseRecyclerOptions<Sponsors> options, Context context) {
        super(options);
        this.options = options;
        this.context = context;
        if(context instanceof  FragmentListener){
            mListener = (FragmentListener) context;
        }
    }


    @NonNull
    @Override
    public SponsorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_layout, parent, false);

        return new SponsorHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final SponsorHolder sponsorHolder, int i, @NonNull Sponsors sponsors) {
            sponsorHolder.name.setText(sponsors.getName());

            Picasso.get().load(Uri.parse(sponsors.getImgURL())).into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    sponsorHolder.imgView.setImageBitmap(bitmap);
                }

                @Override
                public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                    Toast.makeText(context, "Error on getting Sponsor Image", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            });

    }

    @Override
    public void onDataChanged() {
        super.onDataChanged();
        Toast.makeText(context, "Sponsors updated!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(@NonNull DatabaseError error) {
        super.onError(error);
        Toast.makeText(context, "Error loading Sponsor information.", Toast.LENGTH_SHORT).show();
    }

    public static class SponsorHolder extends RecyclerView.ViewHolder{

        private final TextView name;
        private ImageView imgView;

        public SponsorHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sponsorNameTV);
            imgView = itemView.findViewById(R.id.sponsorImageView);
        }
    }

}
