package com.teamvii.healthcare.sync;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.teamvii.healthcare.data.HealthCareContract;

import java.util.concurrent.TimeUnit;

/**
 * Created by ibrahim on 29/12/17.
 */
//TODO 4 from class HealthCareSyncIntentService
public class HealthCareSyncUtils {


    private static final int SYNC_INTERVAL_HOURS = 3;
    private static final int SYNC_INTERVAL_SECONDS = (int) TimeUnit.HOURS.toSeconds( SYNC_INTERVAL_HOURS );
    private static final int SYNC_FLEXTIME_SECONDS = SYNC_INTERVAL_SECONDS / 3;
    private static final String SUNSHINE_SYNC_TAG = "Health_care_sync";
    private static RequestQueue requestQueue;
    private static boolean sInitialized;

    //TODO 5
    synchronized public static void initialize(@NonNull final Context context) {


        if (sInitialized) return;

        sInitialized = true;

        // scheduleFirebaseJobDispatcherSync(context);

        Thread checkForEmpty = new Thread( new Runnable() {
            @Override
            public void run() {

                //هنا شغلت الفولي مباشرة للعمل عليها مرقتا حتي يتم جلب
                //  HealthCareSyncData.syncSpinner( context );


                //ام يتم العمل عليها بعد

                Uri InsuranceQueryUri = HealthCareContract.InsurancesEntry.CONTENT_URI;
                String[] projectionColumnsInsurance = {HealthCareContract.InsurancesEntry._ID};
                String selectionStatementInsurance = HealthCareContract.InsurancesEntry
                        .getSqlSelectLang( context );


                Cursor cursorInsurance = context.getContentResolver().query(
                        InsuranceQueryUri,
                        projectionColumnsInsurance,
                        selectionStatementInsurance,
                        null,
                        null);
                Log.d( "InsuranceQueryUri", String.valueOf( InsuranceQueryUri ) );

                Log.d( "InsuranceQueryUri", String.valueOf( projectionColumnsInsurance ) );
                Log.d( "InsuranceQueryUri", String.valueOf( selectionStatementInsurance ) );

                ///////////////////////////
                Uri AreasQueryUri = HealthCareContract.AreasEntry.CONTENT_URI;
                String[] projectionColumnsAreas = {HealthCareContract.AreasEntry._ID};
                // String selectionStatementAreas = new HealthCareContract.AreasEntry(null);


                Cursor cursorArea = context.getContentResolver().query(
                        AreasQueryUri,
                        projectionColumnsAreas,
                        //   selectionStatementAreas,
                        null,
                        null,
                        null );
                Log.d( "AreasQueryUri", String.valueOf( AreasQueryUri ) );

                Log.d( "AreasQueryUri", String.valueOf( projectionColumnsAreas ) );
                // Log.d( "AreasQueryUri", String.valueOf( selectionStatementAreas ) );

                /////////////////////////////
              /* Uri StatesueryUri = HealthCareContract.StatesEntry.CONTENT_URI;
                String[] projectionColumnsStates = { HealthCareContract.StatesEntry._ID};
                String selectionStatementStates = HealthCareContract.StatesEntry
                        .getSqlSelectLang(context);

                Cursor cursorStates = context.getContentResolver().query(
                        StatesueryUri,
                        projectionColumnsStates,
                        selectionStatementStates,
                        null,
                        null);
                Log.d( "StatesueryUri", String.valueOf( StatesueryUri ) );

                Log.d( "StatesueryUri", String.valueOf( projectionColumnsStates ) );
                Log.d( "StatesueryUri", String.valueOf( selectionStatementStates ) );
*/
                //////////////////////////////////
                Uri SpecialitiesQueryUri = HealthCareContract.SpecialitiesEntry.CONTENT_URI;
                String[] projectionColumnsSpecialities = {HealthCareContract.SpecialitiesEntry._ID};
                String selectionStatementSpecialities = HealthCareContract.SpecialitiesEntry
                        .getSqlSelectLang( context );

                Cursor cursorSpecialities = context.getContentResolver().query(
                        SpecialitiesQueryUri,
                        projectionColumnsSpecialities,
                        selectionStatementSpecialities,
                        null,
                        null );
                Log.d( "SpecialitiesQueryUri", String.valueOf( SpecialitiesQueryUri ) );

                Log.d( "SpecialitiesQueryUri", String.valueOf( projectionColumnsSpecialities ) );
                Log.d( "SpecialitiesQueryUri", String.valueOf( selectionStatementSpecialities ) );

                ///////////////////////////////////////
                Uri LanguagesQueryUri = HealthCareContract.LanguagesEntry.CONTENT_URI;
                String[] projectionColumnsLanguages = {HealthCareContract.LanguagesEntry._ID};
                String selectionStatementLanguages = HealthCareContract.LanguagesEntry
                        .getSqlSelectLang( context );

                Cursor cursorLanguage = context.getContentResolver().query(
                        LanguagesQueryUri,
                        projectionColumnsLanguages,
                        selectionStatementLanguages,
                        null,
                        null );
                Log.d( "LanguagesQueryUri", String.valueOf( LanguagesQueryUri ) );

                Log.d( "projectionLanguages", String.valueOf( projectionColumnsLanguages ) );
                Log.d( "selectionLanguages", String.valueOf( selectionStatementLanguages ) );


                if (null == cursorInsurance || cursorInsurance.getCount() == 0) {
                    startImmediateSync( context );
                } else if (null == cursorArea || cursorArea.getCount() == 0) {
                    startImmediateSync( context );
                }
               /* else if (null == cursorStates || cursorStates.getCount() == 0) {
                    startImmediateSync(context);
                }*/
                else if (null == cursorSpecialities || cursorSpecialities.getCount() == 0) {
                    startImmediateSync( context );
                } else if (null == cursorLanguage || cursorLanguage.getCount() == 0) {
                    startImmediateSync(context);
                }


                cursorInsurance.close();
                cursorArea.close();
                //cursorStates.close();
                cursorSpecialities.close();
                cursorLanguage.close();

            }
        } );

        checkForEmpty.start();
    }

    public static void startImmediateSync(@NonNull final Context context) {
        Intent intentToSyncImmediately = new Intent( context, HealthCareSyncIntentService.class );
        context.startService( intentToSyncImmediately );
    }
}
