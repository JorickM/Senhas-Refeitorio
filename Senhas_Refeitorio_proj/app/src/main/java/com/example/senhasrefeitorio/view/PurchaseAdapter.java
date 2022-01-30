package com.example.senhasrefeitorio.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.PurchaseWithMeal;
import com.example.senhasrefeitorio.model.Weekday;

import java.util.ArrayList;
import java.util.List;

public class PurchaseAdapter extends RecyclerView.Adapter<PurchaseAdapter.ViewHolder>{

    private final Context context;
    private List<PurchaseWithMeal> purchaseList = new ArrayList<>();

    public PurchaseAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PurchaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.purchase_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseAdapter.ViewHolder holder, int position) {
        PurchaseWithMeal purchase = this.purchaseList.get(position);

        holder.txtPurchMeal1.setText(purchase.getMealWithWeekday().getMeal().getMainDish());
        holder.txtPurchWeekday1.setText(purchase.getMealWithWeekday().getWeekday().getDate());

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mostrar qr code
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.purchaseList.size();
    }

    public void updateList(List<PurchaseWithMeal> newList) {
        this.purchaseList = newList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View root;
        TextView txtPurchWeekday1;
        TextView txtPurchMeal1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.root = itemView;
            this.txtPurchWeekday1 = this.root.findViewById(R.id.txtPurchWeekday);
            this.txtPurchMeal1 = this.root.findViewById(R.id.txtPurchMeal);
        }
    }
}