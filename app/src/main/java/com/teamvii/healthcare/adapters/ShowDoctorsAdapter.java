package com.teamvii.healthcare.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamvii.healthcare.R;
import com.teamvii.healthcare.models.Doctor;

import java.util.List;

/**
 * Created by ibrahim on 25/12/17.
 */

public class ShowDoctorsAdapter extends RecyclerView.Adapter<ShowDoctorsAdapter.MyHolder> {

    List<Doctor> doctors;
    Context context;

    public ShowDoctorsAdapter(List<Doctor> doctors, Context context) {
        super();
        this.context = context;
        this.doctors = doctors;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.list_item_doctors, parent, false );
        view.setLayoutParams( new RecyclerView.LayoutParams( RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT ) );

        MyHolder holder = new MyHolder( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        final Doctor doctor2 = doctors.get( position );

        holder.IdDrnam.setText( doctor2.getName() );
        holder.IdSpeciality.setText( doctor2.getSpeciality() );
        holder.IdState.setText( doctor2.getState() );
        holder.IdInsurance.setText( doctor2.getInsurance() );

//        holder.user_id.setText(SH.getUser_id());
        //   holder.car_id.setText(SH.getCar_id());

    }

    @Override
    public int getItemCount() {
        if (doctors != null) {
            return doctors.size();

        }
        return 0;

    }


    public class MyHolder extends RecyclerView.ViewHolder {

        // Typeface customTypeOne = Typeface.createFromAsset(itemView.getContext().getAssets(), "DroidNaskh-Regular.ttf");


        TextView IdDrnam;
        TextView IdSpeciality;
        TextView IdState;
        TextView IdInsurance;


        MyHolder(View itemView) {
            super( itemView );

            IdDrnam = (TextView) itemView.findViewById( R.id.IdDrnam );
            IdSpeciality = (TextView) itemView.findViewById( R.id.IdSpeciality );
            IdState = (TextView) itemView.findViewById( R.id.IdState );
            IdInsurance = (TextView) itemView.findViewById( R.id.IdInsurance );
        }

    }
}