package com.example.saif.shop;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class viewProduct extends AppCompatActivity {

    private slideAdapet slide;
    View view;
    RecyclerView lv;

    String[] titles= {"PKR. 222","PKR. 232","PKR. 333","PKR. 987"};
    int[] images={R.drawable.items,R.drawable.items1,R.drawable.items2,R.drawable.itmes3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);






        lv=(RecyclerView)findViewById(R.id.id_relevantproduct);

        lv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        lv.setAdapter(new RelevantProduct(titles,images));


    }



}
