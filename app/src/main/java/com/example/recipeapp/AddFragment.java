package com.example.recipeapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class AddFragment extends Fragment  {

    private static final int PICK_IMAGE_REQUEST = 1;

    private Button saveButton;
    private EditText editTextFoodName;
    private EditText editTextIngredients;
    private EditText editTextInstructions;
    private ImageButton addImage;
    private Uri selectedImageUri;

    public AddFragment() {
        // Required empty public constructor
    }


    public interface OnRecipeAddedListener {
        void onRecipeAdded(RecipeItem item);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        saveButton = view.findViewById(R.id.saveButton);
        editTextFoodName = view.findViewById(R.id.editTextFoodName);
        editTextIngredients = view.findViewById(R.id.editTextIngredients);
        editTextInstructions = view.findViewById(R.id.editTextInstructions);
        addImage = view.findViewById(R.id.addImage);



        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodName = editTextFoodName.getText().toString();
                String ingredients = editTextIngredients.getText().toString();
                String instructions = editTextInstructions.getText().toString();

                if (foodName.isEmpty() || ingredients.isEmpty() || instructions.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedImageUri == null) {
                    Toast.makeText(getActivity(), "Please select an image", Toast.LENGTH_SHORT).show();
                    return;
                }


                RecipeItem item = new RecipeItem(foodName, ingredients, instructions, selectedImageUri.toString());


                HomeFragment homeFragment = (HomeFragment) getParentFragment();
                if (homeFragment != null) {
                    homeFragment.addNewItem(item);
                }

            }
        });

        return view;
    }


    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();
            addImage.setImageURI(selectedImageUri);
        }
    }
}