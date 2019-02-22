package com.example.saif.shop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterForExplore extends RecyclerView.Adapter<AdapterForExplore.HolderforExplore>{

private String[] data;
private int[] img;

public AdapterForExplore(String[] data,int[] image) {
        this.data=data;
        this.img=image;
        }


@NonNull
@Override
public AdapterForExplore.HolderforExplore onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.row_custom_listview_explore,parent,false);

        return new AdapterForExplore.HolderforExplore(view);
        }

@Override
public void onBindViewHolder(@NonNull AdapterForExplore.HolderforExplore holder, int position) {

        String title=data[position];
        int image=img[position];


        holder.textView.setText(title);
        holder.imgView.setImageResource(image);
        }

@Override
public int getItemCount() {
        return data.length;
        }

public class HolderforExplore extends RecyclerView.ViewHolder{

    TextView textView;
    ImageView imgView;

    public HolderforExplore(@NonNull View itemView) {
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.nameTxt);
        imgView=(ImageView) itemView.findViewById(R.id.img);
    }
}
}

