package com.example.senhasrefeitorio.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senhasrefeitorio.R;
import com.example.senhasrefeitorio.model.PurchaseWithMeal;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;
import java.util.List;

public class ConsumedPurchaseAdapter extends RecyclerView.Adapter<ConsumedPurchaseAdapter.ViewHolder> {
    private final Context context;
    private List<PurchaseWithMeal> purchaseList = new ArrayList<>();

    public ConsumedPurchaseAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ConsumedPurchaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.purchase_item, parent, false);
        return new ConsumedPurchaseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsumedPurchaseAdapter.ViewHolder holder, int position) {
        PurchaseWithMeal purchase = this.purchaseList.get(position);

        holder.txtPurchMeal1.setText(purchase.getMealWithWeekday().getMeal().getMainDish());
        holder.txtPurchWeekday1.setText(purchase.getMealWithWeekday().getWeekday().getDate());

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MultiFormatWriter writer = new MultiFormatWriter();

                    BitMatrix matrix = writer.encode(purchase.getMealWithWeekday().getMeal().getMainDish() + " " + purchase.getMealWithWeekday().getWeekday().getDate(), BarcodeFormat.QR_CODE, 100, 100);

                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(matrix);

                    holder.imgQrCode.setImageBitmap(bitmap);
                }catch (Exception e){

                }
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
        ImageView imgQrCode;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.root = itemView;
            this.txtPurchWeekday1 = this.root.findViewById(R.id.txtPurchWeekday);
            this.txtPurchMeal1 = this.root.findViewById(R.id.txtPurchMeal);
            this.imgQrCode = this.root.findViewById(R.id.imageView2);
        }
    }
}
