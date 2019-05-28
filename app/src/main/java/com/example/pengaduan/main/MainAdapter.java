package com.example.pengaduan.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pengaduan.FormModel;
import com.example.pengaduan.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.RecyclerViewAdapter> {

    Context context;
    List<FormModel> forms;
    ItemCLickListener itemCLickListener;

    public MainAdapter(Context context, List<FormModel> forms, ItemCLickListener itemCLickListener) {
        this.context = context;
        this.forms = forms;
        this.itemCLickListener = itemCLickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);

        return new RecyclerViewAdapter(view, itemCLickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {

        FormModel formModel = forms.get(position);

        holder.kategori.setText(formModel.getKategori());
        holder.tanggal.setText(formModel.getTanggal());
        holder.tanya.setText(formModel.getMasalah());

    }

    @Override
    public int getItemCount() {
        return forms.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cardView;
        TextView kategori, tanggal, tanya, tanggapan;
        ItemCLickListener itemCLickListener;

        public RecyclerViewAdapter(@NonNull View itemView, ItemCLickListener itemCLickListener) {
            super(itemView);


            kategori = itemView.findViewById(R.id.tv_kategori);
            tanggal = itemView.findViewById(R.id.tv_tanggal);
            tanya = itemView.findViewById(R.id.tv_tanya);
            cardView = itemView.findViewById(R.id.cardView);

            this.itemCLickListener = itemCLickListener;
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemCLickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface ItemCLickListener {
        void onItemClick(View view, int position);
    }
}
