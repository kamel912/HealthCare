package com.teamvii.healthcare.sync;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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

/**
 * Created by ibrahim on 26/12/17.
 */
//TODO 1 كلاس الميثود استدعاء بالفولي
public class GetSpinnersContents {
    private static final String TAG = GetSpinnersContents.class.getSimpleName();

    MDbHelber mDbHelber;
    RequestQueue requestQueue;
    Context context;
    PreferenceUtil preferenceUtil;

    public GetSpinnersContents(Context context) {
        this.context = context;
        preferenceUtil = new PreferenceUtil( context );
        mDbHelber = new MDbHelber( context );

    }

    public void getStates(Context context) {

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
