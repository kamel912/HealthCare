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

public class FindDoctor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] SPECIALITY, GENDER, STATE, INSURANCE, LANG;
    String num_SPECIALITY, num_GENDER, num_STATE, num_INSURANCE, num_LANG;
    PreferenceUtil preferenceUtil;
    TextView sp_txt, state_txt, area_txt, insurance_txt, gender_txt, lang_txt;
    DbGetSpinnerBackend dbGetSpinnerBackend;
    String[] spinnerArea, spinnerInsurance, spinnerSpecialities, spinnerStateses;
    MDbHelber mDbHelber;
    private Spinner SP_ID, SP_SPECIALITY, SP_GENDER, SP_STAT, SP_INSURANCE, SP_AREA, SP_LANG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_find_doctor );

        preferenceUtil = new PreferenceUtil( this );
        sp_txt = findViewById( R.id.sp_txt );
        state_txt = findViewById( R.id.state_txt );
        area_txt = findViewById( R.id.area_txt );
        insurance_txt = findViewById( R.id.insurance_txt );
        gender_txt = findViewById( R.id.gender_txt );
        lang_txt = findViewById( R.id.lang_txt );

        dbGetSpinnerBackend = new DbGetSpinnerBackend( this );
        spinnerArea = dbGetSpinnerBackend.getAreaSP();
        spinnerInsurance = dbGetSpinnerBackend.getInsuranceSP();
        spinnerSpecialities = dbGetSpinnerBackend.getSpecialtySP();
        spinnerStateses = dbGetSpinnerBackend.getStatesSp();


        SPECIALITY = getResources().getStringArray( R.array.listSpeciality );
        LANG = getResources().getStringArray( R.array.listLang );
        GENDER = getResources().getStringArray( R.array.listGender );
        STATE = getResources().getStringArray( R.array.listState );
        INSURANCE = getResources().getStringArray( R.array.listInsurance );

        // SP_ID=findViewById( R.id.SP_ID );
        SP_SPECIALITY = findViewById( R.id.SP_SPECIALITY );
        SP_GENDER = findViewById( R.id.SP_GENDER );
        SP_STAT = findViewById( R.id.SP_STAT );
        SP_INSURANCE = findViewById( R.id.SP_INSURANCE );
        SP_AREA = findViewById( R.id.SP_AREA );
        SP_LANG = findViewById( R.id.SP_LANG );


        if (spinnerArea != null && spinnerInsurance != null && spinnerSpecialities != null && spinnerStateses != null) {
            loadSpinnersFromSqlite();

        } else {
            try {
                loadSpinnersFromSting();

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }


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

        sp_txt.setText( SP_SPECIALITY.getSelectedItem().toString() );
        state_txt.setText( SP_STAT.getSelectedItem().toString() );
        area_txt.setText( SP_AREA.getSelectedItem().toString() );
        insurance_txt.setText( SP_INSURANCE.getSelectedItem().toString() );
        gender_txt.setText( SP_GENDER.getSelectedItem().toString() );
        lang_txt.setText( SP_LANG.getSelectedItem().toString() );

       /* try {


            int s = mDbHelber.GetAreaID( SP_AREA.getSelectedItem().toString() );
            int s2 = mDbHelber.GetInsuranceID( SP_INSURANCE.getSelectedItem().toString() );
            int s3 = mDbHelber.GetStatesID( SP_STAT.getSelectedItem().toString() );
            int s4 = mDbHelber.GetSpeialityID( SP_SPECIALITY.getSelectedItem().toString() );
            if(s!=0&&s2!=0&&s3!=0&&s4!=0){
                preferenceUtil.setSpecialityIdKey( String.valueOf( s ) );
                preferenceUtil.setGenderIdKey( String.valueOf( s2 ) );
                preferenceUtil.setStateIdKey( String.valueOf( s3 ) );
                preferenceUtil.setInsuranceIdKey( String.valueOf( s4 ) );

            }
        }catch (NullPointerException e){
            e.printStackTrace();

        }*/







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

    public void SendIdToServer() {
        Intent intent = new Intent( FindDoctor.this, ShowDoctors.class );
        startActivity( intent );

    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        // super.onListItemClick(l, v, position, id);

    }


    private void loadSpinnersFromSqlite() {

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


        final ArrayAdapter<String> spinnerAdapterSpecialities = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, spinnerSpecialities ) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView( position, convertView, parent );
                TextView tv = (TextView) view;

                if (position == -1) {
                    tv.setText( R.string.select_speciality );
                    tv.setTextSize( 15 );
                } else if (position % 2 == 1 || position == 0) {

                    tv.setBackgroundColor( Color.parseColor( "#FF00D977" ) );
                } else {
                    tv.setBackgroundColor( Color.parseColor( "#FF76F2BA" ) );
                }
                return view;
            }
        };
        spinnerAdapterSpecialities.setDropDownViewResource( R.layout.spinner_dropdown_item );
        SP_SPECIALITY.setAdapter( spinnerAdapterSpecialities );

        SP_SPECIALITY.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
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

        final ArrayAdapter<String> spinnerAdapterStates = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, spinnerStateses ) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView( position, convertView, parent );
                TextView tv = (TextView) view;

                if (position == -1) {
                    tv.setText( R.string.select_state );
                    tv.setTextSize( 15 );
                } else if (position % 2 == 1 || position == 0) {

                    tv.setBackgroundColor( Color.parseColor( "#FF00D977" ) );
                } else {
                    tv.setBackgroundColor( Color.parseColor( "#FF76F2BA" ) );
                }
                return view;
            }
        };
        spinnerAdapterStates.setDropDownViewResource( R.layout.spinner_dropdown_item );
        SP_STAT.setAdapter( spinnerAdapterStates );

        SP_STAT.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
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

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void loadSpinnersFromSting() {
        final ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray( R.array.listArea ) ) {
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
        spinnerInsurance = dbGetSpinnerBackend.getInsuranceSP();
        final ArrayAdapter<String> spinnerAdapterInsurance = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray( R.array.listInsurance ) ) {
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

        final ArrayAdapter<String> spinnerAdapterSpecialities = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray( R.array.listSpeciality ) ) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView( position, convertView, parent );
                TextView tv = (TextView) view;

                if (position == -1) {
                    tv.setText( R.string.select_speciality );
                    tv.setTextSize( 15 );
                } else if (position % 2 == 1 || position == 0) {

                    tv.setBackgroundColor( Color.parseColor( "#FF00D977" ) );
                } else {
                    tv.setBackgroundColor( Color.parseColor( "#FF76F2BA" ) );
                }
                return view;
            }
        };
        spinnerAdapterSpecialities.setDropDownViewResource( R.layout.spinner_dropdown_item );
        SP_SPECIALITY.setAdapter( spinnerAdapterSpecialities );

        SP_SPECIALITY.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
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
        final ArrayAdapter<String> spinnerAdapterStates = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray( R.array.listState ) ) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView( position, convertView, parent );
                TextView tv = (TextView) view;

                if (position == -1) {
                    tv.setText( R.string.select_state );
                    tv.setTextSize( 15 );
                } else if (position % 2 == 1 || position == 0) {

                    tv.setBackgroundColor( Color.parseColor( "#FF00D977" ) );
                } else {
                    tv.setBackgroundColor( Color.parseColor( "#FF76F2BA" ) );
                }
                return view;
            }
        };
        spinnerAdapterStates.setDropDownViewResource( R.layout.spinner_dropdown_item );
        SP_STAT.setAdapter( spinnerAdapterStates );

        SP_STAT.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
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

    }



}