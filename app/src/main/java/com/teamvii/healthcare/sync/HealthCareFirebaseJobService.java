package com.teamvii.healthcare.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by ibrahim on 29/12/17.
 */

public class HealthCareFirebaseJobService extends JobService {

    JobParameters mParams;
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isSuccess = false;
         /*   if(intent.hasExtra(IS_SUCCESS)) {
                isSuccess = intent.getBooleanExtra(IS_SUCCESS, false);
            }
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            jobFinished(mParams, !isSuccess);*/
        }
    };

    public boolean onStartJob(JobParameters params) {
        mParams = params;
        LocalBroadcastManager.getInstance( this ).registerReceiver( mMessageReceiver,
                new IntentFilter( "HealthCareSyncIntentService" ) );
        startService( new Intent( this, HealthCareSyncIntentService.class ) );
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters job) {

        return false;
    }
}
