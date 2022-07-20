package com.example.a05androidpemula;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


public class ListCarAdapter extends RecyclerView.Adapter<ListCarAdapter.ListViewHolder> {
    private CarManager cm;
    public ListCarAdapter(CarManager cm) {
        this.cm = cm;
    }
    public void addCar(Car car) {
        cm.addCar(car);
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_pasien,parent,false);
        return new ListViewHolder(view);
    }
    @Override
    public int getItemCount() {
        return cm.getCarList().size();
    }
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Car car = cm.getCarList().get(position);

        holder.tvName.setText(car.getNama());
        holder.tvDetail.setText(car.getDetail());
        Glide.with(holder.itemView.getContext())
                .load(car.getFoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(e->{
            onItemClickCallback.onItemClicked(cm.getCarList()
                    .get(holder.getAdapterPosition()));
        });
    }


    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDetail;
        ImageView imgPhoto;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
    interface OnItemClickCallback {
        void onItemClicked(Car car);
    }
}
