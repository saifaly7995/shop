package com.example.saif.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragmentstore extends Fragment {
    View view;
    RecyclerView lv;

    //we get values(product id, name , price , description etc) from database and send to Adapterforstore class

    //this is data base for temporal period:
    String[] titles= {"PKR. 222","PKR. 333","PKR. 999","PKR. 987"};
    int[] images={R.drawable.items,R.drawable.items1,R.drawable.items2,R.drawable.itmes3};


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.store,container,false);
        lv=(RecyclerView) view.findViewById(R.id.store_list_id);



        lv.setLayoutManager(new GridLayoutManager(getContext(),2));
        lv.setAdapter(new AdapterForStore(titles,images));



        return view;
    }
}