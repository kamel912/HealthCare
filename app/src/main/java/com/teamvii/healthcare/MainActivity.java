package com.teamvii.healthcare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.teamvii.healthcare.connection.ApiClient;
import com.teamvii.healthcare.connection.ApiInterface;

public class MainActivity extends AppCompatActivity {
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        apiInterface = ApiClient.getApiClient().create( ApiInterface.class );
    }
}
