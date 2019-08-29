package com.example.istiqomahnw.astgafirullah.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.istiqomahnw.astgafirullah.History;
import com.example.istiqomahnw.astgafirullah.Model.Date;
import com.example.istiqomahnw.astgafirullah.R;

import java.util.ArrayList;
/**
 * Created by ISTIQOMAH NW on 01/07/2019.
 */

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.MyViewHolder> {

    Context context;
    ArrayList<Date> dates;

    public DateAdapter(Context c , ArrayList<Date> d)
    {
        context = c;
        dates = d;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_tanggal.setText(dates.get(position).getDate());
        holder.txt_count.setText(dates.get(position).getCount());
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt_tanggal, txt_count;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_tanggal = (TextView) itemView.findViewById(R.id.txt_date);
            txt_count = (TextView) itemView.findViewById(R.id.txt_count);
        }
    }
}

