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
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Login extends AppCompatActivity {
   @BindView(R.id.email1) EditText textEmail;
 @BindView(R.id.textView7) TextView  create;
  @BindView(R.id.Pass) EditText  textpass;
 @BindView(R.id.button2) Button login;
    @BindView(R.id.progressBar2) ProgressBar progressBar;
    private EditText Name;
//EditText textEmail,textpass;
//    TextView create;
//    ProgressBar progressBar;
//    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText) findViewById(R.id.name);
       ButterKnife.bind(this);
////        textEmail =findViewById(R.id.email1);
////        textpass =  findViewById(R.id.Pass);
////        create= findViewById(R.id.textView7);
////        login = findViewById(R.id.button2);
//
//        progressBar = findViewById(R.id.progressBar2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textEmail.getText().toString().trim();
                String password = textpass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    textEmail.setError("email required");
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
                String name = Name.getText().toString();
                Intent intent = new Intent(Login.this, MainActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);


            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Signup.class));

            }
        });

    }
}