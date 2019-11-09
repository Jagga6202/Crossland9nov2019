package com.vjes.crossland.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vjes.crossland.Adapter.InterInAdapter;
import com.vjes.crossland.Model.HomeModel;
import com.vjes.crossland.R;
import java.util.ArrayList;
public class InternationalIntershipFragment extends Fragment {
    RecyclerView rec_inter;
    ArrayList<HomeModel> arrayList=new ArrayList<>();
    InterInAdapter interInAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_international_intership, container, false);
        rec_inter=(RecyclerView)view.findViewById(R.id.rec_inter);
        arrayList.add(new HomeModel("AUSTRALIA",R.drawable.australiaflag));
        arrayList.add(new HomeModel("CHINA",R.drawable.chinaflag));
        arrayList.add(new HomeModel("DUBAI",R.drawable.dubaiflag));
        arrayList.add(new HomeModel("GERMANY",R.drawable.germanyflag));
        arrayList.add(new HomeModel("MAURITIUS",R.drawable.mauritiusflag));
        arrayList.add(new HomeModel("MALAYSIA",R.drawable.malaysiaflag));
        arrayList.add(new HomeModel("SINGAPORE",R.drawable.singaporeflag));
        arrayList.add(new HomeModel("THAILAND",R.drawable.thailandflag));
        interInAdapter=new InterInAdapter(arrayList,getActivity());
        rec_inter.setNestedScrollingEnabled(false);
        rec_inter.setAdapter(interInAdapter);
        rec_inter.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return view;
    }
}
