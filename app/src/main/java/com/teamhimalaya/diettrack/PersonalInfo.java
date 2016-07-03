package com.teamhimalaya.diettrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by gyapan on 7/2/2016.
 */
public class PersonalInfo extends AppCompatActivity {

    Spinner genderSpinner;
    Spinner activitySpinner;
    Spinner geoSpinner;
    EditText age;
    EditText height;
    EditText weight;
    TextView user;
    Button update;

    String[] geoVal={"Select one","Himalayan","Hilly","Terai"};
    String[] genderVal={"Select one","Male","Female"};
    String[] activityVal={"Select one","Active","Non-Active"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);

        // EditText area = (EditText) findViewById(R.id.areaEt);


        initializeViews();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

    }


    private void initializeViews() {
        age = (EditText)findViewById(R.id.Age);
        height=(EditText)findViewById(R.id.Height);
        weight=(EditText)findViewById(R.id.Weight);
        genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        geoSpinner = (Spinner) findViewById(R.id.geoSpinner);
        activitySpinner = (Spinner) findViewById(R.id.activitySpinner);
        user=(TextView)findViewById(R.id.user);
        user.setText("Name:" + Utilities.getCurUsername(this));
        update = (Button)findViewById(R.id.update);

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, genderVal);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        ArrayAdapter<String> geoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, geoVal);
        geoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        geoSpinner.setAdapter(geoAdapter);

        ArrayAdapter<String> activityAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, activityVal);
        activityAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(activityAdaptor);
    }



    private void validate(){
        String ageT = age.getText().toString();
        String heightT = height.getText().toString();
        String weightT = weight.getText().toString();
        String genderT = genderVal[genderSpinner.getSelectedItemPosition()];
        String geographyT = geoVal[geoSpinner.getSelectedItemPosition()];
        String activityT = activityVal[activitySpinner.getSelectedItemPosition()];
        if (!ageT.isEmpty() && !heightT.isEmpty() && !weightT.isEmpty()
                && !genderT.equals("Select one") && !geographyT.equals("Select one") && !activityT.equals("Select one")){
            Utilities.personalDetail(ageT,heightT,weightT,genderT,geographyT,activityT,this);
            Toast.makeText(this,"Successfully updated!!!",Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this,"Please fill all the fields correctly!",Toast.LENGTH_SHORT).show();
        }
    }



}
