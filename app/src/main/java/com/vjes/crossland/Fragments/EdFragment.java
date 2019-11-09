package com.vjes.crossland.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vjes.crossland.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EdFragment extends Fragment {

    ImageView ed1,ed2,ed3,ed4,ed5,ed6;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ed, container, false);
        ed1=(ImageView)view.findViewById(R.id.ed1);
        ed2=(ImageView)view.findViewById(R.id.ed2);
        ed3=(ImageView)view.findViewById(R.id.ed3);
        ed4=(ImageView)view.findViewById(R.id.ed4);
        ed5=(ImageView)view.findViewById(R.id.ed5);
        ed6=(ImageView)view.findViewById(R.id.ed6);
        ed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              addFragment(new IeltsFragment());
            }
        });
        ed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new PteFragment());
            }
        });
        ed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new OetFragment());
            }
        });
        ed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new CaelFragment());
            }
        });
        ed5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new CelpiFragment());
            }
        });
        ed6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addFragment(new SpokenEnglishFragment());
            }
        });
        return view;
    }
    public void addFragment(Fragment fragment){
        FragmentManager fm=getActivity().getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
        ft.addToBackStack(null);

    }

}
