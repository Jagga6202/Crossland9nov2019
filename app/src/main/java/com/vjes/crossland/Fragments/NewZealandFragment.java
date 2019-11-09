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
public class NewZealandFragment extends Fragment {


    private ImageView newzelflag;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_new_zealand, container, false);
        newzelflag=(ImageView)view.findViewById(R.id.newzelflag);
        Glide.with(getActivity()).load(R.drawable.newzealand).into(newzelflag);
        return view;

    }

}
