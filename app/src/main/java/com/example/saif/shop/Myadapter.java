package com.example.saif.shop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

//this adapter is for listview customization for just_for_you tab

public class Myadapter extends RecyclerView.Adapter<Myadapter.Holderr> {

    private String[] data;
    private int[] img;

    public Myadapter(String[] data, int[] image) {
        this.data = data;
        this.img = image;
    }


    @NonNull
    @Override
    public Holderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_custom_listview, parent, false);

        return new Holderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holderr holder, int position) {

        String title = data[position];
        int image = img[position];

        holder.textView.setText(title);
        holder.textView.setBackgroundResource(image);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class Holderr extends RecyclerView.ViewHolder {

        TextView textView;

        public Holderr(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_id);
        }
    }
}

