package com.example.smartbabies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Signup extends AppCompatActivity {
    @BindView(R.id.button) Button Register;
    @BindView(R.id.name) EditText texname;
    @BindView(R.id.Email) EditText  textEmail;
    @BindView(R.id.Phone) EditText textPhone;
    @BindView(R.id.Password) EditText    textpass;
    @BindView(R.id.textView4) TextView loginhere;
  @BindView(R.id.progressBar) ProgressBar progressBar;
//   EditText texname, textEmail ,textPhone,textpass;
//    Button Register;
//    TextView loginhere;
//    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

   ButterKnife.bind(this);
//        texname = findViewById(R.id.name);
//        textEmail =findViewById(R.id.Email);
//        textPhone =findViewById(R.id.Phone);
//        textpass =  findViewById(R.id.Password);
//        loginhere = findViewById(R.id.textView4);
//        Register = findViewById(R.id.button);
//        progressBar = findViewById(R.id.progressBar);

        Register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = textEmail.getText().toString().trim();
                String password = textpass.getText().toString().trim();
                String phone = textPhone.getText().toString().trim();
                String name = texname.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    texname.setError("Name required");
                    return;
                }
                if(TextUtils.isEmpty(phone)){
                    textPhone.setError("Phone Required");
                    return;
                }
                if(phone.length()!=10){
                    textPhone.setError("Phone number must be ten");
                    return;
                }


                if (TextUtils.isEmpty(email)) {
                    textEmail.setError("email required");
                    return;

                }
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(textEmail.getText().toString()).matches()){
                    textEmail.setError("Enter Valid email");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    textpass.setError("password is empty");
                    return;

                }
                if (password.length() < 6) {
                    textpass.setError("password must be 6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                // register user
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
        loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));

            }
        });

    }

}