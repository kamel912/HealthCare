package com.teamvii.healthcare.sync;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by ibrahim on 29/12/17.
 */
//TODO 3 HealthCareSyncData من  syncSpinner هذا كلاس السيرفس ييلخذ الان من الميثود
public class HealthCareSyncIntentService extends IntentService {

    public static final String CASHBACK_INFO = "cashback_info";

    public HealthCareSyncIntentService() {
        super( "HealthCareSyncIntentService" );
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        HealthCareSyncData.syncSpinner( this );

        String cb_category = intent.getStringExtra( "lang_path" );

        String cbinfo = getCashbackInfo( cb_category );
        sendCashbackInfoToClient( cbinfo );
    }

    private String getCashbackInfo(String cbcat) {
        String cashback;
        if ("ar".equals( cbcat )) {
            cashback = "عربي";
        } else if ("en".equals( cbcat )) {
            cashback = "english";
        } else {
            cashback = "no path";
        }
        return cashback;
    }

    private void sendCashbackInfoToClient(String msg) {
        Intent intent = new Intent();
        intent.setAction( CASHBACK_INFO );
        intent.putExtra( "cashback_lang", msg );
        sendBroadcast( intent );
    }
}
