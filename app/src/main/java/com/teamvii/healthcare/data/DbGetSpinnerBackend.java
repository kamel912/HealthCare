package com.teamvii.healthcare.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_AREA_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_AREA_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_INSURANCE_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_INSURANCE_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_LANG_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_LANG_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_SPECIALITIES_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_SPECIALITIES_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_STATES_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_STATES_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_LANG;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_STATES;

/**
 * Created by ibrahim on 26/12/17.
 */

public class DbGetSpinnerBackend extends DbObject {

    private static final String TAG = DbGetSpinnerBackend.class.getSimpleName();
    Context con;
    ArrayList<String> spinnerContentgetAreaSP;
    ArrayList<String> spinnerContentgetInsuranceSP;
    ArrayList<String> spinnerContentgetSpecialtySP;
    ArrayList<String> spinnerContentgetStatesSP;
    ArrayList<String> spinnerContentgetLangSP;


    public DbGetSpinnerBackend(Context context) {
        super( context );
        this.con = context;
    }

    public String[] getAreaSP() {

        String[] allSpinner;
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        if (ff.contains( "ar" )) {
            String query = "Select * from " + TABLE_AREA + "";
            Cursor cursor = this.getDbConnection().rawQuery( query, null );
            spinnerContentgetAreaSP = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_AREA_AR ) );
                    spinnerContentgetAreaSP.add( word );
                } while (cursor.moveToNext());
            }
            cursor.close();


        } else if (ff.contains( "en" )) {
            String query = "Select * from " + TABLE_AREA + "";
            Cursor cursor = this.getDbConnection().rawQuery( query, null );
            spinnerContentgetAreaSP = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_AREA_EN ) );
                    spinnerContentgetAreaSP.add( word );
                } while (cursor.moveToNext());
            }
            Log.d( TAG, "testing_lang=:" + ff );

            cursor.close();

        }
        ;
        allSpinner = new String[spinnerContentgetAreaSP.size()];
        allSpinner = spinnerContentgetAreaSP.toArray( allSpinner );

        return allSpinner;
    }

    public String[] getSpialitySP() {

        String query = "Select * from " + TABLE_SPECIALITIES + "";
        Cursor cursor = this.getDbConnection().rawQuery( query, null );
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_SPECIALITIES_AR ) );
                spinnerContent.add( word );
            } while (cursor.moveToNext());
        }
        cursor.close();

        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray( allSpinner );

        return allSpinner;
    }

    public String[] getInsuranceSP() {
        String[] allSpinner;
        String query = "Select * from " + TABLE_INSURANCE + "";
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        if (ff.contains( "ar" )) {
            Cursor cursor = this.getDbConnection().rawQuery( query, null );
            spinnerContentgetInsuranceSP = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_INSURANCE_AR ) );
                    spinnerContentgetInsuranceSP.add( word );
                } while (cursor.moveToNext());
            }
            cursor.close();


        } else if (ff.contains( "en" )) {

            Cursor cursor = this.getDbConnection().rawQuery( query, null );
            spinnerContentgetInsuranceSP = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_INSURANCE_EN ) );
                    spinnerContentgetInsuranceSP.add( word );
                } while (cursor.moveToNext());
            }
            cursor.close();

        }


        allSpinner = new String[spinnerContentgetInsuranceSP.size()];
        allSpinner = spinnerContentgetInsuranceSP.toArray( allSpinner );

        return allSpinner;
    }


    public String[] getSpecialtySP() {

        String[] allSpinner;
        String query = "Select * from " + TABLE_SPECIALITIES + "";
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        if (ff.contains( "ar" )) {
            Cursor cursor = this.getDbConnection().rawQuery( query, null );
            spinnerContentgetSpecialtySP = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_SPECIALITIES_AR ) );
                    spinnerContentgetSpecialtySP.add( word );
                } while (cursor.moveToNext());
            }
            cursor.close();


        } else if (ff.contains( "en" )) {

            Cursor cursor = this.getDbConnection().rawQuery( query, null );
            spinnerContentgetSpecialtySP = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_SPECIALITIES_EN ) );
                    spinnerContentgetSpecialtySP.add( word );
                } while (cursor.moveToNext());
            }
            cursor.close();

        }


        allSpinner = new String[spinnerContentgetSpecialtySP.size()];
        allSpinner = spinnerContentgetSpecialtySP.toArray( allSpinner );

        return allSpinner;
    }

    public String[] getStatesSp() {
        String[] allSpinner;
        String query = "Select * from " + TABLE_STATES + "";
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        if (ff.contains( "ar" )) {
            Cursor cursor = this.getDbConnection().rawQuery( query, null );
            spinnerContentgetStatesSP = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_STATES_AR ) );
                    spinnerContentgetStatesSP.add( word );
                } while (cursor.moveToNext());
            }
            cursor.close();
            // allSpinner = new String[spinnerContentgetStatesSP.size()];
            /// allSpinner = spinnerContentgetStatesSP.toArray( allSpinner );


        } else if (ff.contains( "en" )) {

            Cursor cursor = this.getDbConnection().rawQuery( query, null );
            spinnerContentgetStatesSP = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_STATES_EN ) );
                    spinnerContentgetStatesSP.add( word );
                } while (cursor.moveToNext());
            }
            cursor.close();


        }
        allSpinner = new String[spinnerContentgetStatesSP.size()];

        allSpinner = spinnerContentgetStatesSP.toArray( allSpinner );

        return allSpinner;
    }

    public String[] getLangSp() {
        String[] allSpinner;
        String query = "Select * from " + TABLE_LANG + "";
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        if (ff.contains( "ar" )) {
            Cursor cursor = this.getDbConnection().rawQuery( query, null );
            spinnerContentgetLangSP = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_LANG_AR ) );
                    spinnerContentgetLangSP.add( word );
                } while (cursor.moveToNext());
            }
            cursor.close();


        } else if (ff.contains( "en" )) {

            Cursor cursor = this.getDbConnection().rawQuery( query, null );
            spinnerContentgetLangSP = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_LANG_EN ) );
                    spinnerContentgetLangSP.add( word );
                } while (cursor.moveToNext());
            }
            cursor.close();

        }


        allSpinner = new String[spinnerContentgetLangSP.size()];
        allSpinner = spinnerContentgetLangSP.toArray( allSpinner );

        return allSpinner;

    }
}