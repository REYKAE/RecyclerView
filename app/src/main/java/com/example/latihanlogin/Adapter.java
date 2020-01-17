package com.example.latihanlogin;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Siswa> rvData;

    public Adapter(ArrayList<Siswa>rvData){
        this.rvData = rvData;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        Log.e("","onBindViewHolder:"+ rvData.get(position).getNama());
        holder.siswa(rvData.get(position));
    }

    @Override
    public int getItemCount() {
        Log.e("", "getItemCount:" + rvData.size());
        return rvData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvnama;
        public TextView tvkelas;
        public TextView tvalamat;
        public ViewHolder(View itemView) {
            super(itemView);
            tvnama = (TextView) itemView.findViewById(R.id.nama);
            tvkelas = (TextView) itemView.findViewById(R.id.kelas);
            tvalamat = (TextView) itemView.findViewById(R.id.alamat);
        }
        public void siswa(Siswa siswa){
            Log.e("", "siswa:"+siswa.getNama());
            tvnama.setText(siswa.nama);
            tvkelas.setText(siswa.kelas);
            tvalamat.setText(siswa.alamat);
        }
    }
}
