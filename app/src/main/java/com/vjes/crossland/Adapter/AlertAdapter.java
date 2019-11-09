package com.vjes.crossland.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vjes.crossland.Model.AlertModel;
import com.vjes.crossland.R;

import java.util.ArrayList;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.MyViewHolder>{
ArrayList<AlertModel> arrayList;
Context context;

    public AlertAdapter(ArrayList<AlertModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.alert_items,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
     myViewHolder.alertno.setText(arrayList.get(i).getNo());
     myViewHolder.alertname.setText(arrayList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView alertno,alertname;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            alertno=(TextView)itemView.findViewById(R.id.alertno);
            alertname=(TextView)itemView.findViewById(R.id.alertname);
        }
    }
}
