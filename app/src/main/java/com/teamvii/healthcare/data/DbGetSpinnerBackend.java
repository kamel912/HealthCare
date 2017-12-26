package com.teamvii.healthcare.data;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_ARREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_STATES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_STATES;

/**
 * Created by ibrahim on 26/12/17.
 */

public class DbGetSpinnerBackend extends DbObject {

    public DbGetSpinnerBackend(Context context) {
        super( context );
    }

    public String[] getAreaSP() {

        String query = "Select * from " + TABLE_AREA + "";
        Cursor cursor = this.getDbConnection().rawQuery( query, null );
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_ARREA ) );
                spinnerContent.add( word );
            } while (cursor.moveToNext());
        }
        cursor.close();

        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray( allSpinner );

        return allSpinner;
    }

    public String[] getSpialitySP() {

        String query = "Select * from " + TABLE_SPECIALITIES + "";
        Cursor cursor = this.getDbConnection().rawQuery( query, null );
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_SPECIALITIES ) );
                spinnerContent.add( word );
            } while (cursor.moveToNext());
        }
        cursor.close();

        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray( allSpinner );

        return allSpinner;
    }

    public String[] getInsuranceSP() {

        String query = "Select * from " + TABLE_INSURANCE + "";
        Cursor cursor = this.getDbConnection().rawQuery( query, null );
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_INSURANCE ) );
                spinnerContent.add( word );
            } while (cursor.moveToNext());
        }
        cursor.close();

        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray( allSpinner );

        return allSpinner;
    }

    public String[] getSpecialtySP() {

        String query = "Select * from " + TABLE_SPECIALITIES + "";
        Cursor cursor = this.getDbConnection().rawQuery( query, null );
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_SPECIALITIES ) );
                spinnerContent.add( word );
            } while (cursor.moveToNext());
        }
        cursor.close();

        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray( allSpinner );

        return allSpinner;
    }

    public String[] getStatesSp() {

        String query = "Select * from " + TABLE_STATES + "";
        Cursor cursor = this.getDbConnection().rawQuery( query, null );
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString( cursor.getColumnIndexOrThrow( NAME_STATES ) );
                spinnerContent.add( word );
            } while (cursor.moveToNext());
        }
        cursor.close();

        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray( allSpinner );

        return allSpinner;
    }
}