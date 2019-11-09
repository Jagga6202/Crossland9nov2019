package com.vjes.crossland.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vjes.crossland.Adapter.HomeAdapter;
import com.vjes.crossland.Model.HomeModel;
import com.vjes.crossland.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
RecyclerView rec;
ArrayList<HomeModel> arrayList;
HomeAdapter homeAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        rec=(RecyclerView)view.findViewById(R.id.home_rec);
        arrayList=new ArrayList<>();
        arrayList.add(new HomeModel("English Development",R.drawable.educationdevelopment));
        arrayList.add(new HomeModel("Study Abroad",R.drawable.studyabroad));
        arrayList.add(new HomeModel("Skill Migration",R.drawable.skillmigration));
        arrayList.add(new HomeModel("International Internship",R.drawable.internship));
        arrayList.add(new HomeModel("Pathway Program",R.drawable.pathway));
        homeAdapter=new HomeAdapter(arrayList,getActivity());
        rec.setNestedScrollingEnabled(false);
        rec.setAdapter(homeAdapter);
        rec.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return view;
    }

}
