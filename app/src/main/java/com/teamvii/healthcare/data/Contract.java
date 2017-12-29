package com.teamvii.healthcare.data;

import android.provider.BaseColumns;


/**
 * Created by ibrahim on 19/12/17.
 */

public class Contract {


    public static class MashweerEntry implements BaseColumns {

        public static final String URL_SYNC = "http://devsinai.com/healthcare/";


        public static final String URL_SYNC_DR = "http://devsinai.com/healthcare/sync/syncDoctors.php";
        public static final String URL_SYNC_SPECIALITIES = "/specialities.php";
        //
        public static final String URL_SYNC_AREA = "/areas.php";//
        public static final String URL_SYNC_INSURANCE = "/insurances.php";
        public static final String URL_SYNC_STATES = "/states.php";//
        public static final String URL_SYNC_GENDER = "/genders.php";//
        public static final String URL_SYNC_LANG = "/languages.php";//


        public static final String DATABASE_NAME = "devsinai_healthcare";

        public static final String TABLE_USER = "users";
        public static final String ID_USER = "id";
        public static final String NAME_USER = "name";
        public static final String USERNAME_USER = "username";
        // public static final String PASSWORD_USER = "password";
        public static final String TOKEN_USER = "remember_token";
        public static final String CREATED_AT_USER = "created_at";
        public static final String UBDATED_AT_USER = "updated_at";


        public static final String TABLE_DR = "doctors";
        public static final String ID_DR = "id";
        public static final String USERNAME_DR = "name";
        public static final String INSURANCE_DR = "insurance";
        public static final String GENDER_DR = "gender";
        public static final String AREA_DR = "area_id";
        public static final String SPECIALITY_DR = "spiciality";
        public static final String STATUS_DR = "status_doctor";
        public static final String CREATED_AT_DR = "created_at";
        public static final String UBDATED_AT_DR = "updated_at";


        public static final String TABLE_AREA = "areas";
        public static final String ID_AREA = "id";
        public static final String NAME_AREA_AR = "name_ar";
        public static final String NAME_AREA_EN = "name_en";
        public static final String STAT_ID_FK = "state_id";
        public static final String STATUS_AREA = "status_area";
        public static final String CREATED_AT_AREA = "created_at";
        public static final String UBDATED_AT_AREA = "updated_at";

        public static final String TABLE_INSURANCE = "insurances";
        public static final String ID_INSURANCE = "id";
        public static final String NAME_INSURANCE_AR = "name_ar";
        public static final String NAME_INSURANCE_EN = "name_en";
        public static final String STATUS_INSURANCE = "status_insurances";
        public static final String CREATED_AT_INSURANCE = "created_at";
        public static final String UBDATED_AT_INSURANCE = "updated_at";

        public static final String TABLE_SPECIALITIES = "specialities";
        public static final String ID_SPECIALITIES = "id";
        public static final String NAME_SPECIALITIES_AR = "name_ar";
        public static final String NAME_SPECIALITIES_EN = "name_en";
        public static final String STATUS_SPECIALITIES = "status_specialities";
        public static final String CREATED_AT_SPECIALITIES = "created_at";
        public static final String UBDATED_AT_SPECIALITIES = "updated_at";


        public static final String TABLE_STATES = "states";
        public static final String ID_STATE = "id";
        public static final String NAME_STATES_AR = "name_ar";
        public static final String NAME_STATES_EN = "name_en";
        public static final String STATUS_STATES = "status_states";
        public static final String CREATED_AT_STATES = "created_at";
        public static final String UBDATED_AT_STATES = "updated_at";


        public static final String TABLE_LANG = "languages";
        public static final String ID_LANG = "id";
        public static final String NAME_LANG_AR = "name_ar";
        public static final String NAME_LANG_EN = "name_en";
        public static final String CREATED_AT_LANG = "created_at";
        public static final String UBDATED_AT_LANG = "updated_at";

        public static final String TABLE_GENDER = "genders";
        public static final String ID_GENDER = "id";
        public static final String NAME_GENDER_AR = "name_ar";
        public static final String NAME_GENDER_EN = "name_en";
        public static final String CREATED_AT_GENDER = "created_at";
        public static final String UBDATED_AT_GENDER = "updated_at";




    }
}
