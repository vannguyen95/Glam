package com.example.annie.glam.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.annie.glam.R;
import com.example.annie.glam.Models.ProductCategory;

import java.util.List;

/**
 * Created by Nam Nguyen on 12/05/2016.
 */
public class CategoryListAdapter extends android.support.v7.widget.RecyclerView.Adapter {

    public static final String CAT_NAME = "com.example.namnguyen.recyclerviewide.CAT_NAME";
    List<ProductCategory> mDataset;
    //
    Context context;

    public CategoryListAdapter(Context context, List<ProductCategory> mDataset) {
        this.mDataset = mDataset;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_category_list, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).tv1.setText(mDataset.get(position).getName());
        ((ViewHolder) holder).tv2.setText(mDataset.get(position).getDescription());
        ((ViewHolder) holder).tv3.setText(" ( " + (mDataset.get(position).getCount()).toString() + " )");
        Glide.with(context).load(mDataset.get(position).getImage()).into(((ViewHolder) holder).img);
//        ((ViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ProductListActivity.class);
//                intent.putExtra(CategoryListAdapter.CAT_ID,mDataset.get(position).getId());
//                intent.putExtra(CategoryListAdapter.CAT_NAME, mDataset.get(position).getName());
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv1, tv2, tv3;
        public ImageView img;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.text_view_category_name);
            tv2 = (TextView) itemView.findViewById(R.id.text_view_description);
            tv3 = (TextView) itemView.findViewById(R.id.text_view_category_count);
            img = (ImageView) itemView.findViewById(R.id.imv_category);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

}
