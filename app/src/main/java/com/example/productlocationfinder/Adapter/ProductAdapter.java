package com.example.productlocationfinder.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productlocationfinder.Model.ProductModel;
import com.example.productlocationfinder.ProductDetailsActivity;
import com.example.productlocationfinder.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    Context context;
    List<ProductModel> productModels = new ArrayList<ProductModel>();

    public ProductAdapter(Context context, List<ProductModel> productModels) {
        this.context = context;
        this.productModels = productModels;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder viewHolder, int i) {
            ProductModel productModel=productModels.get(i);
            viewHolder.tv_name.setText(productModel.getName());

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, ProductDetailsActivity.class);
                    intent.putExtra("name",productModel.getName());
                    intent.putExtra("price",productModel.getPrice());
                    intent.putExtra("model_no",productModel.getModel_no());
                    intent.putExtra("date",productModel.getPurchase_date());
                    intent.putExtra("wall",productModel.getWall_number());
                    intent.putExtra("rack",productModel.getRack_number());
                    intent.putExtra("section",productModel.getSection());
                    intent.putExtra("box",productModel.getBox());
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public void filterList(List<ProductModel> filterdNames) {
        this.productModels = filterdNames;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        public ViewHolder(View view) {
            super(view);
            tv_name=view.findViewById(R.id.tv_name);
        }
    }
}
