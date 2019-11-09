package com.vjes.crossland.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.vjes.crossland.R;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    EditText name, mobile , email,city;
    Boolean CheckEditText=false ;
    Spinner interest,country,qualifi;
    String NameHolder, EmailHolder, MobileHolder ,QualiHolder,CityHolder,InterestHolder,CountryHolder;

    ProgressDialog progressDialog;
    String RegisterURL = "http://crosslandapp.000webhostapp.com/crossland/register2.php" ;
    SharedPreferences sharedPreference;
    SharedPreferences.Editor editor;
    public static final String MyPREFERENCES = "MyPrefs" ;

    public static final String MYNAME = "name1";
    public static final String MYEMAIL = "email1";
    public static final String MYMOBILE= "mobile1";
    public  static final String USERMOBILE="mobile";
    public  static final String USERNAME="name";
    public  static final String USERIEMAIL="email";
    boolean checkvalidate=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sharedPreference=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor=sharedPreference.edit();
        register = (Button)findViewById(R.id.register);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        mobile = (EditText)findViewById(R.id.mobile);
        city = (EditText) findViewById(R.id.city);
        interest = (Spinner) findViewById(R.id.interest);
        country = (Spinner) findViewById(R.id.country);
        qualifi = (Spinner) findViewById(R.id.qualifi);
        final String[] intre=getResources().getStringArray(R.array.interest);
        final String[] coun=getResources().getStringArray(R.array.country);
        final String[] qua=getResources().getStringArray(R.array.qualification);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, intre);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interest.setAdapter(adapter);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,coun);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(adapter1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,qua);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qualifi.setAdapter(adapter2);
        interest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                InterestHolder=intre[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryHolder=coun[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        qualifi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                QualiHolder=qua[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetCheckEditTextIsEmptyOrNot();

                if(CheckEditText==true ){
                    //registerUser(NameHolder,CityHolder,MobileHolder,EmailHolder,QualiHolder,InterestHolder,CountryHolder);
                   //Intent intent = new Intent(RegisterActivity.this, VerifyPhoneActivity.class);
                   /*  intent.putExtra("name",NameHolder);
                    intent.putExtra("city",CityHolder);
                    intent.putExtra("mobile",MobileHolder);
                    intent.putExtra("email",EmailHolder);
                    intent.putExtra("quali",QualiHolder);
                    intent.putExtra("interest",InterestHolder);
                    intent.putExtra("country",CountryHolder);*/
                    registerUser(NameHolder,CityHolder,MobileHolder,EmailHolder,QualiHolder,InterestHolder,CountryHolder);
                   // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    //startActivity(intent);
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Check fields you have entered.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void GetCheckEditTextIsEmptyOrNot(){
        NameHolder = name.getText().toString().trim();
        EmailHolder = email.getText().toString().trim();
        MobileHolder = mobile.getText().toString().trim();
       // QualiHolder = quali.getText().toString().trim();
        CityHolder = city.getText().toString().trim();
       if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(MobileHolder)
                ||TextUtils.isEmpty(QualiHolder) ||TextUtils.isEmpty(CityHolder)||MobileHolder.length()!=10||
                !EmailHolder.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+"))

        {
            CheckEditText = false;
        }
       else {

            CheckEditText = true ;
        }

      /*  if(TextUtils.isEmpty(NameHolder)){
            checkvalidate=true;
            name.setError("Please fill name field");
            CheckEditText = false;
        }
        if(TextUtils.isEmpty(EmailHolder)){
            checkvalidate=true;
            email.setError("Please fill email field");
        }
        if(TextUtils.isEmpty(MobileHolder)){
            checkvalidate=true;
            mobile.setError("Please fill mobile field");
            CheckEditText = false;
        }
        if(TextUtils.isEmpty(QualiHolder)){
            checkvalidate=true;
            quali.setError("Please fill qualification field");
            CheckEditText = false;
        }
        if(TextUtils.isEmpty(CityHolder)){
            checkvalidate=true;
            city.setError("Please fill city field");
            CheckEditText = false;
        }
        if(MobileHolder.length()!=10){
            checkvalidate=true;
            mobile.setError("Enter mobile with 10 digits");
            CheckEditText = false;
        }
        if(!EmailHolder.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")){
            checkvalidate=true;
            email.setError("Please fill correct emailid");
            CheckEditText = false;
        }

        else if(checkvalidate==true){

            CheckEditText = true ;
        }*/
    }

    public void registerUser(final String name,final String city, final String mobile,
                             final String email,final String quali, final String interest,
                             final String country){
        progressDialog = ProgressDialog.show(RegisterActivity.this,"Loading Data",null,true,true);
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest st=new StringRequest(Request.Method.POST, RegisterURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(RegisterActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                if(response.equalsIgnoreCase("Data Inserted Successfully")){
                    editor.putString(MYEMAIL,email);
                    editor.putString(MYNAME,name);
                    editor.putString(MYMOBILE,mobile);
                    editor.commit();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(USERNAME,name);
                    intent.putExtra(USERIEMAIL,email);
                    intent.putExtra(USERMOBILE,mobile);

                    startActivity(intent);
                    finish();
                }
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                Log.e("volley error",""+error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                String fcm_id = FirebaseInstanceId.getInstance().getToken();
                params.put("name", name);
                params.put("city", city);
                params.put("mobile", mobile);
                params.put("email", email);
                params.put("quali", quali);
                params.put("interest", interest);
                params.put("country", country);
                params.put("fcm_id", fcm_id);
                return params;
            }
        };
        rq.add(st);

    }
    private boolean isValidMail(String email) {

        String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        return Pattern.compile(EMAIL_STRING).matcher(email).matches();

    }


}
