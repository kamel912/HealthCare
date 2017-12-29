package com.teamvii.healthcare.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.teamvii.healthcare.data.PreferenceUtil;

/**
 * Created by ibrahim on 29/12/17.
 */

public class HealthCareBroadCastReciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        PreferenceUtil.setLang( context, intent.getStringExtra( "cashback_lang" ) );

    }
}
