package com.teamvii.healthcare.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.AREA_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.CREATED_AT_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.CREATED_AT_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.CREATED_AT_GENDER;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.CREATED_AT_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.CREATED_AT_LANG;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.CREATED_AT_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.CREATED_AT_STATES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.CREATED_AT_USER;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.DATABASE_NAME;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.GENDER_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_GENDER;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_LANG;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_STATE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.ID_USER;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.INSURANCE_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_AREA_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_AREA_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_GENDER_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_GENDER_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_INSURANCE_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_INSURANCE_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_LANG_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_LANG_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_SPECIALITIES_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_SPECIALITIES_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_STATES_AR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_STATES_EN;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.NAME_USER;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.SPECIALITY_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.STATUS_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.STAT_ID_FK;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_GENDER;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_LANG;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_STATES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.TABLE_USER;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.UBDATED_AT_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.UBDATED_AT_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.UBDATED_AT_GENDER;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.UBDATED_AT_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.UBDATED_AT_LANG;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.UBDATED_AT_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.UBDATED_AT_STATES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.UBDATED_AT_USER;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.USERNAME_DR;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.USERNAME_USER;

/**
 * Created by ibrahim on 19/12/17.
 */

public class MDbHelber extends SQLiteOpenHelper {

    private static final int SCHEMA = 1;
    private static final String TAG = MDbHelber.class.getSimpleName();
    String languaqe;
    SetLang setLang;
    Context con;


    public MDbHelber(Context context) {
        super( context, DATABASE_NAME, null, SCHEMA );
        con = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String CREATE_TB_USER =
                "CREATE TABLE " + TABLE_USER + "(" +
                        ID_USER + " INTEGER PRIMARY KEY , " +
                        NAME_USER + " VARCHAR(60) UNIQUE , " +
                        USERNAME_USER + " VARCHAR(60) UNIQUE , " +
                        CREATED_AT_USER + "  VARCHAR ," +
                        UBDATED_AT_USER + "  VARCHAR)";

        final String CREATE_TB_DOCTOR =
                "CREATE TABLE " + TABLE_DR + "(" +
                        ID_DR + " INTEGER PRIMARY KEY , " +
                        USERNAME_DR + " VARCHAR UNIQUE , " +
                        INSURANCE_DR + " VARCHAR  , " +
                        AREA_DR + " VARCHAR  , " +
                        SPECIALITY_DR + " TEXT," +
                        CREATED_AT_DR + "  VARCHAR ," +
                        UBDATED_AT_DR + "  VARCHAR, " +
                        GENDER_DR + " VARCHAR)";

        final String CREATE_TB_AREA =
                "CREATE TABLE " + TABLE_AREA + "(" +
                        ID_AREA + " INTEGER PRIMARY KEY , " +
                        NAME_AREA_AR + " VARCHAR(60) UNIQUE, " +
                        NAME_AREA_EN + " VARCHAR(60) UNIQUE, " +
                        CREATED_AT_AREA + "  VARCHAR ," +
                        UBDATED_AT_AREA + "  VARCHAR, " +
                        STAT_ID_FK + " INTEGER ," +
                        "FOREIGN KEY(" + STAT_ID_FK + ") REFERENCES " + TABLE_STATES + " (" + ID_STATE + ")" + ")";

        final String CREATE_TB_INSURANCE =
                "CREATE TABLE " + TABLE_INSURANCE + "(" +
                        ID_INSURANCE + " INTEGER PRIMARY KEY UNIQUE, " +
                        NAME_INSURANCE_AR + " VARCHAR(60) UNIQUE , " +
                        NAME_INSURANCE_EN + " VARCHAR(60) UNIQUE , " +
                        CREATED_AT_INSURANCE + "  VARCHAR ," +
                        UBDATED_AT_INSURANCE + "  VARCHAR)";

        // STATUS_INSURANCE + " TINYINT

        final String CREATE_TB_SPECIALITIES =
                "CREATE TABLE " + TABLE_SPECIALITIES + "(" +
                        ID_SPECIALITIES + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NAME_SPECIALITIES_AR + " VARCHAR(60) UNIQUE , " +
                        NAME_SPECIALITIES_EN + " VARCHAR(60) UNIQUE , " +
                        CREATED_AT_SPECIALITIES + "  VARCHAR ," +
                        UBDATED_AT_SPECIALITIES + "  VARCHAR)";

        final String CREATE_TB_STATES =
                "CREATE TABLE " + TABLE_STATES + "(" +
                        ID_STATE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NAME_STATES_AR + " VARCHAR(60) UNIQUE , " +
                        NAME_STATES_EN + " VARCHAR(60) UNIQUE , " +
                        CREATED_AT_STATES + "  VARCHAR ," +
                        UBDATED_AT_STATES + "  VARCHAR)";

        final String CREATE_TB_LANG =
                "CREATE TABLE " + TABLE_LANG + "(" +
                        ID_LANG + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NAME_LANG_AR + " VARCHAR(60) UNIQUE , " +
                        NAME_LANG_EN + " VARCHAR(60) UNIQUE , " +
                        CREATED_AT_LANG + "  VARCHAR ," +
                        UBDATED_AT_LANG + "  VARCHAR)";

        final String CREATE_TB_GENDER =
                "CREATE TABLE " + TABLE_GENDER + "(" +
                        ID_GENDER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NAME_GENDER_AR + " VARCHAR(60) UNIQUE , " +
                        NAME_GENDER_EN + " VARCHAR(60) UNIQUE , " +
                        CREATED_AT_GENDER + "  VARCHAR ," +
                        UBDATED_AT_GENDER + "  VARCHAR)";


        sqLiteDatabase.execSQL( CREATE_TB_USER );
        sqLiteDatabase.execSQL( CREATE_TB_DOCTOR );
        sqLiteDatabase.execSQL( CREATE_TB_AREA );
        sqLiteDatabase.execSQL( CREATE_TB_INSURANCE );
        sqLiteDatabase.execSQL( CREATE_TB_SPECIALITIES );
        sqLiteDatabase.execSQL( CREATE_TB_STATES );
        sqLiteDatabase.execSQL( CREATE_TB_LANG );
        sqLiteDatabase.execSQL( CREATE_TB_GENDER );

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


    public void addAreaSpinner(String id, String name) {
        setLang = new SetLang( con );
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        if (ff.contains( "ar" )) {
            values.put( ID_AREA, id );
            values.put( NAME_AREA_AR, name );
        } else if (ff.contains( "en" )) {
            values.put( ID_AREA, id );
            values.put( NAME_AREA_EN, name );
        }

        long query = db.insertWithOnConflict( TABLE_AREA, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TABLE_AREA, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add area list inserted into sqlite: " + query );
        Log.d( TAG, "testing_lang1=:" + languaqe );

        db.close();
    }

    public boolean addName(String name, int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put( NAME_AREA_AR, name );
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
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        ContentValues values = new ContentValues();
        if (ff.contains( "ar" )) {
            values.put( ID_INSURANCE, id );
            values.put( NAME_INSURANCE_AR, name );
        } else if (ff.contains( "en" )) {
            values.put( ID_INSURANCE, id );
            values.put( NAME_INSURANCE_EN, name );
        }
        long query = db.insertWithOnConflict( TABLE_INSURANCE, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TABLE_INSURANCE, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add INSURANCE list inserted into sqlite: " + query );
        db.close();
    }

    public void addStatesSpinner(String id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        ContentValues values = new ContentValues();
        if (ff.contains( "ar" )) {
            values.put( ID_INSURANCE, id );
            values.put( NAME_INSURANCE_AR, name );
        } else if (ff.contains( "en" )) {
            values.put( ID_INSURANCE, id );
            values.put( NAME_INSURANCE_EN, name );
        }
        long query = db.insertWithOnConflict( TABLE_STATES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TABLE_STATES, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add states list inserted into sqlite: " + query );
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
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        ContentValues values = new ContentValues();
        values.put( ID_SPECIALITIES, id );
        if (ff.contains( "ar" )) {
            values.put( NAME_SPECIALITIES_AR, name );
        } else if (ff.contains( "en" )) {
            values.put( NAME_SPECIALITIES_EN, name );
        }
        long query = db.insertWithOnConflict( TABLE_SPECIALITIES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TABLE_SPECIALITIES, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add specialities list inserted into sqlite: " + ff );
        db.close();
    }


    public int GetAreaID(String Dept) {
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        int val = 0;
        if (c != null && c.moveToFirst()) {
            if (ff.contains( "ar" )) {
                c = db.query( TABLE_AREA, new String[]{ID_AREA + " as id", NAME_AREA_AR},
                        NAME_AREA_AR + "=?", new String[]{Dept}, null, null, null );

            } else if (ff.contains( "en" )) {
                c = db.query( TABLE_AREA, new String[]{ID_AREA + " as id", NAME_AREA_EN},
                        NAME_AREA_EN + "=?", new String[]{Dept}, null, null, null );

            }
            c.moveToFirst();

            val = c.getInt( c.getColumnIndex( ID_AREA ) );
        }

        return val;

    }

    public int GetSpeialityID(String Dept) {
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        int val = 0;
        if (c != null && c.moveToFirst()) {
            if (ff.contains( "ar" )) {
                c = db.query( TABLE_AREA, new String[]{ID_SPECIALITIES + " as id", NAME_SPECIALITIES_AR},
                        NAME_SPECIALITIES_AR + "=?", new String[]{Dept}, null, null, null );

            } else if (ff.contains( "en" )) {
                c = db.query( TABLE_AREA, new String[]{ID_SPECIALITIES + " as id", NAME_SPECIALITIES_EN},
                        NAME_SPECIALITIES_EN + "=?", new String[]{Dept}, null, null, null );

            }

            c.moveToFirst();

            val = c.getInt( c.getColumnIndex( ID_AREA ) );
        }

        return val;
    }

    public int GetStatesID(String Dept) {
        SQLiteDatabase db = this.getReadableDatabase();
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        Cursor c = null;
        int val = 0;
        if (c != null && c.moveToFirst()) {
            if (ff.contains( "ar" )) {
                c = db.query( TABLE_STATES, new String[]{ID_STATE + " as id", NAME_STATES_AR},
                        NAME_SPECIALITIES_AR + "=?", new String[]{Dept}, null, null, null );

            } else if (ff.contains( "en" )) {
                c = db.query( TABLE_STATES, new String[]{ID_STATE + " as id", NAME_STATES_EN},
                        NAME_SPECIALITIES_EN + "=?", new String[]{Dept}, null, null, null );

            }

            c.moveToFirst();

            val = c.getInt( c.getColumnIndex( ID_AREA ) );
        }

        return val;
    }

    public int GetInsuranceID(String Dept) {
        SQLiteDatabase db = this.getReadableDatabase();
        SharedPreferences preferences = con.getSharedPreferences( "save_contents",
                MODE_PRIVATE );
        String ff = preferences.getString( "lang_key", null );
        Cursor c = null;
        int val = 0;
        if (c != null && c.moveToFirst()) {
            if (ff.contains( "ar" )) {
                c = db.query( TABLE_INSURANCE, new String[]{ID_INSURANCE + " as id", NAME_INSURANCE_AR},
                        NAME_INSURANCE_AR + "=?", new String[]{Dept}, null, null, null );

            } else if (ff.contains( "en" )) {
                c = db.query( TABLE_INSURANCE, new String[]{ID_INSURANCE + " as id", NAME_INSURANCE_EN},
                        NAME_INSURANCE_EN + "=?", new String[]{Dept}, null, null, null );

            }

            c.moveToFirst();

            val = c.getInt( c.getColumnIndex( ID_AREA ) );
        }
        return val;

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