package com.teamvii.healthcare.Ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.android.volley.RequestQueue;
import com.teamvii.healthcare.R;
import com.teamvii.healthcare.connection.ApiInterface;
import com.teamvii.healthcare.data.DbGetSpinnerBackend;
import com.teamvii.healthcare.data.MDbHelber;
import com.teamvii.healthcare.data.PreferenceUtil;
import com.teamvii.healthcare.sync.GetSpinnersContents;


public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    GetSpinnersContents getSpinnersContents;
    Button btnCheck;
    MDbHelber mDbHelber;
    RequestQueue requestQueue;
    Context context;
    String LANG;
    PreferenceUtil preferenceUtil;
    DbGetSpinnerBackend dbGetSpinnerBackend;
    private ApiInterface apiInterface;
    private Switch langSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mDbHelber = new MDbHelber( this );
        dbGetSpinnerBackend = new DbGetSpinnerBackend( this );
        preferenceUtil = new PreferenceUtil( this );
        setContentView( R.layout.activity_main );



    }

    public void findYourDR(View view) {
        Intent intent = new Intent( MainActivity.this, FindDoctor.class );
        startActivity( intent );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.main_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Intent startSettingsActivityIntent = new Intent( this, SettingsActivity.class );
                startActivity( startSettingsActivityIntent );
                return true;
            default:
                return super.onOptionsItemSelected( item );
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences( this );
        String localeString = sharedPreferences.getString( "language", getString( R.string.pref_language_arabic_value ) );
        String[] localeStrings = localeString.split( "_" );
//        changeLocale(this,localeStrings[0]);
    }


}
