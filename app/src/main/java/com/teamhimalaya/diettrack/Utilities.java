package com.teamhimalaya.diettrack;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by gyapan on 7/2/2016.
 */
public class Utilities {
    static String curUsername;
    static String curUserID;
    static String curPassword;
    static String curEmail;
    static String age;
    static String height;
    static String weight;
    static String gender;
    static String geoGarphy;
    static String activity;


    public static void registerDetail(String Namer,String userid,String email,String password, Context c) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("USERNAME", Namer);
        curUsername = Namer;

        editor.putString("USERID", userid);
        curUserID = userid;

        editor.putString("PASSWORD", password);
        curPassword = password;

        editor.putString("EMAIL", email);
        curEmail = email;

        editor.commit();//save the prefernce file

    }

    public static String getCurUserID(Context c) {
        if (curUserID == null) {
            SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(c);
            curUserID = s.getString("USERID", "");
        }
        return curUserID;
    }
    public static String getCurUsername(Context c) {
        if (curUsername == null) {
            SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(c);
            curUsername = s.getString("USERNAME", "");
        }
        return curUsername;
    }
    public static String getCurPassword(Context c) {
        if (curPassword == null) {
            SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(c);
            curPassword = s.getString("PASSWORD", "");
        }
        return curPassword;
    }
    public static String getCurEmail(Context c) {
        if (curEmail == null) {
            SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(c);
            curEmail = s.getString("EMAIL", "");
        }
        return curEmail;

    }

    public static void personalDetail(String agei,String heighti,String weighti,String genderi,String geoGraphyi,String Activityi, Context c) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("AGE", agei);
        age = agei;

        editor.putString("HEIGHT", heighti);
        height = heighti;

        editor.putString("WEIGHT", weighti);
        weight = weighti;

        editor.putString("GENDER", genderi);
        gender = genderi;

        editor.putString("GEOGRAPHY", geoGraphyi);
        geoGarphy = geoGraphyi;

        editor.putString("ACTIVITY", Activityi);
        activity = Activityi;

        editor.commit();//save the prefernce file

    }
    public static String getAge(Context c) {
        if (age == null) {
            SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(c);
            age = s.getString("AGE", "");
        }
        return age;
    }
    public static String getHeight(Context c) {
        if (height == null) {
            SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(c);
            height = s.getString("HEIGHT", "");
        }
        return height;
    }
    public static String getWeight(Context c) {
        if (weight == null) {
            SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(c);
            weight = s.getString("WEIGHT", "");
        }
        return weight;
    }
    public static String getGender(Context c) {
        if (gender == null) {
            SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(c);
            gender = s.getString("GENDER", "");
        }
        return gender;
    }
    public static String getGeoGarphy(Context c) {
        if (geoGarphy == null) {
            SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(c);
            geoGarphy = s.getString("GEOGRAPHY", "");
        }
        return geoGarphy;
    }
    public static String getActivity(Context c) {
        if (activity == null) {
            SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(c);
            activity = s.getString("ACIVITY", "");
        }
        return activity;
    }
    public static void logout(Context c) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor editor = pref.edit();

        editor.remove("USERID");
        editor.remove("USERNAMER");
        editor.remove("EMAIL");
        editor.remove("PASSWORD");
        editor.remove("AGE");
        editor.remove("HEIGHT");
        editor.remove("WEIGHT");
        editor.remove("GENDER");
        editor.remove("GEOGRAPHY");
        editor.remove("ACTIVITY");
        editor.clear();
        Log.d("Clearcache:",pref.getString("USERID",""));

        editor.commit();//save the prefernce file
    }
}
