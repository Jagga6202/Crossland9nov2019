package com.vjes.crossland.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.vjes.crossland.Adapter.AboutAdapter;
import com.vjes.crossland.Adapter.HomeAdapter;
import com.vjes.crossland.Model.AboutModel;
import com.vjes.crossland.Model.HomeModel;
import com.vjes.crossland.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {

ImageView globeimage;
    RecyclerView rec;
    ArrayList<AboutModel> arrayList;
    AboutAdapter aboutusAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.new_about_us, container, false);
        globeimage=(ImageView)view.findViewById(R.id.globeimage);
        Glide.with(getActivity()).load(R.drawable.newaboutus).into(globeimage);
        rec=(RecyclerView)view.findViewById(R.id.about_rec);
        arrayList=new ArrayList<>();
        arrayList.add(new AboutModel("Country Course College/University",R.drawable.countrycourse));
        arrayList.add(new AboutModel("Prepare For IELTS/PTE/OTE & other Requirements",R.drawable.ieltspte));
        arrayList.add(new AboutModel("Accept Offer Letter",R.drawable.acceptoffer));
        arrayList.add(new AboutModel("Paying Fees & helth Cover",R.drawable.payingfees));
        arrayList.add(new AboutModel("Optained a Visa",R.drawable.optainedvisa));
        arrayList.add(new AboutModel("Pre departing Guidance",R.drawable.preedeparting));
        aboutusAdapter=new AboutAdapter(arrayList,getActivity());
        rec.setNestedScrollingEnabled(false);
        rec.setAdapter(aboutusAdapter);
        rec.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return view;
    }

}
