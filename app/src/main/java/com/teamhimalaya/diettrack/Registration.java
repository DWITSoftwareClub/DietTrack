package com.teamhimalaya.diettrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by gyapan on 7/2/2016.
 */
public class Registration extends AppCompatActivity {
    Context mContext = this;
    EditText userName;
    EditText password;
    EditText emailId;
    EditText userId;
    Button regBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        initializedViews();
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate("reg");
            }
        });

    }

    private void initializedViews(){
        userName =(EditText)findViewById(R.id.userName);
        password=(EditText)findViewById(R.id.password);
        emailId=(EditText)findViewById(R.id.email);
        userId=(EditText)findViewById(R.id.userId);
        regBtn=(Button)findViewById(R.id.regBtn);
    }

    private void validate(String reg){
        String user = userName.getText().toString();
        String email = emailId.getText().toString();
        String passw= password.getText().toString();
        String idUser= userId.getText().toString();
        if(!user.isEmpty() && !email.isEmpty() && !passw.isEmpty()&& !idUser.isEmpty()){
            Utilities.registerDetail(user,idUser,email,passw,mContext);
            Toast.makeText(mContext,"Account successfully created..",Toast.LENGTH_SHORT).show();
            Intent it = new Intent(Registration.this,LoginActivity.class);
            startActivity(it);
            finish();
        }else{
            if(user.isEmpty()){
                Toast.makeText(mContext,"The User name can not be left empty",Toast.LENGTH_SHORT).show();
            }else  if(email.isEmpty()){
                Toast.makeText(mContext,"The Email Id can not be left empty",Toast.LENGTH_SHORT).show();
            } else  if(email.isEmpty()){
                Toast.makeText(mContext,"The Password can not be left empty",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
