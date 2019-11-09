package com.vjes.crossland.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vjes.crossland.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VerifyPhoneActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    Boolean CheckEditText ;
    private String verificationId;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private EditText editText;
    String NameHolder, EmailHolder, MobileHolder ,QualiHolder,CityHolder,InterestHolder,CountryHolder;
    String RegisterURL = "http://avneet6202.000webhostapp.com/crorrlandapp/register1.php" ;
    String fcm_id;
    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;
    public static final String MyPREFERENCES = "MyPrefs" ;

    public static final String MYNAME = "name1";
    public static final String MYEMAIL = "email1";
    public static final String MYMOBILE= "mobile1";
    public  static final String USERMOBILE="mobile";
    public  static final String USERNAME="name";
    public  static final String USERIEMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);
        sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        mAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressbar);
        editText = findViewById(R.id.editTextCode);
        GetCheckEditTextIsEmptyOrNot();
        String phonenumber = "+91"+getIntent().getStringExtra("mobile");
        sendVerificationCode(phonenumber);

        findViewById(R.id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = editText.getText().toString().trim();

                if (code.isEmpty() || code.length() < 6) {

                    editText.setError("Enter code...");
                    editText.requestFocus();
                    return;
                }
                verifyCode(code);
            }
        });

    }

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                           /* Intent intent = new Intent(VerifyPhoneActivity.this, ProfileActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                            startActivity(intent);*/
                            registerUser(NameHolder,CityHolder,MobileHolder,EmailHolder,QualiHolder,InterestHolder,CountryHolder);
                            Toast.makeText(VerifyPhoneActivity.this, "OTP Verified", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(VerifyPhoneActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void sendVerificationCode(String number) {
        progressBar.setVisibility(View.VISIBLE);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                editText.setText(code);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(VerifyPhoneActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };


    public void registerUser(final String name,final String city, final String mobile,
                             final String email,final String quali, final String interest,
                             final String country){
        progressDialog = ProgressDialog.show(VerifyPhoneActivity.this,"Loading Data",null,true,true);
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest st=new StringRequest(Request.Method.POST, RegisterURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(VerifyPhoneActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                if(response.equalsIgnoreCase("Data Inserted Successfully")){
                    Intent intent = new Intent(VerifyPhoneActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                    editor.commit(); intent.putExtra(USERNAME,name);
                    intent.putExtra(USERIEMAIL,email);
                    intent.putExtra(USERMOBILE,mobile);
                    editor.putString(MYEMAIL,email);
                    editor.putString(MYNAME,name);
                    editor.putString(MYMOBILE,mobile);
                    startActivity(intent);
                    finish();
                }
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(VerifyPhoneActivity.this, ""+error, Toast.LENGTH_SHORT).show();
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

    public void GetCheckEditTextIsEmptyOrNot(){
        Intent intent=getIntent();
        NameHolder = intent.getStringExtra("name");
        EmailHolder = intent.getStringExtra("email");
        MobileHolder = intent.getStringExtra("mobile");
        QualiHolder = intent.getStringExtra("quali");
        CityHolder = intent.getStringExtra("city");
        InterestHolder=intent.getStringExtra("interest");
        CountryHolder=intent.getStringExtra("country");

    }
}
