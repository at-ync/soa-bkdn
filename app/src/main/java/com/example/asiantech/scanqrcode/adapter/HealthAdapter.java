package com.example.asiantech.scanqrcode.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asiantech.scanqrcode.R;
import com.example.asiantech.scanqrcode.model.HealthJournalList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by ync on 26/11/2016.
 */
public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.ViewHolder> {
    private List<HealthJournalList> mList;

    public HealthAdapter(List<HealthJournalList> list) {
        this.mList = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_health, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String time = dateFormat.format(new java.util.Date(mList.get(position).getTimestamp()));
        holder.tvThoiGian.setText(time);
        holder.tvNote.setText(mList.get(position).getNote());
        holder.tvTinhTrang.setText(mList.get(position).getHealth().getRate());
        holder.tvGiamSat.setText(mList.get(position).getWorker().getFullName());
    }

    @Override
    public int getItemCount() {
        return mList!=null?mList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvThoiGian;
        private TextView tvTinhTrang;
        private TextView tvNote;
        private TextView tvGiamSat;
        public ViewHolder(View itemView) {
            super(itemView);
            tvNote = (TextView)itemView.findViewById(R.id.tvNote);
            tvGiamSat = (TextView)itemView.findViewById(R.id.tvGiamSat);
            tvTinhTrang= (TextView)itemView.findViewById(R.id.tvTinhtrang);
            tvThoiGian = (TextView)itemView.findViewById(R.id.tvThoiGian);
        }
    }
}
