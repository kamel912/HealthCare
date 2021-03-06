package com.teamvii.healthcare.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.teamvii.healthcare.R;
import com.teamvii.healthcare.data.PreferenceUtil;
import com.teamvii.healthcare.sync.HealthCareSyncIntentService;

import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC_GENDER;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC_LANG;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC_STATES;

public class Home extends AppCompatActivity {
    private static final String TAG = Home.class.getSimpleName();
    PreferenceUtil preferenceUtil;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
        btnLogin = findViewById( R.id.btnLogin );
        preferenceUtil = new PreferenceUtil( this );

        btnLogin.setOnClickListener( new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent( Home.this,
                        MainActivity.class );
                startActivity( intent );


            }

        } );
    }
    public void ENeselevtion(View view) {

        //  setLang.setLang( "en" );
        preferenceUtil.setLANG_KEY( "en" );


        Intent i = new Intent( this, HealthCareSyncIntentService.class );
        i.putExtra( "lang_path", "en" );
        startService( i );
        Log.d( "langSelection", URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_SPECIALITIES + "\n" +
                URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_AREA +
                "\n" + URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_INSURANCE + "\n" +
                URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_STATES + "\n" +
                URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_GENDER + "\n" +
                URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_LANG + "\n" );


    }

    public void ARselection(View view) {
        preferenceUtil.setLANG_KEY( "ar" );

        Log.d( "langSelection", URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_SPECIALITIES + "\n" +
                URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_AREA +
                "\n" + URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_INSURANCE + "\n" +
                URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_STATES + "\n" +
                URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_GENDER + "\n" +
                URL_SYNC + preferenceUtil.getLANG_KEY( this ) + URL_SYNC_LANG + "\n" );


        //   Intent i = new Intent(this, HealthCareSyncIntentService.class);
        // i.putExtra("lang_path", "ar");
        //  startService(i);


    }
}
