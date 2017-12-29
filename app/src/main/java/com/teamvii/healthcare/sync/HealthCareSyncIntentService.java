package com.teamvii.healthcare.sync;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by ibrahim on 29/12/17.
 */
public class HealthCareSyncIntentService extends IntentService {


    public HealthCareSyncIntentService() {
        super( "HealthCareSyncIntentService" );
    }

    @Override
    protected void onHandleIntent(Intent intent) {
//TODO 3 HealthCareSyncData من  syncSpinner هذا كلاس السيرفس ييلخذ الان من الميثود

        HealthCareSyncData.syncSpinner( this );


    }
}
