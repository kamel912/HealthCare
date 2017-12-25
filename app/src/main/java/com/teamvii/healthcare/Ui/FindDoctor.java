package com.teamvii.healthcare.Ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.teamvii.healthcare.R;

public class FindDoctor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //TODO List of item sending the number of id to select it from fk you want
    String[] SPECIALITY, GENDER, STATE, INSURANCE, LANG;
    //TODO Strings Nmber Of Spinner will  save the number of items of spinners
    String num_SPECIALITY, num_GENDER, num_STATE, num_INSURANCE, num_LANG;
    private Spinner SP_ID, SP_SPECIALITY, SP_GENDER, SP_STAT, SP_INSURANCE, SP_AREA, SP_LANG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_find_doctor );


        SPECIALITY = getResources().getStringArray( R.array.speciality );
        LANG = getResources().getStringArray( R.array.lang );
        GENDER = getResources().getStringArray( R.array.gender );
        STATE = getResources().getStringArray( R.array.state );
        INSURANCE = getResources().getStringArray( R.array.insurance );
        LANG = getResources().getStringArray( R.array.insurance );

        // SP_ID=findViewById( R.id.SP_ID );
        SP_SPECIALITY = findViewById( R.id.SP_SPECIALITY );
        SP_GENDER = findViewById( R.id.SP_GENDER );
        SP_STAT = findViewById( R.id.SP_STAT );
        SP_INSURANCE = findViewById( R.id.SP_INSURANCE );
        SP_AREA = findViewById( R.id.SP_AREA );//TODO Spinner Area want to data
        SP_LANG = findViewById( R.id.SP_LANG );
        ///================
        ArrayAdapter adapter_SPECIALITY = new ArrayAdapter(
                FindDoctor.this,
                android.R.layout.simple_dropdown_item_1line,
                SPECIALITY );
        adapter_SPECIALITY.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item );
        SP_SPECIALITY.setAdapter( adapter_SPECIALITY );
        ///===================
        ArrayAdapter adapter_GENDER = new ArrayAdapter(
                FindDoctor.this,
                android.R.layout.simple_dropdown_item_1line,
                GENDER );
        adapter_GENDER.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item );
        SP_GENDER.setAdapter( adapter_GENDER );
        //====================
        ArrayAdapter adapter_STATE = new ArrayAdapter(
                FindDoctor.this,
                android.R.layout.simple_dropdown_item_1line,
                STATE );
        adapter_STATE.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item );
        SP_STAT.setAdapter( adapter_STATE );
        //===================
        ArrayAdapter adapter_INSURANCE = new ArrayAdapter(
                FindDoctor.this,
                android.R.layout.simple_dropdown_item_1line,
                INSURANCE );
        adapter_INSURANCE.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item );
        SP_INSURANCE.setAdapter( adapter_INSURANCE );
        //=====================
        ArrayAdapter adapter_LANG = new ArrayAdapter(
                FindDoctor.this,
                android.R.layout.simple_dropdown_item_1line,
                LANG );
        adapter_INSURANCE.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item );
        SP_LANG.setAdapter( adapter_LANG );

        SP_SPECIALITY.setOnItemSelectedListener( this );
        SP_GENDER.setOnItemSelectedListener( this );
        SP_STAT.setOnItemSelectedListener( this );
        SP_INSURANCE.setOnItemSelectedListener( this );
        SP_LANG.setOnItemSelectedListener( this );

    }

    //TODO methos response of get number of item we weant
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        int num = SP_SPECIALITY.getSelectedItemPosition();
        num_SPECIALITY = Integer.toString( num );

        int num2 = SP_GENDER.getSelectedItemPosition();
        num_GENDER = Integer.toString( num2 );

        int num3 = SP_STAT.getSelectedItemPosition();
        num_STATE = Integer.toString( num3 );

        int num4 = SP_INSURANCE.getSelectedItemPosition();
        num_INSURANCE = Integer.toString( num4 );

        int num5 = SP_LANG.getSelectedItemPosition();
        num_LANG = Integer.toString( num5 );
        //Toast.makeText(FindDoctor.this," num_SPECIALITY :"+num_SPECIALITY+"\n num_GENDER :"+num_GENDER+"\n num_STATE :"+num_STATE+"\n num_INSURANCE :"+num_INSURANCE+"\n num_LANG"+num_LANG,Toast.LENGTH_SHORT).show();

        TextView test = (findViewById( R.id.Testtxt ));
        test.setText( " num_SPECIALITY :" + num_SPECIALITY + "\n num_GENDER :" + num_GENDER + "\n num_STATE :" + num_STATE + "\n num_INSURANCE :" + num_INSURANCE + "\n num_LANG" + num_LANG );

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
