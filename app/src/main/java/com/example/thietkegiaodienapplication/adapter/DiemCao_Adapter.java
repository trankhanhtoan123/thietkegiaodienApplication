package com.example.thietkegiaodienapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thietkegiaodienapplication.R;
import com.example.thietkegiaodienapplication.dao.NhanVatDAO;
import com.example.thietkegiaodienapplication.dao.UserDAO;
import com.example.thietkegiaodienapplication.model.NhanVat;
import com.example.thietkegiaodienapplication.model.User;

import java.util.List;

public class DiemCao_Adapter extends RecyclerView.Adapter<DiemCao_Adapter.ViewHolder> {
    List<NhanVat> nhanVats;
    Context context;

    public DiemCao_Adapter(List<NhanVat> nhanVats, Context context) {
        this.nhanVats = nhanVats;
        this.context = context;
    }

    @NonNull
    @Override
    public DiemCao_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_top, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiemCao_Adapter.ViewHolder holder, int position) {
        final NhanVat nhanVat = nhanVats.get(position);
        holder.tvstt.setText(String.valueOf(position+1));
        holder.tvten.setText(nhanVat.namenv);
        holder.tvdiem.setText(String.valueOf(nhanVat.diem));
    }

    @Override
    public int getItemCount() {
        return nhanVats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvstt,tvten,tvdiem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvstt=itemView.findViewById(R.id.tv_stt_Cao);
            tvten=itemView.findViewById(R.id.tv_Ten_Cao);
            tvdiem=itemView.findViewById(R.id.tv_Diem_Cao);

        }
    }
}
