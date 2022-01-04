package com.example.senhasrefeitorio.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senhasrefeitorio.R;

import java.util.ArrayList;
import java.util.List;

public class WeekdayAdapter extends RecyclerView.Adapter<WeekdayAdapter.ViewHolder>{

    private final Context context;
    private List<Weekday> weekdayList = new ArrayList<>();

    public WeekdayAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.weekday_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weekday weekday = this.weekdayList.get(position);
        holder.textViewName.setText(weekday.getName());
        holder.textViewDate.setText(weekday.getDate());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  MealListActivity.startActivity(context, Meals.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.weekdayList.size();
    }

    public void updateList(List<Weekday> newList) {
        this.weekdayList = newList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View root;
        TextView textViewName;
        TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.root = itemView;
            this.textViewName = this.root.findViewById(R.id.textViewName);
            this.textViewDate = this.root.findViewById(R.id.textViewDate);
        }
    }









}
