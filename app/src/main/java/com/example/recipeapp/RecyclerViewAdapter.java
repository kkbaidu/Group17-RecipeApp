package com.example.recipeapp;

// Imports
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private List<RecipeItem> itemList;

    public RecyclerViewAdapter(List<RecipeItem> itemList) {
        this.itemList = itemList;
    }



    @NonNull
    @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_view, parent, false);
        return new MyViewHolder(view);
    } 

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RecipeItem item = itemList.get(position);
        holder.cardText.setText(item.getFoodName());
        holder.cardImage.setImageResource(item.getImageResource());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the clicked item
                RecipeItem clickedItem = itemList.get(holder.getAdapterPosition());

                // Open the RecipeDetailsActivity or RecipeDetailsFragment
                Intent intent = new Intent(v.getContext(), RecipeDetailsActivity.class);
                intent.putExtra("imageResource", clickedItem.getImageResource());
                intent.putExtra("foodName", clickedItem.getFoodName());
                intent.putExtra("ingredients", (CharSequence) clickedItem.getIngredients());
                intent.putExtra("instructions", (CharSequence) clickedItem.getInstructions());
                v.getContext().startActivity(intent);
            }
        });
    }

    private String setFoodName() {

        return null;
    }

    @Override
    // overide the getItemCount
    public int getItemCount() {
        return itemList.size();
    }

    // RecyclerView class 
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardImage;
        public TextView cardText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
            cardText = itemView.findViewById(R.id.cardText);
        }
    }
}
