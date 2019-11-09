package com.vjes.crossland.Activities;


import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.vjes.crossland.R;
import gr.net.maroulis.library.EasySplashScreen;

public class SplashActivity extends AppCompatActivity {
    ImageView image;
    SharedPreferences sharedPreferences;


    public static final String MyPREFERENCES = "MyPrefs" ;

    public static final String MYNAME = "name1";
    public static final String MYEMAIL = "email1";
    public static final String MYMOBILE= "mobile1";
    String name=null,email=null,mobile=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        name=sharedPreferences.getString(MYNAME,null);
        email=sharedPreferences.getString(MYEMAIL,null);
        mobile=sharedPreferences.getString(MYMOBILE,null);
        checkConnection();
       /* setContentView(R.layout.activity_splash);
        image= (ImageView) findViewById(R.id.imageView);
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(4000);
        rotate.setInterpolator(new LinearInterpolator());
        image.startAnimation(rotate);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                   *//* Intent intent=new Intent(SplashActivity.this,RegisterActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();*//*

                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(email)||TextUtils.isEmpty(mobile)){
                    Intent intent=new Intent(SplashActivity.this,RegisterActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                    intent.putExtra(USERNAME,name);
                    intent.putExtra(USERIEMAIL,email);
                    intent.putExtra(USERMOBILE,mobile);
                    startActivity(intent);
                    finish();
                }
            }
        },5000);*/
      /*  EasySplashScreen config = new EasySplashScreen(SplashActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withBackgroundResource(android.R.color.holo_red_light)
                .withHeaderText("Crossland Consultants")
                .withFooterText("Copyrights 2019 Crossland Consultants.All Rights Reserved")
                .withBeforeLogoText("Crossland Consultants")
                .withLogo(R.drawable.splashcross)
                .withAfterLogoText("Best In Chandigarh Region");
        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);*/
        EasySplashScreen config = new EasySplashScreen(SplashActivity.this);
        config.withFullScreen()
                .withSplashTimeOut(5000)
                .withBackgroundResource(android.R.color.white)
                .withHeaderText("Crossland Consultants")
                .withFooterText("Copyrights 2019 Crossland Consultants.")
                .withBeforeLogoText("Crossland Consultants")
                .withLogo(R.drawable.splashcross)
                .withAfterLogoText("Best In Chandigarh Region");
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(email)||TextUtils.isEmpty(mobile)){
            config.withTargetActivity(RegisterActivity.class);
        }
        else {
            config.withTargetActivity(MainActivity.class);
        }
        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
    }

    protected boolean isOnline() {

        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {

            return true;

        } else {

            return false;

        }

    }

    public void checkConnection(){

        if(isOnline()){

            //Toast.makeText(SplashActivity.this, "You are connected to Internet", Toast.LENGTH_SHORT).show();

        }else{

          Toast.makeText(SplashActivity.this, "Please connect to internet", Toast.LENGTH_SHORT).show();

        }

    }

}
