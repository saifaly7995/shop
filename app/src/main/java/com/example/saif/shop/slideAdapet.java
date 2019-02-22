package com.example.saif.shop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class slideAdapet extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    String[] slidetitles= {"PKR. 222","PKR. 333","PKR. 999","PKR. 987"};

    int[] slideImages={R.drawable.items,R.drawable.items1,R.drawable.items2,R.drawable.itmes3};

    public slideAdapet(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slideImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == (CoordinatorLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_view_product,container,false);

        TextView tv= (TextView)view.findViewById(R.id.price);
        ViewPager viewPager=(ViewPager) view.findViewById(R.id.id_pagerslider);


        int pos=0;
        Intent intent = ((Activity) context).getIntent();
        int i=intent.getIntExtra("position", pos);


        viewPager.setBackgroundResource(slideImages[i]);
        tv.setText(slidetitles[i]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((CoordinatorLayout)object);
    }
}
