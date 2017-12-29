package com.teamvii.healthcare.sync;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * Created by ibrahim on 29/12/17.
 */
//TODO 4 اخر حاجه الكلاس اللي يقوم بعمل شيك علي البيانات بشكل صحيح
public class HealthCareSyncUtils {
    private static boolean sInitialized;


    synchronized public static void initialize(@NonNull final Context context) {

//      COMPLETED (3) Only execute this method body if sInitialized is false
        /*
         * Only perform initialization once per app lifetime. If initialization has already been
         * performed, we have nothing to do in this method.
         */
        if (sInitialized) return;

//      COMPLETED (4) If the method body is executed, set sInitialized to true
        sInitialized = true;

//      COMPLETED (5) Check to see if our weather ContentProvider is empty
        /*
         * We need to check to see if our ContentProvider has data to display in our forecast
         * list. However, performing a query on the main thread is a bad idea as this may
         * cause our UI to lag. Therefore, we create a thread in which we will run the query
         * to check the contents of our ContentProvider.
         */
        new AsyncTask<Void, Void, Void>() {
            @Override
            public Void doInBackground(Void... voids) {

             /*   *//* URI for every row of weather data in our weather table*//*
                Uri QueryUri = HealthCareContract.AreasEntry.CONTENT_URI;

                *//*
                 * Since this query is going to be used only as a check to see if we have any
                 * data (rather than to display data), we just need to PROJECT the ID of each
                 * row. In our queries where we display data, we need to PROJECT more columns
                 * to determine what weather details need to be displayed.
                 *//*
                String[] projectionColumns = {HealthCareContract.AreasEntry._ID};
              //  String selectionStatement =HealthCareContract.AreasEntry();

                *//* Here, we perform the query to check to see if we have any weather data *//*
                Cursor cursor = context.getContentResolver().query(
                        QueryUri,
                        projectionColumns,
                        selectionStatement,
                        null,
                        null);
                *//*
                 * A Cursor object can be null for various different reasons. A few are
                 * listed below.
                 *
                 *   1) Invalid URI
                 *   2) A certain ContentProvider's query method returns null
                 *   3) A RemoteException was thrown.
                 *
                 * Bottom line, it is generally a good idea to check if a Cursor returned
                 * from a ContentResolver is null.
                 *
                 * If the Cursor was null OR if it was empty, we need to sync immediately to
                 * be able to display data to the user.
                 *//*
                //  COMPLETED (6) If it is empty or we have a null Cursor, sync the weather now!
                if (null == cursor || cursor.getCount() == 0) {
                    startImmediateSync(context);
                }

                *//* Make sure to close the Cursor to avoid memory leaks! *//*
                cursor.close();*/
                return null;
            }
        }.execute();
    }

    public static void startImmediateSync(@NonNull final Context context) {
//      COMPLETED (11) Within that method, start the SunshineSyncIntentService
        Intent intentToSyncImmediately = new Intent( context, HealthCareSyncIntentService.class );
        context.startService( intentToSyncImmediately );
    }
}
