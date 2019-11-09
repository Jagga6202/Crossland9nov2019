package com.vjes.crossland.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vjes.crossland.Model.AboutModel;

import com.vjes.crossland.R;

import java.util.ArrayList;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.MyViewHolder>{

    ArrayList<AboutModel> arrayList;
    Context context;

    public AboutAdapter(ArrayList<AboutModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.about_item, viewGroup, false);
        return new AboutAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.about_image.setImageResource(arrayList.get(i).getAboutimage());
        myViewHolder.about_text.setText(arrayList.get(i).getAbouttext());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView about_image;
        TextView about_text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            about_image = (ImageView) itemView.findViewById(R.id.about_image);
           about_text = (TextView) itemView.findViewById(R.id.about_text);

        }
    }
}
