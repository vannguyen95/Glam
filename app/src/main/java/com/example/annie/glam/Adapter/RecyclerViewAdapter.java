package com.example.annie.glam.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.annie.glam.Model.Product;
import com.example.annie.glam.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 6/8/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    Context context;
    List<Product>productList= new ArrayList<>();

    public RecyclerViewAdapter (Context context,List<Product>productList)
    {
        this.context=context;
        this.productList=productList;
    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_cell_fragment,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Picasso.with(context).load(productList.get(position).getImage()).into(((ViewHolder)holder).imageViewProduct);
        ((ViewHolder)holder).textViewProductName.setText(productList.get(position).getName());
        ((ViewHolder)holder).textViewPrice.setText(productList.get(position).getGiaBD());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        static ImageView imageViewProduct;
        static TextView textViewProductName;
        static TextView textViewPrice;
        static Button buttonAdd;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewProduct=(ImageView)itemView.findViewById(R.id.image_view_product);
            textViewProductName=(TextView)itemView.findViewById(R.id.text_view_product_name);
            textViewPrice=(TextView)itemView.findViewById(R.id.text_view_price);
            buttonAdd=(Button)itemView.findViewById(R.id.button_add);
        }
    }
}
