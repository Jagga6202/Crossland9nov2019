package com.vjes.crossland.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.vjes.crossland.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsaFragment extends Fragment {
    private ImageView usaflag;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_usa,container,false);
        usaflag=(ImageView)view.findViewById(R.id.usaflag);
        Glide.with(getActivity()).load(R.drawable.usa1).into(usaflag);
        return view;
    }

}