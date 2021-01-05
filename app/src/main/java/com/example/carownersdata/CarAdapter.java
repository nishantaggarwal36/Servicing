package com.example.carownersdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>
{
   private ArrayList<Car> cars;
    ItemClicked activity;

    public interface ItemClicked{

         void Onitemclicked(int index);
}

    public CarAdapter(Context context, ArrayList<Car> list) {
        cars = list;
        activity = (ItemClicked) context;

    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_design, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int i) {

        holder.itemView.setTag(cars.get(i));
        holder.tvCar.setText(cars.get(i).getCarname());
        holder.tvName.setText(cars.get(i).getName());

        if(cars.get(i).getPreferences().equals("Mercedes")){
            holder.ivBrand.setImageResource(R.drawable.mercedes);
        }
        else if(cars.get(i).getPreferences().equals("Nissan")){
            holder.ivBrand.setImageResource(R.drawable.nissan);
        }
        else
            holder.ivBrand.setImageResource(R.drawable.volkswagen);

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBrand;
        TextView tvCar, tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivBrand = itemView.findViewById(R.id.ivPref);
            tvCar = itemView.findViewById(R.id.tvCar);
            tvName = itemView.findViewById(R.id.tvName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                     activity.Onitemclicked(cars.indexOf((Car) v.getTag()));

                }
            });


        }
    }
}
