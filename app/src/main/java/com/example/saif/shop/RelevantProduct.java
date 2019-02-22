package com.example.saif.shop;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RelevantProduct extends RecyclerView.Adapter<RelevantProduct.Holderr>{

    private String[] data;
    private int[] img;

    public RelevantProduct(String[] data,int[] image) {
        this.data=data;
        this.img=image;
    }


    @NonNull
    @Override
    public RelevantProduct.Holderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_layout,parent,false);

        return new RelevantProduct.Holderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelevantProduct.Holderr holder, int position) {

        String title=data[position];
        int image=img[position];

        holder.textView.setText(title);
        holder.imgView.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class Holderr extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imgView;

        public Holderr(@NonNull View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.text_price);
            imgView=(ImageView)itemView.findViewById(R.id.img_icon);
        }
    }
}


