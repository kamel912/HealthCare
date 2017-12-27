package com.teamvii.healthcare.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by MK on 12/26/2017.
 */

public class HealthCareProvider extends ContentProvider {
    public static final int CODE_AREA = 100;
    public static final int CODE_GENDER = 200;
    public static final int CODE_INSURANCE = 300;
    public static final int CODE_LANGUAGE = 400;
    public static final int CODE_SPECIALITY = 500;
    public static final int CODE_STATE = 600;
    public static final int CODE_AREA_WITH_ID = 101;
    public static final int CODE_GENDER_WITH_ID = 201;
    public static final int CODE_INSURANCE_WITH_ID = 301;
    public static final int CODE_LANGUAGE_WITH_ID = 401;
    public static final int CODE_SPECIALITY_WITH_ID = 501;
    public static final int CODE_STATE_WITH_ID = 601;
    public static final List<Integer> TABLES_CODES = new ArrayList<>();
    public static final List<Integer> TABLES_CODES_WITH_ID = new ArrayList<>();
    public static UriMatcher matcher = buildUriMatcher();

    static {
        TABLES_CODES.add(CODE_AREA);
        TABLES_CODES.add(CODE_GENDER);
        TABLES_CODES.add(CODE_INSURANCE);
        TABLES_CODES.add(CODE_LANGUAGE);
        TABLES_CODES.add(CODE_SPECIALITY);
        TABLES_CODES.add(CODE_STATE);
    }

    static {
        TABLES_CODES.add(CODE_AREA_WITH_ID);
        TABLES_CODES.add(CODE_GENDER_WITH_ID);
        TABLES_CODES.add(CODE_INSURANCE_WITH_ID);
        TABLES_CODES.add(CODE_LANGUAGE_WITH_ID);
        TABLES_CODES.add(CODE_SPECIALITY_WITH_ID);
        TABLES_CODES.add(CODE_STATE_WITH_ID);
    }

    HealthCareDbHelper mDbHelper;

    public static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        for (int i = 0; i < HealthCareContract.TABLES_NAMES.size(); i++) {
            String TABLE_NAME = HealthCareContract.TABLES_NAMES.get(i);
            Integer TABLE_CODE = TABLES_CODES.get(i);
            Integer TABLE_CODE_WITH_ID = TABLES_CODES_WITH_ID.get(i);
            uriMatcher.addURI(HealthCareContract.CONTENT_AUTHORITY, TABLE_NAME, TABLE_CODE);
            uriMatcher.addURI(HealthCareContract.CONTENT_AUTHORITY, TABLE_NAME + "/#", TABLE_CODE_WITH_ID);
        }
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        mDbHelper = new HealthCareDbHelper(context);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selections, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        int match = matcher.match(uri);
        Cursor mCursor = null;
        String mSortOrder, id;
        String[] mSelectionArgs, mColumns = new String[]{
                "id",
                "name_" + Locale.getDefault().getLanguage()
        };
        switch (match) {
            case CODE_AREA:
                mSortOrder = HealthCareContract.AreasEntry.COLUMN_AREA_ID + " ASC";
                mCursor = sqLiteDatabase.query(HealthCareContract.AreasEntry.TABLE_NAME, mColumns, null, null, null, null, mSortOrder);
                break;
            case CODE_AREA_WITH_ID:
                id = uri.getPathSegments().get(1);
                mSelectionArgs = new String[]{id};
                mCursor = sqLiteDatabase.query(HealthCareContract.AreasEntry.TABLE_NAME, null, "id=?", mSelectionArgs, null, null, null);
                break;
            case CODE_GENDER:
                mSortOrder = HealthCareContract.GendersEntry.COLUMN_GENDER_ID + " ASC";
                mCursor = sqLiteDatabase.query(HealthCareContract.GendersEntry.TABLE_NAME, mColumns, null, null, null, null, mSortOrder);
                break;
            case CODE_GENDER_WITH_ID:
                id = uri.getPathSegments().get(1);
                mSelectionArgs = new String[]{id};
                mCursor = sqLiteDatabase.query(HealthCareContract.GendersEntry.TABLE_NAME, null, "id=?", mSelectionArgs, null, null, null);
                break;
            case CODE_INSURANCE:
                mSortOrder = HealthCareContract.InsurancesEntry.COLUMN_INSURANCE_ID + " ASC";
                mCursor = sqLiteDatabase.query(HealthCareContract.InsurancesEntry.TABLE_NAME, mColumns, null, null, null, null, mSortOrder);
                break;
            case CODE_INSURANCE_WITH_ID:
                id = uri.getPathSegments().get(1);
                mSelectionArgs = new String[]{id};
                mCursor = sqLiteDatabase.query(HealthCareContract.InsurancesEntry.TABLE_NAME, null, "id=?", mSelectionArgs, null, null, null);
                break;
            case CODE_LANGUAGE:
                mSortOrder = HealthCareContract.LanguagesEntry.COLUMN_LANGUAGE_ID + " ASC";
                mCursor = sqLiteDatabase.query(HealthCareContract.LanguagesEntry.TABLE_NAME, mColumns, null, null, null, null, mSortOrder);
                break;
            case CODE_LANGUAGE_WITH_ID:
                id = uri.getPathSegments().get(1);
                mSelectionArgs = new String[]{id};
                mCursor = sqLiteDatabase.query(HealthCareContract.LanguagesEntry.TABLE_NAME, null, "id=?", mSelectionArgs, null, null, null);
                break;
            case CODE_SPECIALITY:
                mSortOrder = HealthCareContract.SpecialitiesEntry.COLUMN_SPECIALITY_ID + " ASC";
                mCursor = sqLiteDatabase.query(HealthCareContract.SpecialitiesEntry.TABLE_NAME, mColumns, null, null, null, null, mSortOrder);
                break;
            case CODE_SPECIALITY_WITH_ID:
                id = uri.getPathSegments().get(1);
                mSelectionArgs = new String[]{id};
                mCursor = sqLiteDatabase.query(HealthCareContract.SpecialitiesEntry.TABLE_NAME, null, "id=?", mSelectionArgs, null, null, null);
                break;
            case CODE_STATE:
                mSortOrder = HealthCareContract.StatesEntry.COLUMN_STATE_ID + " ASC";
                mCursor = sqLiteDatabase.query(HealthCareContract.StatesEntry.TABLE_NAME, mColumns, null, null, null, null, mSortOrder);
                break;
            case CODE_STATE_WITH_ID:
                id = uri.getPathSegments().get(1);
                mSelectionArgs = new String[]{id};
                mCursor = sqLiteDatabase.query(HealthCareContract.StatesEntry.TABLE_NAME, null, "id=?", mSelectionArgs, null, null, null);
                break;
        }
        mCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return mCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        SQLiteDatabase sqLiteDatabase = mDbHelper.getWritableDatabase();
        int match = matcher.match(uri);
        int rowsInserted = 0;
        switch (match) {
            case CODE_AREA:
                sqLiteDatabase.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = sqLiteDatabase.insert(HealthCareContract.AreasEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            rowsInserted++;
                        }
                    }
                    sqLiteDatabase.setTransactionSuccessful();
                } finally {
                    sqLiteDatabase.endTransaction();
                }
                if (rowsInserted > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return rowsInserted;
            case CODE_GENDER:
                sqLiteDatabase.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = sqLiteDatabase.insert(HealthCareContract.GendersEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            rowsInserted++;
                        }
                    }
                    sqLiteDatabase.setTransactionSuccessful();
                } finally {
                    sqLiteDatabase.endTransaction();
                }
                if (rowsInserted > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return rowsInserted;
            case CODE_INSURANCE:
                sqLiteDatabase.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = sqLiteDatabase.insert(HealthCareContract.InsurancesEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            rowsInserted++;
                        }
                    }
                    sqLiteDatabase.setTransactionSuccessful();
                } finally {
                    sqLiteDatabase.endTransaction();
                }
                if (rowsInserted > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return rowsInserted;
            case CODE_LANGUAGE:
                sqLiteDatabase.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = sqLiteDatabase.insert(HealthCareContract.LanguagesEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            rowsInserted++;
                        }
                    }
                    sqLiteDatabase.setTransactionSuccessful();
                } finally {
                    sqLiteDatabase.endTransaction();
                }
                if (rowsInserted > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return rowsInserted;
            case CODE_SPECIALITY:
                sqLiteDatabase.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = sqLiteDatabase.insert(HealthCareContract.SpecialitiesEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            rowsInserted++;
                        }
                    }
                    sqLiteDatabase.setTransactionSuccessful();
                } finally {
                    sqLiteDatabase.endTransaction();
                }
                if (rowsInserted > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return rowsInserted;
            case CODE_STATE:
                sqLiteDatabase.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = sqLiteDatabase.insert(HealthCareContract.StatesEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            rowsInserted++;
                        }
                    }
                    sqLiteDatabase.setTransactionSuccessful();
                } finally {
                    sqLiteDatabase.endTransaction();
                }
                if (rowsInserted > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return rowsInserted;
            default:
                return super.bulkInsert(uri, values);
        }

    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int numRowsDeleted;
        if (null == selection) selection = "1";
        int match = matcher.match(uri);
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
