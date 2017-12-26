package com.teamvii.healthcare.Ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.teamvii.healthcare.R;
import com.teamvii.healthcare.adapters.ShowDoctorsAdapter;
import com.teamvii.healthcare.data.PreferenceUtil;
import com.teamvii.healthcare.models.Doctor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowDoctors extends AppCompatActivity {

    RecyclerView ListShowDoctors;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;
    ProgressBar progressBar;
    PreferenceUtil preferenceUtil;
    private List<Doctor> doctors;
    private ProgressDialog pd;
    private RequestQueue requestQueue;
    private String URL_GET_DOCTOR = "http://devsinai.com/healthcare/doctors.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_show_doctors );

        doctors = new ArrayList<>();

        ListShowDoctors = findViewById( R.id.ListShowDoctors );
        ListShowDoctors.setHasFixedSize( true );
        recyclerViewlayoutManager = new LinearLayoutManager( this );
        ListShowDoctors.setLayoutManager( recyclerViewlayoutManager );
        recyclerViewadapter = new ShowDoctorsAdapter( doctors, this );
        recyclerViewadapter.notifyDataSetChanged();
        progressBar = (ProgressBar) findViewById( R.id.progressBar1 );
        progressBar.setVisibility( View.VISIBLE );

        getData();
    }

    public void getData() {

        StringRequest stringRequest = new StringRequest( Request.Method.GET, URL_GET_DOCTOR,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONArray jsonArray = new JSONArray( response );
                            progressBar.setVisibility( View.GONE );

                            ParseData( jsonArray );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put( "speciality", preferenceUtil.getSpecialityIdKey( ShowDoctors.this ) );
                // params.put("face_id", Face_id);


                return params;
            }
        };

        requestQueue = Volley.newRequestQueue( this );

        requestQueue.add( stringRequest );
        progressBar.setVisibility( View.GONE );

    }

    public void ParseData(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            Doctor doctor2 = new Doctor();

            JSONObject json = null;
            try {
                json = array.getJSONObject( i );
                doctor2.setGender( json.getString( "gender" ) );
                doctor2.setInsurance( json.getString( "insurance" ) );

                doctor2.setLanguageArabic( json.getString( "language_arabic" ) );
                doctor2.setSpeciality( json.getString( "speciality" ) );
                doctor2.setState( json.getString( "state" ) );


            } catch (JSONException e) {

                e.printStackTrace();
            }
            doctors.add( doctor2 );
        }

        recyclerViewadapter = new ShowDoctorsAdapter( doctors, this );

        ListShowDoctors.setAdapter( recyclerViewadapter );

    }
}
