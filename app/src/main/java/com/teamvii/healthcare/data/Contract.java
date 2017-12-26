package com.teamvii.healthcare.data;

import android.provider.BaseColumns;

/**
 * Created by ibrahim on 19/12/17.
 */

public class Contract {
    //TODO calass for  all public trasnfer data
    public static class MashweerEntry implements BaseColumns {


        public static final String URL_SYNC_DR = "http://devsinai.com/healthcare/sync/syncDoctors.php";
        public static final String URL_SYNC_SPECIALITIES = "http://devsinai.com/healthcare/sync/syncSpecialities.php";
        public static final String URL_SYNC_AREA = "http://devsinai.com/healthcare/sync/syncArea.php";
        public static final String URL_SYNC_INSURANCE = "http://devsinai.com/healthcare/sync/syncInsurance.php";
        public static final String URL_SYNC_STATES = "http://devsinai.com/healthcare/sync/synceStates.php";


        public static final String DATABASE_NAME = "devsinai_healthcare";
        //TODO table dotor
        public static final String TABLE_DR = "doctors";
        public static final String ID_DR = "id";
        public static final String USERNAME_DR = "name";
        public static final String INSURANCE_DR = "insurance";
        public static final String GENDER_DR = "gender";
        public static final String SPECIALITY_DR = "spiciality";
        //TODO table areas
        public static final String TABLE_AREA = "areas";
        public static final String ID_AREA = "id";
        public static final String NAME_ARREA = "name";
        public static final String STAT_ID_FK = "state_id";
        //TODO table insurances
        public static final String TABLE_INSURANCE = "insurances";
        public static final String ID_INSURANCE = "id";
        public static final String NAME_INSURANCE = "name";
        //TODO table specialities
        public static final String TABLE_SPECIALITIES = "specialities";
        public static final String ID_SPECIALITIES = "id";
        public static final String NAME_SPECIALITIES = "name";
        //TODO table states
        public static final String TABLE_STATES = "states";
        public static final String ID_STATE = "id";
        public static final String NAME_STATES = "name";


    }
}
