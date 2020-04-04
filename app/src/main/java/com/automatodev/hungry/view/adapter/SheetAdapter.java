package com.automatodev.hungry.view.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.automatodev.hungry.R;
import com.automatodev.hungry.model.entity.SheetEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.List;

public class SheetAdapter extends RecyclerView.Adapter<SheetAdapter.DataHandler> {
    private List<SheetEntity> sheetEntities;
    private Activity context;

    public SheetAdapter(Activity context, List<SheetEntity> sheetEntities) {
        this.sheetEntities = sheetEntities;
        this.context = context;
    }

    @NonNull
    @Override
    public DataHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_sheets,parent, false);
        return new DataHandler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHandler holder, int position) {
        SheetEntity sheetEntity = sheetEntities.get(position);
        holder.txtSheet_layout.setText(sheetEntity.getSheetName());
        holder.txtTime_layout.setText(sheetEntity.getHour());
        holder.txtRecom_layout.setText(String.valueOf(sheetEntity.getRecomendation()));
        if (sheetEntity.isStatus()){
            holder.txtStatus_layout.setText("Aberto");
            holder.txtStatus_layout.setTextColor(Color.parseColor("#FF3D8C40"));
            holder.lblInfo_layout.setText("");
            holder.txtTime_layout.setText("");
        }else{
            holder.txtStatus_layout.setText("Fechado");
            holder.txtStatus_layout.setTextColor(Color.RED);
            holder.lblInfo_layout.setText("Abre ás");
            holder.txtTime_layout.setText(sheetEntity.getHour());
        }
        if (sheetEntity.isFav())
            holder.imgFav_layout.setImageResource(R.drawable.ic_favorite_red_28dp);

        holder.txtCat_layout.setText(sheetEntity.getTypeSheet());
        holder.imgSheet_layout.setImageResource(sheetEntity.getSheetImg());

    }

    @Override
    public int getItemCount() {
        return sheetEntities.size();
    }

    public class DataHandler extends RecyclerView.ViewHolder {
        private TextView txtCat_layout;
        private TextView txtRecom_layout;
        private TextView txtStatus_layout;
        private TextView lblInfo_layout;
        private TextView txtSheet_layout;
        private TextView txtTime_layout;
        private ImageView imgFav_layout;
        private ImageView imgSheet_layout;

        public DataHandler(@NonNull View itemView) {
            super(itemView);

            txtCat_layout  = itemView.findViewById(R.id.txtCat_layout);
            txtRecom_layout  = itemView.findViewById(R.id.txtRecom_layout);
            txtStatus_layout  = itemView.findViewById(R.id.txtStatus_layout);
            txtSheet_layout  = itemView.findViewById(R.id.txtSheet_layout);
            lblInfo_layout  = itemView.findViewById(R.id.lblInfo_layout);
            txtTime_layout  = itemView.findViewById(R.id.txtTime_layout);
            imgFav_layout  = itemView.findViewById(R.id.imgFav_layout);
            imgSheet_layout = itemView.findViewById(R.id.imgSheet_layout);

        }
    }
}
