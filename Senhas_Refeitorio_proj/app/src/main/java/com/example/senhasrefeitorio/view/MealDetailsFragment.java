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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.Meal;
import com.example.senhasrefeitorio.model.Purchase;
import com.example.senhasrefeitorio.model.User;
import com.example.senhasrefeitorio.model.sharedpreferences.SessionManager;
import com.example.senhasrefeitorio.viewmodel.MealDetailsFragmentViewModel;

public class MealDetailsFragment extends Fragment {
    private MealDetailsFragmentViewModel mViewModel;
    private long codMeal;

    TextView txtMainDish, txtSoup, txtDesert;

    String mealName, mealUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meal_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(MealDetailsFragmentViewModel.class);

        txtMainDish = view.findViewById(R.id.txtMainDishPurchase);
        txtSoup = view.findViewById(R.id.txtSoupPurchase);
        txtDesert = view.findViewById(R.id.txtDesertPurchase);

        ImageView imgFood = view.findViewById(R.id.imgFood);

        try {
            MealDetailsFragmentArgs args = MealDetailsFragmentArgs.fromBundle(getArguments());
            this.codMeal = args.getCodMeal();

            this.mViewModel.getOneMeal(codMeal).observe(getActivity(), new Observer<Meal>() {
                @Override
                public void onChanged(Meal meal) {
                    txtMainDish.setText(meal.getMainDish());
                    txtSoup.setText(meal.getSoup());
                    txtDesert.setText(meal.getDesert());

                    mealName = meal.getMainDish();
                    mealUrl = meal.getUrl();

                    //Meal meal = meal; Não, dá, então arranjamos esta maneira
                }
            });
        }
        catch(Exception e) {
            Log.i("MEAL_DETAIL_FRAGMENT", "Error");
        }

        Button btnBack = view.findViewById(R.id.btnBack);
        Button btnBuy = view.findViewById(R.id.btnBuy);

        Glide.with(this).load(mealUrl).into(imgFood);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMenu();
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Comprar Senha");
                builder.setMessage("Tem a certeza que pretende comprar a senha para " + mealName + "?");
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Comprar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        User user = SessionManager.getActiveSession(getActivity());
                        Purchase newPurchase = new Purchase(0,codMeal, user.getCodUser(), false);
                        mViewModel.addPurchase(newPurchase);
                        dialog.dismiss();
                        goToMenu();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    private void goToMenu() {
        NavController navController = NavHostFragment.findNavController(MealDetailsFragment.this);
        navController.navigate(R.id.action_mealDetailsFragment_to_mainMenuFragment);
    }
}