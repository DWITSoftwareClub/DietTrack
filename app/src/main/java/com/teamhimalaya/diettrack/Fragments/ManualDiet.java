package com.teamhimalaya.diettrack.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.teamhimalaya.diettrack.R;

import java.util.ArrayList;

/**
 * Created by gyapan on 7/2/2016.
 */
public class ManualDiet extends Fragment {

    EditText weight1;
    EditText weight2;
    EditText weight3;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    TextView totCal;
    TextView totPro;
    TextView totFat;
    String weightVal1;
    String weightVal2;
    String weightVal3;
    LinearLayout totalLayer;
    Button donBtn;
    String[] food1={"Select one","milk","sugar","bread","dal","fish","oil","potato","oat meal","rice","mango","banana","tomato","onion","chicken","pasta","kalo dal","brinjal","egg"};
    Double[] proteinVal={0.0,0.03,0.0,0.1,0.2,0.18,0.0,0.013,0.1,0.1,0.0,0.0,0.017,0.017,0.18,0.1,0.2,0.017,0.14};
    Double[] fatVal={0.0,0.03,0.0,0.026,0.023,0.14,1.0,0.0,0.026,0.026,0.0,0.0,0.002,0.002,0.14,0.026,0.023,0.002,0.14};
    Double[] calorieVal={0.0,0.59,4.0,3.30,3.33,2.0,9.0,0.8,3.33,3.33,0.6,0.6,0.28,0.28,1.98,3.33,3.33,0.286,1.7};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.manual_diet_popup, null);
        weight1=(EditText)root.findViewById(R.id.food1weight);
        weight2=(EditText)root.findViewById(R.id.food2weight);
        weight3=(EditText)root.findViewById(R.id.food3weight);
        spinner1=(Spinner)root.findViewById(R.id.food1Spinner);
        spinner2=(Spinner)root.findViewById(R.id.food2Spinner);
        spinner3=(Spinner)root.findViewById(R.id.food3Spinner);
        totalLayer=(LinearLayout)root.findViewById(R.id.totalLayer);
        totCal=(TextView)root.findViewById(R.id.calTot);
        totPro=(TextView)root.findViewById(R.id.proTot);
        totFat=(TextView)root.findViewById(R.id.fatTot);
        donBtn=(Button)root.findViewById(R.id.Done);
        initiallizeView();
        donBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNdis();
            }
        });
        return root;

    }

    private void initiallizeView(){
        ArrayAdapter<String> foodAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, food1);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(foodAdapter);
        ArrayAdapter<String> foodAdapter1 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, food1);
        foodAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(foodAdapter1);
        ArrayAdapter<String> foodAdapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, food1);
        foodAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(foodAdapter2);
    }
     private void addNdis(){

         try {
              weightVal1 = weight1.getText().toString();
              weightVal2 = weight2.getText().toString();
              weightVal3 = weight3.getText().toString();

             double dweightval1 = Double.parseDouble(weightVal1);
             double dweightval2 = Double.parseDouble(weightVal2);
             double dweightval3 = Double.parseDouble(weightVal3);

             double totaLCalorie = (dweightval1*calorieVal[spinner1.getSelectedItemPosition()])+
                     (dweightval2*calorieVal[spinner2.getSelectedItemPosition()])+
                     (dweightval3*calorieVal[spinner3.getSelectedItemPosition()]);

             double totalProtien = (dweightval1*proteinVal[spinner1.getSelectedItemPosition()])+
                     (dweightval2*proteinVal[spinner2.getSelectedItemPosition()])+
                     (dweightval3*proteinVal[spinner3.getSelectedItemPosition()]);

             double totalFat = (dweightval1*proteinVal[spinner1.getSelectedItemPosition()])+
                     (dweightval2*proteinVal[spinner2.getSelectedItemPosition()])+
                     (dweightval3*proteinVal[spinner3.getSelectedItemPosition()]);
             String totalcal1=String.valueOf(totaLCalorie);
             String totalpor1=String.valueOf(totalProtien);
             String totalfat1=String.valueOf(totalFat);
             donBtn.setVisibility(View.GONE);
             totCal.setText("Calorie:"+totalcal1);
             totPro.setText("Protein:"+totalpor1);
             totFat.setText("Fat"+totalfat1);
             totalLayer.setVisibility(View.VISIBLE);
         }catch(Exception e){
             e.printStackTrace();
         }


     }
}


