package com.teamvii.healthcare.data;

import android.net.Uri;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MK on 12/26/2017.
 */

public class HealthCareContract {

    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String CONTENT_AUTHORITY = "com.teamvii.healthcare";
    public static final Uri BASE_CONTENT_URI = Uri.parse( "content://" + CONTENT_AUTHORITY );
    public static final String PATH_AREA = "area";
    public static final String PATH_GENDER = "gender";
    public static final String PATH_INSURANCE = "insurance";
    public static final String PATH_LANGUAGE = "language";
    public static final String PATH_SPECIALITY = "speciality";
    public static final String PATH_STATE = "state";

    public static List<String> TABLES_NAMES = new ArrayList<>();
    public static List<List<String>> TAMBLES_COLUMNS = new ArrayList<>();

    static {
        TABLES_NAMES.add( HealthCareContract.AreasEntry.TABLE_NAME );
        TABLES_NAMES.add( HealthCareContract.GendersEntry.TABLE_NAME );
        TABLES_NAMES.add( HealthCareContract.InsurancesEntry.TABLE_NAME );
        TABLES_NAMES.add( HealthCareContract.LanguagesEntry.TABLE_NAME );
        TABLES_NAMES.add( HealthCareContract.SpecialitiesEntry.TABLE_NAME );
        TABLES_NAMES.add( HealthCareContract.StatesEntry.TABLE_NAME );
    }

    static {
        TAMBLES_COLUMNS.add( AreasEntry.AREAS_TABLE_COLUMNS );
        TAMBLES_COLUMNS.add( GendersEntry.GENDERS_TABLE_COLUMNS );
        TAMBLES_COLUMNS.add( InsurancesEntry.INSURANCES_TABLE_COLUMNS );
        TAMBLES_COLUMNS.add( LanguagesEntry.LANGUAGES_TABLE_COLUMNS );
        TAMBLES_COLUMNS.add( SpecialitiesEntry.SPECIALITIES_TABLE_COLUMNS );
        TAMBLES_COLUMNS.add( StatesEntry.STATES_TABLE_COLUMNS );
    }

    private HealthCareContract() {
    }

    private static List<String> getColumns(String... strings) {
        List<String> columns = new ArrayList<>();
        for (String columnName : strings) {
            columns.add( columnName );
        }
        return columns;
    }

    public static final class AreasEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath( PATH_AREA )
                .build();
        public static final String TABLE_NAME = "areas";
        public static final String COLUMN_AREA_ID = "id";
        public static final String COLUMN_AREA_NAME_EN = "name_en";
        public static final String COLUMN_AREA_NAME_AR = "name_ar";
        public static final List<String> AREAS_TABLE_COLUMNS = getColumns(
                COLUMN_AREA_ID,
                COLUMN_AREA_NAME_EN,
                COLUMN_AREA_NAME_AR
        );
    }

    public static final class GendersEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath( PATH_GENDER )
                .build();
        public static final String TABLE_NAME = "genders";
        public static final String COLUMN_GENDER_ID = "id";
        public static final String COLUMN_GENDER_NAME_EN = "name_en";
        public static final String COLUMN_GENDER_NAME_AR = "name_ar";
        public static final List<String> GENDERS_TABLE_COLUMNS = getColumns(
                COLUMN_GENDER_ID,
                COLUMN_GENDER_NAME_EN,
                COLUMN_GENDER_NAME_AR
        );
    }

    public static final class InsurancesEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath( PATH_INSURANCE )
                .build();
        public static final String TABLE_NAME = "insurances";
        public static final String COLUMN_INSURANCE_ID = "id";
        public static final String COLUMN_INSURANCE_NAME_EN = "name_en";
        public static final String COLUMN_INSURANCE_NAME_AR = "name_ar";
        public static final List<String> INSURANCES_TABLE_COLUMNS = getColumns(
                COLUMN_INSURANCE_ID,
                COLUMN_INSURANCE_NAME_EN,
                COLUMN_INSURANCE_NAME_AR
        );
    }

    public static final class LanguagesEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath( PATH_LANGUAGE )
                .build();
        public static final String TABLE_NAME = "languages";
        public static final String COLUMN_LANGUAGE_ID = "id";
        public static final String COLUMN_LANGUAGE_NAME_EN = "name_en";
        public static final String COLUMN_LANGUAGE_NAME_AR = "name_ar";
        public static final List<String> LANGUAGES_TABLE_COLUMNS = getColumns(
                COLUMN_LANGUAGE_ID,
                COLUMN_LANGUAGE_NAME_EN,
                COLUMN_LANGUAGE_NAME_AR
        );
    }

    public static final class SpecialitiesEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath( PATH_SPECIALITY )
                .build();
        public static final String TABLE_NAME = "specialities";
        public static final String COLUMN_SPECIALITY_ID = "id";
        public static final String COLUMN_SPECIALITY_NAME_EN = "name_en";
        public static final String COLUMN_SPECIALITY_NAME_AR = "name_ar";
        public static final List<String> SPECIALITIES_TABLE_COLUMNS = getColumns(
                COLUMN_SPECIALITY_ID,
                COLUMN_SPECIALITY_NAME_EN,
                COLUMN_SPECIALITY_NAME_AR
        );
    }

    public static final class StatesEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath( PATH_STATE )
                .build();
        public static final String TABLE_NAME = "states";
        public static final String COLUMN_STATE_ID = "id";
        public static final String COLUMN_STATE_NAME_EN = "name_en";
        public static final String COLUMN_STATE_NAME_AR = "name_ar";
        public static final List<String> STATES_TABLE_COLUMNS = getColumns(
                COLUMN_STATE_ID,
                COLUMN_STATE_NAME_EN,
                COLUMN_STATE_NAME_AR
        );
    }

}