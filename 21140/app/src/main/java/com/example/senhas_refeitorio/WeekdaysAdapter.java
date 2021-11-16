package com.example.senhas_refeitorio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class WeekdaysAdapter extends RecyclerView.Adapter<WeekdaysAdapter.ViewHolder> {
    private final Context context;
    private List<Weekdays> planetList = new ArrayList<>();

    public WeekdaysAdapter (Context context) {
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
        Weekdays weekday  = this.planetList.get(position);
        holder.textView.setText(weekday.getName());

        holder.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PlanetDetails.startActivity(PlanetsAdapter.this.context, planet.getId());
            }
        });



    }

    @Override
    public int getItemCount() {
        return this.planetList.size();
    }

    public void updateList(List<Weekdays> newList) {
        this.planetList = newList;
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
        public View getRoot() { return root; }
    }
}
