package com.vjes.crossland.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.vjes.crossland.R;
import android.content.Intent;
import android.widget.TextView;

public class NotifiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.welcome);

        Intent i = getIntent();
        txt.setText("Welcome " + i.getStringExtra("name"));
    }
}
