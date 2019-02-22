package com.example.saif.shop;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterForStore  extends RecyclerView.Adapter<AdapterForStore.Holderforstore>{

    //here we declare attributes for the values we get from database and set in recyclerview
    private String[] data;
    private int[] img;
    private View.OnClickListener clickListener;

    ImageView imageView;

    public AdapterForStore(String[] data,int[] image) {
        this.data=data;
        this.img=image;

    }


    @NonNull
    @Override
    public AdapterForStore.Holderforstore onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.store_layout,parent,false);



        return new AdapterForStore.Holderforstore(view);
    }




    @Override
    public void onBindViewHolder(@NonNull AdapterForStore.Holderforstore holder, int position) {


        final String title=data[position];
        int image=img[position];


        //this is click listner for opening new activity in which user can view the details of clicked product
        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(v.getContext(),viewProduct.class);
                intent.putExtra("position",position);
                intent.putExtra("title",title);
                v.getContext().startActivity(intent);
            }
        });

        //here we set values to their views for recyclerview
        holder.imgView.setImageResource(image);
        holder.textView.setText(title);


    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class Holderforstore extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView textView;
        ImageView imgView;
        private ItemClickListner itemClickListner;

        public Holderforstore(@NonNull View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.text_price);
            imgView=(ImageView) itemView.findViewById(R.id.img_icon);
            itemView.setOnClickListener(this);

        }

        public void setItemClickListner(ItemClickListner itemClickListner){
            this.itemClickListner=itemClickListner;
        }

        @Override
        public void onClick(View v) {
                itemClickListner.onClick(v,getAdapterPosition());
        }

    }


}

