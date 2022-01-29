package com.example.senhasrefeitorio.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.model.Purchase;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.model.database.AppDatabase;
import com.example.senhasrefeitorio.model.sharedpreferences.SessionManager;
import com.example.senhasrefeitorio.viewmodel.LoginFragmentViewModel;
import com.example.senhasrefeitorio.viewmodel.MealFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder>{

    private final Context context;
    private List<Meal> mealList = new ArrayList<>();
    private MealFragmentViewModel viewModel;

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

        User userFromLogin = SessionManager.getActiveSession(MealAdapter.this.context);
        //iewModel = new ViewModelProvider(this).get(MealFragmentViewModel.class);

        Meal meal = this.mealList.get(position);
        holder.textViewMeal.setText(meal.getMainDish());
        holder.textViewSoup.setText(meal.getSoup());
        holder.textViewDesert.setText(meal.getDesert());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MealAdapter.this.context);
                builder.setTitle("Comprar Senha");
                builder.setMessage("Tem a certeza que pretende comprar a senha para " + meal.getMainDish() + "?");
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Purchase purchase = new Purchase(0,meal.getCodMeal(),userFromLogin.getCodUser());
                        viewModel.addPurchase(purchase);
                        // chatList.remove(chat);
                       // notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

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