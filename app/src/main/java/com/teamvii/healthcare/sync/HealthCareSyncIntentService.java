package com.teamvii.healthcare.sync;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by ibrahim on 29/12/17.
 */
//TODO 3 كلاس السيرفس اللي ياخذ من فولي
public class HealthCareSyncIntentService extends IntentService {
    public HealthCareSyncIntentService() {
        super( "HealthCareSyncIntentService" );
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        SyncData.syncSpinner( this );

    }
}
