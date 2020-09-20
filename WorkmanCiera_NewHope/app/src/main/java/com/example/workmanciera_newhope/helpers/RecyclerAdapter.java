package com.example.workmanciera_newhope.helpers;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workmanciera_newhope.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Sponsors> mSponsors;

    public RecyclerAdapter(ArrayList<Sponsors> sponsorsList){
        mSponsors = sponsorsList;
        Log.i("RV", ""+sponsorsList.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Sponsors s = mSponsors.get(position);
        String name = s.getName();
        TextView sponsorNameTV = holder.sponsorTitle;
        sponsorNameTV.setText(name);

//        Uri imgUri = Uri.parse(mSponsors.get(position).getImgURL());
//        ImageView sponsorImage = holder.sponsorImage;
//        sponsorImage.setImageURI(imgUri);

    }

    @Override
    public int getItemCount() {
        return mSponsors.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        //public ImageView sponsorImage;
        public TextView sponsorTitle;


        public ViewHolder(View itemView) {
            super(itemView);
            //sponsorImage = itemView.findViewById(R.id.sponsorImageView);
            sponsorTitle = itemView.findViewById(R.id.sponsorNameTV);

        }
    }
}
