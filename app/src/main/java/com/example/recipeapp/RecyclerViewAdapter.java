package com.example.recipeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {



    int []arr;

    public RecyclerViewAdapter(int[] arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    // This the public function
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_view, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    } 

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.cardImage.setImageResource(arr[position]);
        holder.cardText.setText(setFoodName());
    }

    private String setFoodName() {

        return null;
    }

    @Override
    public int getItemCount() {

        return arr.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView cardImage;
        TextView cardText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
            cardText = itemView.findViewById(R.id.cardText);

        }
    }
}
