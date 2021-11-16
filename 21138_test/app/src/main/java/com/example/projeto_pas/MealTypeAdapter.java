package com.example.projeto_pas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MealTypeAdapter extends RecyclerView.Adapter<MealTypeAdapter.ViewHolder> {
    private final Context context;
    private List<MealType> mealTypeList = new ArrayList<>();

    public MealTypeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.meal_type_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MealType mealType = this.mealTypeList.get(position);
        holder.textView.setText(mealType.getName());

        holder.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DetailsActivity.start(PlanetsAdapter.this.context, planet.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mealTypeList.size();
    }

    public void updateList(List<MealType> mealTypeList) {
        this.mealTypeList = mealTypeList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View root;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.root = itemView;
            this.textView = this.root.findViewById(R.id.textView);
        }
        public View getRoot(){
            return root;
        }
    }
}
