package com.teamvii.healthcare.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.teamvii.healthcare.InitiateVolley.GetSpinnersContents;
import com.teamvii.healthcare.R;
import com.teamvii.healthcare.connection.ApiInterface;


public class MainActivity extends AppCompatActivity {
    GetSpinnersContents getSpinnersContents;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        getSpinnersContents = new GetSpinnersContents( this );

        getSpinnersContents.getStates( this );
        getSpinnersContents.getDoctor( this );
        getSpinnersContents.getInsurance( this );
        getSpinnersContents.getAreas( this );
        getSpinnersContents.getSpecialities( this );


        // apiInterface = ApiClient.getApiClient().create( ApiInterface.class );
    }

    public void FindYourDR(View view) {
        Intent intent = new Intent( MainActivity.this, FindDoctor.class );
        startActivity( intent );
    }


}
