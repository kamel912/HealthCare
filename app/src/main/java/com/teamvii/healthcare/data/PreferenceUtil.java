package com.teamvii.healthcare.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by ibrahim on 18/12/17.
 */

public class PreferenceUtil {
    public static final String DOCTOR_ID_KEY = "doctor_id";
    public static final String LANG_ID_KEY = "lang_id";
    public static final String SPECIALITY_ID_KEY = "spiciality_id";
    public static final String GENDER_ID_KEY = "gender_id";
    public static final String STATE_ID_KEY = "stat_id";
    public static final String INSURANCE_ID_KEY = "insurance_id";
    public static final String AREA_ID_KEY = "area_id";

    // Shared preferences file name
    private static final String TAG_TOKEN = "tagtoken";
    private static final String KEY_IS_USER_LOGGEDIN = "isUserLoggedIn";
    private static final String KEY_IS_DRIVER_LOGGEDIN = "isDoctorLoggedIn";
    private static final String SHARED_PREF_NAME = "save_contents";
    private static String TAG = PreferenceUtil.class.getSimpleName();
    private static PreferenceUtil mInstance;
    ///////////////////////////
    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;

///////////////////////////

    public PreferenceUtil() {
        super();
    }

    public PreferenceUtil(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences( SHARED_PREF_NAME, PRIVATE_MODE );
        editor = pref.edit();
    }

    public static void setDoctorId(Context context, String s) {
        SharedPreferences sp = context.getSharedPreferences( SHARED_PREF_NAME, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sp.edit();
        editor.putString( DOCTOR_ID_KEY, s );
        editor.commit();
        editor.apply();
    }

    public static void resetDoctorId(Context context) {
        SharedPreferences sp = context.getSharedPreferences( SHARED_PREF_NAME, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sp.edit();
        editor.remove( DOCTOR_ID_KEY );
        editor.apply();
    }

    public static String getClientId(Context context) {
        String t;
        SharedPreferences sp = context.getSharedPreferences( SHARED_PREF_NAME, Context.MODE_PRIVATE );

        return sp.getString( DOCTOR_ID_KEY, null );
    }

    /////////////
    public static void setAreaIdKey(Context context, String s) {
        SharedPreferences sp = context.getSharedPreferences( SHARED_PREF_NAME, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sp.edit();
        editor.putString( STATE_ID_KEY, s );
        editor.apply();
    }

    public static void reseAreaIdKey(Context context) {
        SharedPreferences sp = context.getSharedPreferences( SHARED_PREF_NAME, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sp.edit();
        editor.remove( AREA_ID_KEY );
        editor.apply();
    }

    public static String getAreaIdKey(Context context) {
        String t;
        SharedPreferences sp = context.getSharedPreferences( SHARED_PREF_NAME, Context.MODE_PRIVATE );

        return sp.getString( AREA_ID_KEY, null );
    }

    //TODO Notfication from firbase save Token & get Token
    public static synchronized PreferenceUtil getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new PreferenceUtil( context );
        }
        return mInstance;
    }

    ///////////////
    public void setLangIdKey(Context context, String s) {
        editor.putString( LANG_ID_KEY, s );
        editor.commit();
    }

    public void resetLangIdKey(Context context) {
        editor = pref.edit();
        editor.remove( LANG_ID_KEY );
        editor.apply();
    }

    public String getLangIdKey(Context context) {
        return pref.getString( LANG_ID_KEY, null );
    }

    //////////////
    public void setSpecialityIdKey(String s) {

        editor.putString( SPECIALITY_ID_KEY, s );

        // commit changes
        editor.commit();

        Log.d( TAG, "SpecialityIdKey session modified!" );
    }

    public void resetSpecialityIdKey(Context context) {
        editor = pref.edit();
        editor.remove( SPECIALITY_ID_KEY );
        editor.apply();
    }

    public String getSpecialityIdKey(Context context) {
        return pref.getString( SPECIALITY_ID_KEY, null );
    }

    /////////////
    public void setGenderIdKey(String s) {
        editor.putString( GENDER_ID_KEY, s );
        editor.commit();

    }

    public void resetGenderIdKey(Context context) {
        editor = pref.edit();
        editor.remove( GENDER_ID_KEY );
        editor.apply();
    }

    public String getGenderIdKey(Context context) {
        return pref.getString( GENDER_ID_KEY, null );

    }

    /////////////
    public void setStateIdKey(String s) {
        editor.putString( STATE_ID_KEY, s );
        editor.commit();

    }

    public void resetStateIdKey(Context context) {
        editor = pref.edit();
        editor.remove( STATE_ID_KEY );
        editor.apply();
    }

    public String getStateIdKey(Context context) {
        return pref.getString( STATE_ID_KEY, null );

    }

    /////////////
    public void setInsuranceIdKey(String s) {
        editor.putString( INSURANCE_ID_KEY, s );
        editor.commit();

    }

    public void resetInsuranceIdKey(Context context) {
        editor = pref.edit();
        editor.remove( INSURANCE_ID_KEY );
        editor.apply();
    }

    public String getInsuranceIdKey(Context context) {
        return pref.getString( INSURANCE_ID_KEY, null );

    }

    //TODO save loging user========
    public void setLoginUser(boolean isLoggedIn) {

        editor.putBoolean( KEY_IS_USER_LOGGEDIN, isLoggedIn );

        // commit changes
        editor.commit();

    }

    public boolean isUserLoggedIn() {
        return pref.getBoolean( KEY_IS_USER_LOGGEDIN, false );


    }

    //TODO save loging driver========
    public void setLoginDriver(boolean isLoggedIn) {

        editor.putBoolean( KEY_IS_DRIVER_LOGGEDIN, isLoggedIn );

        // commit changes
        editor.commit();

    }

    public boolean isDriverLoggedIn() {
        return pref.getBoolean( KEY_IS_DRIVER_LOGGEDIN, false );
    }

    //this method will save the device token to shared preferences
    public boolean saveDeviceToken(String token) {
        SharedPreferences sharedPreferences = _context.getSharedPreferences( SHARED_PREF_NAME, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString( TAG_TOKEN, token );
        editor.apply();
        return true;
    }

    //this method will fetch the device token from shared preferences
    public String getDeviceToken() {
        SharedPreferences sharedPreferences = _context.getSharedPreferences( SHARED_PREF_NAME, Context.MODE_PRIVATE );
        return sharedPreferences.getString( TAG_TOKEN, null );
    }
}

