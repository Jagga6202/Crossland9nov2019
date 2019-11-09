package com.vjes.crossland.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vjes.crossland.Model.HomeModel;
import com.vjes.crossland.R;

import java.util.ArrayList;

public class PathAdapter extends RecyclerView.Adapter<PathAdapter.MyViewHolder> {
    ArrayList<HomeModel> arrayList;
    Context context;

    public PathAdapter(ArrayList<HomeModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.inter_items, viewGroup, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.home_image.setImageResource(arrayList.get(i).getHomeimage());
        myViewHolder.home_text.setText(arrayList.get(i).getHometext());
    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView home_image;
        TextView home_text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            home_image = (ImageView) itemView.findViewById(R.id.home_image);
            home_text = (TextView) itemView.findViewById(R.id.home_text);
        }
    }


}
