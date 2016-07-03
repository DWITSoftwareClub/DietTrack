package com.teamhimalaya.diettrack.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;

import com.teamhimalaya.diettrack.R;
import com.teamhimalaya.diettrack.Utilities;

/**
 * Created by gyapan on 7/3/2016.
 */
public class Recommendation extends Fragment {
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.recommendation, null);
        imageView = (ImageView)root.findViewById(R.id.imageRecommendation);
        setImageView();
        return root;
    }

    private void setImageView(){
        try{
        String weight = Utilities.getWeight(getActivity());
        String height = Utilities.getHeight(getActivity());
        String age = Utilities.getAge(getActivity());
        if(!weight.isEmpty() && !height.isEmpty() && !age.isEmpty()){
            double dweight = Double.parseDouble(weight);
            double dheight = Double.parseDouble(height);
            double dage = Double.parseDouble(age);
            double bmR;
            String Gender = Utilities.getGender(getActivity());
            String GeoReason=Utilities.getGeoGarphy(getActivity());
                    ;
            if(Gender.equals("Male")){
                Log.d("Gender",Gender);
                    bmR = 66.47+ (13.75 * dweight) + (5.0 * dheight) - (6.75 * dage);
                    if(500<bmR && bmR<2500){
                        Log.d("BMR male:",String.valueOf(bmR));
                        Log.d("Geo:",GeoReason);
                        if(GeoReason.equals("Himalayan")){

                            imageView.setImageResource(R.drawable.mountain_1);
                        }else if(GeoReason.equals("Hilly")){
                            imageView.setImageResource(R.drawable.hilly_1);
                        }else if(GeoReason.equals("Terai")){
                            imageView.setImageResource(R.drawable.terai_1);
                        }else{
                            imageView.setImageResource(R.drawable.personal_info_error);
                        }

                    }else{
                        if(GeoReason.equals("Himalayan")){
                            imageView.setImageResource(R.drawable.mountain_2);
                        }else if(GeoReason.equals("Hilly")){
                            imageView.setImageResource(R.drawable.hilly_2);
                        }else if(GeoReason.equals("Terai")){
                            imageView.setImageResource(R.drawable.terai_2);
                        }else{
                            imageView.setImageResource(R.drawable.personal_info_error);
                        }
                    }


            }else if(Gender.equals("Female")){
                Log.d("Gender",Gender);
                   bmR= 665.09 + (9.56 *dweight) + (1.84 *dheight) - (4.67 *dage);
                    if(500<bmR && bmR<2500){
                        Log.d("BMR female:",String.valueOf(bmR));
                        Log.d("Geo:",GeoReason);
                        if(GeoReason.equals("Himalayan")){
                            imageView.setImageResource(R.drawable.mountain_1);
                        }else if(GeoReason.equals("Hilly")){
                            imageView.setImageResource(R.drawable.hilly_1);
                        }else if(GeoReason.equals("Terai")){
                            imageView.setImageResource(R.drawable.terai_1);
                        }else{
                            imageView.setImageResource(R.drawable.personal_info_error);
                        }
                    }else{
                        if(GeoReason.equals("Himalayan")){
                            imageView.setImageResource(R.drawable.mountain_2);
                        }else if(GeoReason.equals("Hilly")){
                            imageView.setImageResource(R.drawable.hilly_2);
                        }else if(GeoReason.equals("Terai")){
                            imageView.setImageResource(R.drawable.terai_2);
                        }else{
                            imageView.setImageResource(R.drawable.personal_info_error);
                        }
                    }


            }

        }else{

                imageView.setImageResource(R.drawable.personal_info_error);


        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
