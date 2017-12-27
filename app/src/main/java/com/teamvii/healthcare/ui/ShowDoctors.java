package com.teamvii.healthcare.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.teamvii.healthcare.R;
import com.teamvii.healthcare.adapters.ShowDoctorsAdapter;
import com.teamvii.healthcare.models.Doctor;

import java.util.ArrayList;
import java.util.List;

public class ShowDoctors extends AppCompatActivity {

    RecyclerView ListShowDoctors;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;
    ProgressBar progressBar;
    private List<Doctor> doctors;
    private ProgressDialog pd;

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

    }

}
