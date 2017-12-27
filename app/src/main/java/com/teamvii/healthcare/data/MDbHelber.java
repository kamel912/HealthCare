package com.teamvii.healthcare.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.teamvii.healthcare.data.Contract.MashweerEntry.DATABASE_NAME;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.GENDER_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_STATE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.INSURANCE_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_ARREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_STATES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.SPECIALITY_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.STATUS_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.STAT_ID_FK;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_STATES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.USERNAME_DR;

/**
 * Created by ibrahim on 19/12/17.
 */

public class MDbHelber extends SQLiteOpenHelper {

    private static final int SCHEMA = 1;
    private static final String TAG = MDbHelber.class.getSimpleName();

    public MDbHelber(Context context) {
        super( context, DATABASE_NAME, null, SCHEMA );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //TODO creating table of DR
        final String CREATE_TB_DOCTOR =
                "CREATE TABLE " + TABLE_DR + "(" +
                        ID_DR + " INTEGER PRIMARY KEY , " +
                        USERNAME_DR + " VARCHAR(60) UNIQUE , " +
                        INSURANCE_DR + " VARCHAR(100) UNIQUE , " +
                        // STATUS_DR + " TINYINT,"+
                        SPECIALITY_DR + " TEXT," +
                        GENDER_DR + " VARCHAR(10))";

        final String CREATE_TB_AREA =
                "CREATE TABLE " + TABLE_AREA + "(" +
                        ID_AREA + " INTEGER PRIMARY KEY , " +
                        NAME_ARREA + " VARCHAR(60) UNIQUE, " +
                        // STATUS_AREA + " TINYINT,"+
                        STAT_ID_FK + " INTEGER ," +
                        "FOREIGN KEY(" + STAT_ID_FK + ") REFERENCES " + TABLE_STATES + " (" + ID_STATE + ")" + ")";

        final String CREATE_TB_INSURANCE =
                "CREATE TABLE " + TABLE_INSURANCE + "(" +
                        ID_INSURANCE + " INTEGER PRIMARY KEY UNIQUE, " +
                        NAME_INSURANCE + " VARCHAR(10) UNIQUE);";
        // STATUS_INSURANCE + " TINYINT

        final String CREATE_TB_SPECIALITIES =
                "CREATE TABLE " + TABLE_SPECIALITIES + "(" +
                        ID_SPECIALITIES + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NAME_SPECIALITIES + " VARCHAR(10) UNIQUE" +
                        // STATUS_SPECIALITIES + " TINYINT" +
                        ");";

        final String CREATE_TB_STATES =
                "CREATE TABLE " + TABLE_STATES + "(" +
                        ID_STATE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NAME_STATES + " VARCHAR(10) UNIQUE" +
                        // STATUS_STATES + " TINYINT" +
                        ");";

        sqLiteDatabase.execSQL( CREATE_TB_DOCTOR );
        sqLiteDatabase.execSQL( CREATE_TB_AREA );
        sqLiteDatabase.execSQL( CREATE_TB_INSURANCE );
        sqLiteDatabase.execSQL( CREATE_TB_SPECIALITIES );
        sqLiteDatabase.execSQL( CREATE_TB_STATES );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        throw new UnsupportedOperationException( "This shouldn't happen yet!" );

    }

    //TODO work with TABLE_DOCTOR data====================================================
    public void addDoctorForSpinner(String id, String name, String gender) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( ID_DR, id );
        values.put( USERNAME_DR, name );
        values.put( GENDER_DR, gender );

        long query = db.insertWithOnConflict( TABLE_DR, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        db.insertWithOnConflict( TABLE_DR, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add doctor list inserted into sqlite: " + query );
        db.close();
    }


    public HashMap<String, String> getDoctorDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_DR;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( selectQuery, null );
        cursor.moveToFirst();
        if (cursor.getCount() >= 0) {
            user.put( "id", cursor.getString( 1 ) );
            user.put( "name", cursor.getString( 2 ) );
            user.put( "uid", cursor.getString( 3 ) );
            user.put( "time", cursor.getString( 4 ) );
        }
        cursor.close();
        db.close();
        Log.d( TAG, "Fetching doctor from Sqlite: " + user.toString() );

        return user;
    }

    //TODO work with All Spinner data methods =============================================================
    //TODO With spinner area
    public void addAreaSpinner(String id, String name, String state) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( ID_AREA, id );
        values.put( NAME_ARREA, name );
        values.put( STAT_ID_FK, state );

        long query = db.insertWithOnConflict( TABLE_AREA, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TABLE_AREA, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add area list inserted into sqlite: " + query );
        db.close();
    }

    public boolean addName(String name, int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put( NAME_ARREA, name );
        contentValues.put( STATUS_AREA, status );


        db.insert( TABLE_AREA, null, contentValues );
        db.close();
        return true;
    }

    public boolean updateAreaStatus(int id, int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( STATUS_AREA, status );
        db.update( TABLE_AREA, contentValues, ID_AREA + "=" + id, null );
        db.close();
        return true;
    }

    public List<String> getARea() {
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_AREA;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( selectQuery, null );

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add( cursor.getString( 1 ) );
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }


    public HashMap<String, String> getAreaSpinner() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_AREA;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( selectQuery, null );
        cursor.moveToFirst();
        if (cursor.getCount() >= 0) {
            user.put( "id", cursor.getString( 0 ) );
            user.put( "name", cursor.getString( 1 ) );
            user.put( "state_id", cursor.getString( 2 ) );
        }
        cursor.close();
        db.close();
        Log.d( TAG, "Fetching area from Sqlite: " + user.toString() );

        return user;
    }

    //TODO With spinner insurances
    public void addInsurancesSpinner(String id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( ID_INSURANCE, id );
        values.put( NAME_INSURANCE, name );

        long query = db.insertWithOnConflict( TABLE_INSURANCE, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TABLE_INSURANCE, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add INSURANCE list inserted into sqlite: " + query );
        db.close();
    }

    public HashMap<String, String> getInsurancesSpinner() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_INSURANCE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( selectQuery, null );
        cursor.moveToFirst();
        if (cursor.getCount() >= 0) {
            user.put( "id", cursor.getString( 0 ) );
            user.put( "name", cursor.getString( 1 ) );
        }
        cursor.close();
        db.close();
        Log.d( TAG, "Fetching INSURANCE from Sqlite: " + user.toString() );

        return user;
    }

    //TODO With spinner specialities
    public void addSpecialitiesSpinner(String id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( ID_SPECIALITIES, id );
        values.put( NAME_SPECIALITIES, name );

        long query = db.insertWithOnConflict( TABLE_SPECIALITIES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TABLE_SPECIALITIES, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add specialities list inserted into sqlite: " + query );
        db.close();
    }

    public String fetchFromAِrae(String inputText) throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor row = null;
        String query = "SELECT * FROM " + TABLE_AREA;
        if (inputText == null || inputText.length() == 0) {
            row = db.rawQuery( query, null );
        } else {
            query = "SELECT " + ID_AREA + " FROM areas WHERE name  ='" + inputText + "'";
            row = db.rawQuery( query, null );
        }
        if (row != null) {
            row.moveToFirst();
        }
        Log.d( "jjjjjj", String.valueOf( row ) );

        return null;
    }

    public int GetDeptID(String Dept) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query( TABLE_AREA, new String[]{ID_AREA + " as id", NAME_ARREA},
                NAME_ARREA + "=?", new String[]{Dept}, null, null, null );
        //Cursor c=db.rawQuery("SELECT "+colDeptID+" as _id FROM "+deptTable+"
        //WHERE "+colDeptName+"=?", new String []{Dept});
        c.moveToFirst();
        return c.getInt( c.getColumnIndex( ID_AREA ) );
    }

    public HashMap<String, String> getSpecialitiesSpinner() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_INSURANCE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( selectQuery, null );
        cursor.moveToFirst();
        if (cursor.getCount() >= 0) {
            user.put( "id", cursor.getString( 0 ) );
            user.put( "name", cursor.getString( 1 ) );
        }
        cursor.close();
        db.close();
        Log.d( TAG, "Fetching specialities from Sqlite: " + user.toString() );

        return user;
    }

    //TODO With spinner states
    public void addStatesSpinner(String id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( ID_STATE, id );
        values.put( NAME_STATES, name );

        long query = db.insertWithOnConflict( TABLE_STATES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TABLE_STATES, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add states list inserted into sqlite: " + query );
        db.close();
    }

    public HashMap<String, String> getStatesSpinner() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_STATES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( selectQuery, null );
        cursor.moveToFirst();
        if (cursor.getCount() >= 0) {
            user.put( "id", cursor.getString( 0 ) );
            user.put( "name", cursor.getString( 1 ) );
        }
        cursor.close();
        db.close();
        Log.d( TAG, "Fetching states from Sqlite: " + user.toString() );

        return user;
    }
}