package com.teamvii.healthcare.Ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.teamvii.healthcare.R;
import com.teamvii.healthcare.data.DbGetSpinnerBackend;
import com.teamvii.healthcare.data.MDbHelber;
import com.teamvii.healthcare.data.PreferenceUtil;
import com.teamvii.healthcare.models.SpinnersItemArea;

import java.util.ArrayList;

public class FindDoctor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //TODO List of item sending the number of id to select it from fk you want
    String[] SPECIALITY, GENDER, STATE, INSURANCE, LANG;
    String num_SPECIALITY, num_GENDER, num_STATE, num_INSURANCE, num_LANG;
    PreferenceUtil preferenceUtil;
    TextView sp_txt, state_txt, area_txt, insurance_txt, gender_txt, lang_txt;
    DbGetSpinnerBackend dbGetSpinnerBackend;
    private Spinner SP_ID, SP_SPECIALITY, SP_GENDER, SP_STAT, SP_INSURANCE, SP_AREA, SP_LANG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_find_doctor );

        dbGetSpinnerBackend = new DbGetSpinnerBackend( this );
        preferenceUtil = new PreferenceUtil( this );
        sp_txt = findViewById( R.id.sp_txt );
        state_txt = findViewById( R.id.state_txt );
        area_txt = findViewById( R.id.area_txt );
        insurance_txt = findViewById( R.id.insurance_txt );
        gender_txt = findViewById( R.id.gender_txt );
        lang_txt = findViewById( R.id.lang_txt );




        SPECIALITY = getResources().getStringArray( R.array.speciality );
        LANG = getResources().getStringArray( R.array.lang );
        GENDER = getResources().getStringArray( R.array.gender );
        STATE = getResources().getStringArray( R.array.state );
        INSURANCE = getResources().getStringArray( R.array.insurance );
        LANG = getResources().getStringArray( R.array.lang );

        // SP_ID=findViewById( R.id.SP_ID );
        SP_SPECIALITY = findViewById( R.id.SP_SPECIALITY );
        SP_GENDER = findViewById( R.id.SP_GENDER );
        SP_STAT = findViewById( R.id.SP_STAT );
        SP_INSURANCE = findViewById( R.id.SP_INSURANCE );
        SP_AREA = findViewById( R.id.SP_AREA );//TODO Spinner Area want to data
        SP_LANG = findViewById( R.id.SP_LANG );

        loadSpinners();

        SP_SPECIALITY.setOnItemSelectedListener( this );
        SP_GENDER.setOnItemSelectedListener( this );
        SP_STAT.setOnItemSelectedListener( this );
        SP_INSURANCE.setOnItemSelectedListener( this );
        SP_AREA.setOnItemSelectedListener( this );
        SP_LANG.setOnItemSelectedListener( this );

        findViewById( R.id.btnFindDoctors ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendIdToServer();

            }
        } );
    }

    //TODO methos response of get number of item we weant
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        sp_txt.setText( SP_SPECIALITY.getSelectedItem().toString() );
        state_txt.setText( SP_STAT.getSelectedItem().toString() );
        area_txt.setText( SP_AREA.getSelectedItem().toString() );
        insurance_txt.setText( SP_INSURANCE.getSelectedItem().toString() );
        gender_txt.setText( SP_GENDER.getSelectedItem().toString() );
        lang_txt.setText( SP_LANG.getSelectedItem().toString() );

        String g = sp_txt.getText().toString();

        Toast.makeText
                ( FindDoctor.this, "Selected : " + g, Toast.LENGTH_SHORT ).show();

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
       /* Toast.makeText(FindDoctor.this," "+ num_SPECIALITY+ ":" + preferenceUtil.getSpecialityIdKey( this )
        + "\n num_GENDER :" + preferenceUtil.getGenderIdKey( this )
                + "\n num_STATE :" + preferenceUtil.getStateIdKey( this )
                + "\n num_INSURANCE :" + preferenceUtil.getInsuranceIdKey( this)
                + "\n num_LANG" + preferenceUtil.getLangIdKey( this ),Toast.LENGTH_SHORT).show();
*/
        MDbHelber mDbHelber = new MDbHelber( this );
        int s = mDbHelber.GetDeptID( SP_AREA.getSelectedItem().toString() );
        preferenceUtil.setSpecialityIdKey( String.valueOf( s ) );
        preferenceUtil.setGenderIdKey( num_GENDER );
        preferenceUtil.setStateIdKey( num_STATE );
        preferenceUtil.setInsuranceIdKey( num_INSURANCE );
        preferenceUtil.setLangIdKey( this, num_LANG );

        Log.d( "Saved_id", " num_SPECIALITY :" + preferenceUtil.getSpecialityIdKey( this )
                + "\n num_GENDER :" + preferenceUtil.getGenderIdKey( this )
                + "\n num_STATE :" + preferenceUtil.getStateIdKey( this )
                + "\n num_INSURANCE :" + preferenceUtil.getInsuranceIdKey( this )
                + "\n num_LANG" + preferenceUtil.getLangIdKey( this ) );

        TextView test = (findViewById( R.id.Testtxt ));

        test.setText( " num_SPECIALITY :" + preferenceUtil.getSpecialityIdKey( FindDoctor.this )
                + "\n num_GENDER :" + preferenceUtil.getGenderIdKey( this )
                + "\n num_STATE :" + preferenceUtil.getStateIdKey( this )
                + "\n num_INSURANCE :" + preferenceUtil.getInsuranceIdKey( this )
                + "\n num_LANG" + preferenceUtil.getLangIdKey( this ) );

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        sp_txt.setText( R.string.select_speciality );


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate( savedInstanceState, persistentState );

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        sp_txt.setText( R.string.select_speciality );
        state_txt.setText( R.string.select_state );
        area_txt.setText( R.string.select_speciality );
        insurance_txt.setText( R.string.insurance );
        gender_txt.setText( R.string.select_gender );
        lang_txt.setText( R.string.select_lang );

    }

    //TODO here we want send id from spinner to server
    public void SendIdToServer() {
        Intent intent = new Intent( FindDoctor.this, ShowDoctors.class );
        startActivity( intent );

    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        // super.onListItemClick(l, v, position, id);

    }



    private void loadSpinners() {
        ArrayList<SpinnersItemArea> spinnersItemAreas;
        String[] spinnerSpecialities = dbGetSpinnerBackend.getSpecialtySP();
        String[] spinnerStates = dbGetSpinnerBackend.getStatesSp();


        final String[] spinnerArea = dbGetSpinnerBackend.getAreaSP();
        final ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, spinnerArea ) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView( position, convertView, parent );
                TextView tv = (TextView) view;
                if (position % 2 == 1) {
                    tv.setBackgroundColor( Color.parseColor( "#FF00D977" ) );
                } else {
                    tv.setBackgroundColor( Color.parseColor( "#FF76F2BA" ) );
                }
                return view;
            }
        };
        spinnerArrayAdapter2.setDropDownViewResource( R.layout.spinner_dropdown_item );
        SP_AREA.setAdapter( spinnerArrayAdapter2 );

        SP_AREA.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition( position );
                // Notify the selected item text
                Toast.makeText
                        ( getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT ).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        final String[] spinnerInsurance = dbGetSpinnerBackend.getInsuranceSP();
        final ArrayAdapter<String> spinnerAdapterInsurance = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, spinnerInsurance ) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView( position, convertView, parent );
                TextView tv = (TextView) view;
                if (position % 2 == 1) {
                    tv.setBackgroundColor( Color.parseColor( "#FF00D977" ) );
                } else {
                    tv.setBackgroundColor( Color.parseColor( "#FF76F2BA" ) );
                }
                return view;
            }
        };
        spinnerAdapterInsurance.setDropDownViewResource( R.layout.spinner_dropdown_item );
        SP_INSURANCE.setAdapter( spinnerAdapterInsurance );

        SP_INSURANCE.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition( position );
                // Notify the selected item text
                Toast.makeText
                        ( getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT ).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        ArrayAdapter<String> spinnerAdapterSpecialities = new ArrayAdapter<String>( FindDoctor.this, android.R.layout.simple_spinner_item, spinnerSpecialities );
        spinnerAdapterSpecialities.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        SP_SPECIALITY.setAdapter( spinnerAdapterSpecialities );
        SP_SPECIALITY.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                return;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );
        ArrayAdapter<String> spinnerAdapterStates = new ArrayAdapter<String>( FindDoctor.this, android.R.layout.simple_spinner_item, spinnerStates );
        spinnerAdapterStates.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        SP_STAT.setAdapter( spinnerAdapterStates );
        SP_STAT.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                return;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );
    }




}