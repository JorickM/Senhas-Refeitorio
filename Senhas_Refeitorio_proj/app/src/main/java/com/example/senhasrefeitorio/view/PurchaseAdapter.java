package com.example.senhasrefeitorio.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.model.Purchase;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.model.Weekday;

import java.util.ArrayList;
import java.util.List;

public class PurchaseAdapter extends RecyclerView.Adapter<PurchaseAdapter.ViewHolder>{

    private final Context context;
    private List<Purchase> purchaseList = new ArrayList<>();
    private PurchaseNavigator navigator;

    public PurchaseAdapter(Context context, PurchaseNavigator navigator) {
        this.context = context;
        this.navigator = navigator;
    }

    @NonNull
    @Override
    public PurchaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.purchase_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseAdapter.ViewHolder holder, int position) {

        User user;
        Meal meal;
        Weekday weekday;
        Purchase purchase = this.purchaseList.get(position);


        //tentar fazer o observe(ou arranjar outra solução)
        //mostrar o weekday e a meal mas para isso é preciso fazer o observe....

        holder.textViewMeal.setText(Long.toString(purchase.getMealId()));
        //holder.textViewWeekday.setText(weekday.getDate());

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

    public void updateList(List<Purchase> newList) {
        this.purchaseList = newList;
        notifyDataSetChanged();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    View root;
    TextView textViewMeal;
    TextView textViewWeekday;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        this.root = itemView;
        //trocar nomes
        this.textViewMeal = this.root.findViewById(R.id.txtPurchMeal);
        this.textViewWeekday = this.root.findViewById(R.id.txtPurchWeekday);
    }
}
    public interface PurchaseNavigator{
        void goToPurchaseDetails(long codPurchase);
    }
}