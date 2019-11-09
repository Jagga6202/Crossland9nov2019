package com.vjes.crossland.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vjes.crossland.Adapter.PathAdapter;
import com.vjes.crossland.Model.HomeModel;
import com.vjes.crossland.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PathWayFragment extends Fragment {

    RecyclerView rec_path1,rec_path2;
    ArrayList<HomeModel> arrayList1=new ArrayList<>();
    ArrayList<HomeModel> arrayList2=new ArrayList<>();
    PathAdapter pathAdapter1,pathAdapter2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_path_way, container, false);
        rec_path1=(RecyclerView)view.findViewById(R.id.rec_path1);
        rec_path2=(RecyclerView)view.findViewById(R.id.rec_path2);
        arrayList1.add(new HomeModel("INDIA",R.drawable.indiapathway));
        arrayList1.add(new HomeModel("SINGAPORE",R.drawable.singaporeflag));
        arrayList1.add(new HomeModel("DUBAI",R.drawable.dubaiflag));

        pathAdapter1=new PathAdapter(arrayList1,getActivity());
        rec_path1.setNestedScrollingEnabled(false);
        rec_path1.setAdapter(pathAdapter1);
        rec_path1.setLayoutManager(new GridLayoutManager(getActivity(),2));


        arrayList2.add(new HomeModel("AUSTRALIA",R.drawable.australiaflag));
        arrayList2.add(new HomeModel("NEWZEALAND",R.drawable.newzealandpathway));
        arrayList2.add(new HomeModel("CANADA",R.drawable.canadapathway));
        arrayList2.add(new HomeModel("UK",R.drawable.ukpathway));

        pathAdapter2=new PathAdapter(arrayList2,getActivity());
        rec_path2.setNestedScrollingEnabled(false);
        rec_path2.setAdapter(pathAdapter2);
        rec_path2.setLayoutManager(new GridLayoutManager(getActivity(),2));



        return view;
    }

}
