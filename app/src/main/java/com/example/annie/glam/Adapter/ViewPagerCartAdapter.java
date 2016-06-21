package com.example.annie.glam.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.annie.glam.Activities.ProductDetailActivity;
import com.example.annie.glam.Models.Product;
import com.example.annie.glam.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 6/20/2016.
 */
public class ViewPagerCartAdapter extends PagerAdapter {

    Context context;

    List<Product> productList= new ArrayList<>();

    public ViewPagerCartAdapter(Context context, List<Product>productList) {
        this.context = context;
        this.productList=productList;
    }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.view_pager_cart_image, container, false);
        CardView cardView =(CardView)view.findViewById(R.id.card_view_container_cart);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("ID",productList.get(position).getId());
                intent.putExtra("price",productList.get(position).getPrice());//chua giai quyet dc sale price voi normal price
                context.startActivity(intent);
            }
        });
        ImageView imageProduct =(ImageView)view.findViewById(R.id.iv_product_cart);
        TextView productName=(TextView)view.findViewById(R.id.tv_product_name_cart);
        TextView productPrice=(TextView)view.findViewById(R.id.tv_price_cart);
        Glide.with(context).load(productList.get(position).getFeaturedSrc()).into(imageProduct);
        productName.setText(productList.get(position).getTitle());
        productName.setText(productList.get(position).getPrice());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        (container).removeView((View) object);
    }
}


