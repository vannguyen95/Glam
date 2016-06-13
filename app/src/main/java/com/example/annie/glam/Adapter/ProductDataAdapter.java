package com.example.annie.glam.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.annie.glam.Models.Product;
import com.example.annie.glam.R;

import java.util.List;

/**
 * Created by SONY on 6/12/2016.
 */
public class ProductDataAdapter extends RecyclerView.Adapter {
    Context context;
    List<Product> productsList;

    public ProductDataAdapter(Context context, List<Product> productsList) {
        this.context = context;
        this.productsList = productsList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_favorite_recycler_view_cell,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(context).load(productsList.get(position).getFeaturedSrc()).into(((ViewHolder) holder).productPhoto);
        ((ViewHolder) holder).productName.setText(productsList.get(position).getTitle());
        ((ViewHolder) holder).price.setText(productsList.get(position).getSalePrice()+ " $ ");
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static ImageView productPhoto;
        public static TextView productName;
        public static TextView price;
        public static Button add;

        public ViewHolder(View itemView) {
            super(itemView);
            productPhoto = (ImageView) itemView.findViewById(R.id.iv_product_onsale_cell);
            Log.d("productPhotoID",String.valueOf(R.id.iv_product_onsale_cell));
            productName = (TextView) itemView.findViewById(R.id.tv_product_name_onsale_cell);
            price = (TextView) itemView.findViewById(R.id.tv_price_onsale_cell);
           add=(Button)itemView.findViewById(R.id.btn_add_onsale_cell);

        }
    }
}
