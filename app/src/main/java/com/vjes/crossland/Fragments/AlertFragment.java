package com.vjes.crossland.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.vjes.crossland.Adapter.AlertAdapter;
import com.vjes.crossland.Model.AlertModel;
import com.vjes.crossland.R;

import java.util.ArrayList;

public class AlertFragment extends Fragment {
    RecyclerView rec;
    ArrayList<AlertModel> arrayList=new ArrayList<>();
    AlertAdapter alertAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_alert, container, false);
        rec=(RecyclerView)view.findViewById(R.id.rec_alert);
        arrayList.add(new AlertModel("1","Event in Chandigarh on 26 July 2019"));
        arrayList.add(new AlertModel("2","Workshop in Jalandhar on 27 July 2019"));
        arrayList.add(new AlertModel("3","Mega Event in Ludihana on 24 July 2019"));
        arrayList.add(new AlertModel("4","Event In GDA on 29 June 2019"));

        alertAdapter=new AlertAdapter(arrayList,getActivity());
        rec.setNestedScrollingEnabled(false);
        rec.setAdapter(alertAdapter);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }


}
