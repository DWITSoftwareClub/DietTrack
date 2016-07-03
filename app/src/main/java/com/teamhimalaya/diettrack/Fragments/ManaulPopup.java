package com.teamhimalaya.diettrack.Fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.teamhimalaya.diettrack.R;

import java.util.ArrayList;

/**
 * Created by gyapan on 7/3/2016.
 */
public class ManaulPopup extends AppCompatActivity {
    EditText weight1;
    EditText weight2;
    EditText weight3;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Button donBtn;
    String[] food1={"Select one","milk","sugar","bread","dal","fish","oil","potato","oat meal","rice","mango","banana","tomato","onion","chicken","pasta","kalo dal","brinjal","egg"};
    Double[] proteinVal={0.0,0.03,0.0,0.1,0.2,0.18,0.0,0.013,0.1,0.1,0.0,0.0,0.017,0.017,0.18,0.1,0.2,0.017,0.14};
    Double[] fatVal={0.0,0.03,0.0,0.026,0.023,0.14,1.0,0.0,0.026,0.026,0.0,0.0,0.002,0.002,0.14,0.026,0.023,0.002,0.14};
    Double[] calorieVal={0.0,0.59,4.0,3.30,3.33,2.0,9.0,0.8,3.33,3.33,0.6,0.6,0.28,0.28,1.98,3.33,3.33,0.286,1.7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual_diet_popup);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        initiallizeViews();
        donBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collectData();
            }
        });

    }

    private void initiallizeViews(){
        weight1=(EditText)findViewById(R.id.food1weight);
        weight2=(EditText)findViewById(R.id.food2weight);
        weight3=(EditText)findViewById(R.id.food3weight);
        spinner1=(Spinner)findViewById(R.id.food1Spinner);
        spinner2=(Spinner)findViewById(R.id.food2Spinner);
        spinner3=(Spinner)findViewById(R.id.food3Spinner);
        donBtn=(Button)findViewById(R.id.Done);

        ArrayAdapter<String> foodAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, food1);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(foodAdapter);
        ArrayAdapter<String> foodAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, food1);
        foodAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(foodAdapter1);
        ArrayAdapter<String> foodAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, food1);
        foodAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(foodAdapter2);

    }
     private void collectData(){
         ArrayList<String> food = new ArrayList<String>();
         ArrayList<Double> protein = new ArrayList<Double>();
         ArrayList<Double> calorie = new ArrayList<Double>();
         ArrayList<Double> fat = new ArrayList<Double>();
         ArrayList<Double> weightList = new ArrayList<Double>();

         String weightVal1= weight1.getText().toString();
         String weightVal2= weight2.getText().toString();
         String weightVal3= weight3.getText().toString();

         double dweightval1 = Double.parseDouble(weightVal1);
         double dweightval2 = Double.parseDouble(weightVal2);
         double dweightval3 = Double.parseDouble(weightVal3);

         food.add(food1[spinner1.getSelectedItemPosition()]);
         food.add(food1[spinner2.getSelectedItemPosition()]);
         food.add(food1[spinner3.getSelectedItemPosition()]);

         protein.add(proteinVal[spinner1.getSelectedItemPosition()]);
         protein.add(proteinVal[spinner2.getSelectedItemPosition()]);
         protein.add(proteinVal[spinner3.getSelectedItemPosition()]);

         fat.add(fatVal[spinner1.getSelectedItemPosition()]);
         fat.add(fatVal[spinner2.getSelectedItemPosition()]);
         fat.add(fatVal[spinner3.getSelectedItemPosition()]);

         calorie.add(calorieVal[spinner1.getSelectedItemPosition()]);
         calorie.add(calorieVal[spinner2.getSelectedItemPosition()]);
         calorie.add(calorieVal[spinner3.getSelectedItemPosition()]);

         weightList.add(dweightval1);
         weightList.add(dweightval2);
         weightList.add(dweightval3);

     //    ManualDiet.inflateDiet(food,fat,calorie,protein,weightList);
         food.clear();
         fat.clear();
         protein.clear();
         calorie.clear();
         weightList.clear();
     }


}