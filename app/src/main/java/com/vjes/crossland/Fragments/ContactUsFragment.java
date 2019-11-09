package com.vjes.crossland.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.vjes.crossland.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class ContactUsFragment extends Fragment {
    private MapView mMapView;
    private GoogleMap googleMap;
    LatLngBounds.Builder builder;
    CameraUpdate cu;
    TextView work4;
  /*  ArrayList<LatLng> arrayList=new ArrayList<LatLng>();
    LatLng chandigarh = new LatLng(30.743192, 76.785949);
    LatLng gurdaspur = new LatLng(32.038192, 75.405389);
    LatLng jalandhar = new LatLng(31.323000, 75.579790);
    LatLng karnal = new LatLng(29.677013, 76.997470);
    LatLng ludhiana = new LatLng(30.893788, 75.829811);*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.new_contact_us, container, false);
        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        work4=(TextView)view.findViewById(R.id.work4);
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                //To add marker
               /* LatLng sydney = new LatLng(30.743192, 76.785949);
                googleMap.addMarker(new MarkerOptions().position(sydney).title("Crossland").snippet("SCO 98-99-100, Level 2, Sector 17-D,Chandigarh"));
                // For zooming functionality
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(15).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));*/
                ArrayList<Marker> arrayList=new ArrayList<Marker>();
                Marker chandigarh = googleMap.addMarker(new MarkerOptions().position(new LatLng(
                        30.743192, 76.785949)).title("Crossland Chandigarh"));

               Marker gurdaspur =googleMap.addMarker(new MarkerOptions().position(new LatLng(
                        32.038192, 75.405389)).title("Crossland Gurdaspur"));

                Marker jalandhar = googleMap.addMarker(new MarkerOptions().position(new LatLng(
                        31.323000, 75.579790)).title("Crossland Jalandhar"));

                Marker karnal = googleMap.addMarker(new MarkerOptions().position(new LatLng(
                        29.677013, 76.997470)).title("Crossland Karnal"));

                Marker ludhiana =  googleMap.addMarker(new MarkerOptions().position(new LatLng(
                        30.893788, 75.829811)).title("Crossland Ludhiana"));

                arrayList.add(chandigarh);
                arrayList.add(gurdaspur);
                arrayList.add(jalandhar);
                arrayList.add(karnal);
                arrayList.add(ludhiana);
                builder = new LatLngBounds.Builder();
                for (Marker m : arrayList) {
                    builder.include(m.getPosition());
                }

                int padding = 45;
                LatLngBounds bounds = builder.build();
              cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
              googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                  @Override
                  public void onMapLoaded() {
                      googleMap.animateCamera(cu);
                  }
              });
            }
        });

        /*work4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_no= work4.getText().toString().replaceAll("-", "");
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" +phone_no));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(callIntent);
            }
        });*/
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}