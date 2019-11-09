package com.vjes.crossland.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vjes.crossland.Fragments.EdFragment;
import com.vjes.crossland.Fragments.InternationalIntershipFragment;
import com.vjes.crossland.Fragments.PathWayFragment;
import com.vjes.crossland.Fragments.SkillMigrationFragment;
import com.vjes.crossland.Fragments.StudyAbroadFragment;
import com.vjes.crossland.Model.HomeModel;
import com.vjes.crossland.R;


import java.util.ArrayList;

public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    ArrayList<HomeModel> arrayList;
    Context context;

    public HomeAdapter(ArrayList<HomeModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_items, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.home_image.setImageResource(arrayList.get(i).getHomeimage());
        myViewHolder.home_text.setText(arrayList.get(i).getHometext());
        myViewHolder.home_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.get(i).getHometext().equalsIgnoreCase("English Development")) {
                     addFragment(new EdFragment());
                }
                else if(arrayList.get(i).getHometext().equalsIgnoreCase("Study Abroad")){
                    addFragment(new StudyAbroadFragment());
                }
                 else if(arrayList.get(i).getHometext().equalsIgnoreCase("Skill Migration")){
                    addFragment(new SkillMigrationFragment());
                 }
              else if(arrayList.get(i).getHometext().equalsIgnoreCase("International Internship")){
                    addFragment(new InternationalIntershipFragment());
                 }
                  else if(arrayList.get(i).getHometext().equalsIgnoreCase("Pathway Program")){
                   addFragment(new PathWayFragment());
                 }

            }
        });

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

    public void addFragment(Fragment fragment) {
        FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, fragment);
        ft.commit();
        ft.addToBackStack(null);

    }
}