package com.example.recipeapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView foodNameTextView;
    private TextView ingredientsTextView;
    private TextView instructionsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_details);

        imageView = findViewById(R.id.imageView);
        foodNameTextView = findViewById(R.id.foodNameTextView);
        ingredientsTextView = findViewById(R.id.ingredientsTextView);
        instructionsTextView = findViewById(R.id.instructionsTextView);

        // Retrieve the data passed from the HomeFragment or RecyclerViewAdapter
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int imageResource = extras.getInt("imageResource");
            String foodName = extras.getString("foodName");
            String ingredients = extras.getString("ingredients");
            String instructions = extras.getString("instructions");

            // Set the data in the views
            imageView.setImageResource(imageResource);
            foodNameTextView.setText(foodName);
            ingredientsTextView.setText(ingredients);
            instructionsTextView.setText(instructions);
        }
    }
}
