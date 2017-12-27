package com.teamvii.healthcare.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.teamvii.healthcare.R;
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

    public void FindYourDR(View view) {
        Intent intent = new Intent( MainActivity.this, FindDoctor.class );
        startActivity( intent );
    }
}
