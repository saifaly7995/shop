package com.example.saif.shop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragmentexplore  extends Fragment {
    View view;
    RecyclerView lv;

    String[] titles= {"Winter Arrivals","NICE hshsh","asaaffaaf","adafaffa"};
    int[] images={R.drawable.items,R.drawable.items1,R.drawable.items2,R.drawable.itmes3};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.explore,container,false);
        lv=(RecyclerView) view.findViewById(R.id.lisview_id_for_explore);

        lv.setLayoutManager(new LinearLayoutManager(getContext()));
        lv.setAdapter(new AdapterForExplore(titles,images));

        return view;
    }
}