package com.example.senhasrefeitorio.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.viewmodel.MealFragmentViewModel;
import com.example.senhasrefeitorio.viewmodel.PurchaseFragmentViewModel;

import java.util.List;


public class PurchaseFragment extends Fragment {

    private PurchaseFragmentViewModel mViewModel;
    private long codMeal;
    private Meal mealSelected;

    public PurchaseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_purchase, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(PurchaseFragmentViewModel.class);

        PurchaseFragmentArgs args = PurchaseFragmentArgs.fromBundle(getArguments());
        this.codMeal = args.getCodMeal();

        this.mViewModel.getOneMeal(codMeal).observe(getActivity(), new Observer<Meal>() {
            @Override
            public void onChanged(Meal meal) {
                mealSelected = meal;
            }
        });

        TextView txtMainDish, txtSoup, txtDesert;
        txtMainDish = view.findViewById(R.id.txtMainDishPurchase);
        txtSoup = view.findViewById(R.id.txtSoupPurchase);
        txtDesert = view.findViewById(R.id.txtDesertPurchase);

        txtMainDish.setText(mealSelected.getMainDish());
        txtSoup.setText(mealSelected.getSoup());
        txtDesert.setText(mealSelected.getDesert());

        ImageView imgFood = view.findViewById(R.id.imgFood);

        //Glide.with(this).load(mealSelected.getUrl()).into(imgFood);

        Button btnBack = view.findViewById(R.id.btnBack);
        Button btnBuy = view.findViewById(R.id.btnBuy);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = NavHostFragment.findNavController(PurchaseFragment.this);
                navController.navigate(R.id.action_purchaseFragment_to_weekDay );
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Comprar Senha");
                builder.setMessage("Tem a certeza que pretende comprar a senha para " + mealSelected.getMainDish() + "?");
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Comprar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     //   AppDatabase.getInstance(ChatAdapter.this.context).getChatDao().delete(chat);
                     //   chatList.remove(chat);
                     //   notifyDataSetChanged();



                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });










    }
}