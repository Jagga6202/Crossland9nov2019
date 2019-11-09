package com.vjes.crossland.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.vjes.crossland.R;


public class WorkWithUsFragment extends Fragment {

    private String city_array[]={"City","Chandigarh","Jalandhar","Bhatinda","Ludhiana"};
    private String post_array[]={"Apply for","English Counselor","Visa Counselor","Admission Department","Visa Filling","Senior Manager"};
    private Spinner city,applyfor;
    private String selectedCity,selectedApplyFor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_work_with_us, container, false);
        city=(Spinner)view.findViewById(R.id.city);
        applyfor=(Spinner)view.findViewById(R.id.applyfor);
loadcity();
loadapply();
        return view;
    }


    private void loadcity(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, city_array);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        city.setAdapter(adapter);

        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(city_array[position].equalsIgnoreCase("city")){
                    return;
                }
                else {
                    Toast.makeText(getActivity(), ""+city_array[position], Toast.LENGTH_SHORT).show();
                    selectedCity=city_array[position];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private void loadapply(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, post_array);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        applyfor.setAdapter(adapter);
        applyfor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(post_array[position].equalsIgnoreCase("Apply for")){
                    return;
                }
                else {
                    Toast.makeText(getActivity(), ""+post_array[position], Toast.LENGTH_SHORT).show();
                    selectedApplyFor=post_array[position];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
