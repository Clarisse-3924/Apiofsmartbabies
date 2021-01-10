package com.example.smartbabies;
import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.facebook.CallbackManager;
        import com.facebook.FacebookCallback;
        import com.facebook.FacebookException;
        import com.facebook.login.LoginResult;
        import com.facebook.login.widget.LoginButton;
        import com.squareup.picasso.Picasso;

public class facebooklogin extends AppCompatActivity {
    private TextView info,info1;
    private ImageView profile;
    private LoginButton login;
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebooklogin);
        info=findViewById(R.id.info);
        profile=findViewById(R.id.profile);
        login= findViewById(R.id.login);
        callbackManager= CallbackManager.Factory.create();
        login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                info.setText("User id:"+ loginResult.getAccessToken().getUserId());
                String imageURL = "https://graph.facebook.com/"+ loginResult.getAccessToken().getUserId()+"/picture?return_ssl_resources=1";
                Picasso.get().load(imageURL).into(profile);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}