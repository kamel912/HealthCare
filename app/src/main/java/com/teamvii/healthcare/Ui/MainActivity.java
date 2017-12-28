package com.teamvii.healthcare.Ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.teamvii.healthcare.InitiateVolley.GetSpinnersContents;
import com.teamvii.healthcare.R;
import com.teamvii.healthcare.connection.ApiInterface;
import com.teamvii.healthcare.data.DbGetSpinnerBackend;
import com.teamvii.healthcare.data.MDbHelber;
import com.teamvii.healthcare.data.PreferenceUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC_AREA;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC_INSURANCE;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC_SPECIALITIES;
import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC_STATES;


public class MainActivity extends AppCompatActivity {

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
        getSpinnersContents = new GetSpinnersContents( this );
        getStates( this );
        // getSpinnersContents.getDoctor( this );
        getInsurance( this );
        getAreas( this );
        getSpecialities( this );



    }

    public void gooooooo(View view) {
        Intent intent = new Intent( MainActivity.this,
                FindDoctor.class );
        startActivity( intent );
    }

    public void PARSE_DOCTOR(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            JSONObject json = null;
            try {
                json = array.getJSONObject( i );
                String id = json.getString( "id" );
                String name = json.getString( "name" );
                String gender = json.getString( "gender" );
                mDbHelber.addDoctorForSpinner( id, name, gender );
                Log.d( TAG, "value from server : " + id + "  " + name + "  " + gender );

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    //=================getStates============================================================================
    public void getStates(Context context) {
        mDbHelber = new MDbHelber( context );

        StringRequest stringRequest = new StringRequest( Request.Method.GET, URL_SYNC + preferenceUtil.getLANG_KEY( context ) + URL_SYNC_STATES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray( response );
                            PARSE_STATES( jsonArray );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        } ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue( context );
        requestQueue.add( stringRequest );
    }

    public void PARSE_STATES(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            JSONObject json = null;
            try {
                json = array.getJSONObject( i );
                String id = json.getString( "id" );
                String name = json.getString( "name" );

                mDbHelber.addStatesSpinner( id, name );
                Log.d( TAG, "value from States server : " + id + "  " + name );

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    //===================================getAreas=================================================
    public void getAreas(Context context) {
        mDbHelber = new MDbHelber( context );

        StringRequest stringRequest = new StringRequest( Request.Method.POST, URL_SYNC + preferenceUtil.getLANG_KEY( context ) + URL_SYNC_AREA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray( response );
                            PARSE_AREA( jsonArray );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        } ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue( context );
        requestQueue.add( stringRequest );
    }

    public void PARSE_AREA(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            JSONObject json = null;
            try {
                json = array.getJSONObject( i );
                String id = json.getString( "id" );
                String name = json.getString( "name" );
                mDbHelber.addAreaSpinner( id, name );
                Log.d( TAG, "value from Area server : " + id + "  " + name );

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    //==================================getInsurance=============================================
    public void getInsurance(Context context) {
        mDbHelber = new MDbHelber( context );

        StringRequest stringRequest = new StringRequest( Request.Method.GET, URL_SYNC + preferenceUtil.getLANG_KEY( context ) + URL_SYNC_INSURANCE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray( response );
                            PARSE_INSURANCE( jsonArray );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        } ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue( context );
        requestQueue.add( stringRequest );
    }

    public void PARSE_INSURANCE(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            JSONObject json = null;
            try {
                json = array.getJSONObject( i );
                String id = json.getString( "id" );
                String name = json.getString( "name" );

                mDbHelber.addInsurancesSpinner( id, name );
                Log.d( TAG, "value insurances from server : " + id + "  " + name );

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    //==============================getSpecialities===============================================
    public void getSpecialities(Context context) {
        mDbHelber = new MDbHelber( context );

        StringRequest stringRequest = new StringRequest( Request.Method.GET, URL_SYNC + preferenceUtil.getLANG_KEY( context ) + URL_SYNC_SPECIALITIES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray( response );
                            PARSE_SPECIALITIES( jsonArray );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        } ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue( context );
        requestQueue.add( stringRequest );
    }

    public void PARSE_SPECIALITIES(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            JSONObject json = null;
            try {
                json = array.getJSONObject( i );
                String id = json.getString( "id" );
                String name = json.getString( "name" );
                mDbHelber.addSpecialitiesSpinner( id, name );
                Log.d( TAG, "value specialities from server : " + URL_SYNC + preferenceUtil.getLANG_KEY( context ) + URL_SYNC_SPECIALITIES + "  " );

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
