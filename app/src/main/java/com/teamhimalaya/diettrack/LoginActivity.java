package com.teamhimalaya.diettrack;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userId;
    EditText password;
    TextView registration;
    Button loginBtn;
    Context mContext=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initiallizeViews();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = userId.getText().toString();
                String passwordString = password.getText().toString();
                if (!usernameString.isEmpty() && !passwordString.isEmpty()) {//checks userid and password field is empty or not
                    loginUser(usernameString,passwordString);
                } else
                    Toast.makeText(mContext, R.string.emptyLogin, Toast.LENGTH_SHORT).show();
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goto registration activty
                Intent iT = new Intent(LoginActivity.this, Registration.class);
                startActivity(iT);
            }
        });

    }

    private void initiallizeViews(){
        // initiallizing all the views in the layout
        userId =(EditText)findViewById(R.id.userName);
        password=(EditText)findViewById(R.id.password);
        registration=(TextView)findViewById(R.id.Registration);
        loginBtn=(Button)findViewById(R.id.loginButton);
    }

    private void loginUser(String user, String pass){
        if(user.equals(Utilities.getCurUserID(mContext))&&pass.equals(Utilities.getCurPassword(mContext))){ //checking correct credentials for login
            //if userId and password is correct go to splash activity
             Intent i = new Intent(LoginActivity.this,SplashActivity.class);
            startActivity(i);
            Toast.makeText(mContext,"Loging in...",Toast.LENGTH_SHORT).show();
            finish();
        }else{
            //shows message that login credentials are wrong
            Toast.makeText(mContext,R.string.wrongLogin,Toast.LENGTH_SHORT).show();
        }
    }

}
