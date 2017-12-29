package com.teamvii.healthcare.sync;

import android.content.Context;

/**
 * Created by ibrahim on 29/12/17.
 */
//TODO 2 الكلاس اللي يستدعي ميثود الفولي
public class SyncData {

    static GetSpinnersContents getSpinnersContents;

    Context context;

    public SyncData(Context context) {
        this.context = context;
        getSpinnersContents = new GetSpinnersContents( context );


    }

    synchronized public static void syncSpinner(Context context) {
        try {
            getSpinnersContents = new GetSpinnersContents( context );
            getSpinnersContents.getStates( context );
            // getSpinnersContents.getDoctor( this );
            getSpinnersContents.getInsurance( context );
            getSpinnersContents.getAreas( context );
            getSpinnersContents.getSpecialities( context );
        } catch (Exception e) {
            /* Server probably invalid */
            e.printStackTrace();
        }
    }
}