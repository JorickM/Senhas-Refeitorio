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

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder>{

    private final Context context;
    private List<Meal> mealList = new ArrayList<>();

    public MealAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.meal_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealAdapter.ViewHolder holder, int position) {
        Meal meal = this.mealList.get(position);
        holder.textViewMeal.setText(meal.getMainDish());
        holder.textViewSoup.setText(meal.getSoup());
        holder.textViewDesert.setText(meal.getDessert());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mealList.size();
    }

    public void updateList(List<Meal> newList) {
        this.mealList = newList;
        notifyDataSetChanged();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    View root;
    TextView textViewMeal;
    TextView textViewSoup;
    TextView textViewDesert;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        this.root = itemView;
        this.textViewMeal = this.root.findViewById(R.id.txtMeal);
        this.textViewSoup = this.root.findViewById(R.id.txtSoup);
        this.textViewDesert = this.root.findViewById(R.id.txtDesert);
    }
}
}