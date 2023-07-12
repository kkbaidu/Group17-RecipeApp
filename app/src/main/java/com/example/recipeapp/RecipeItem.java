package com.example.recipeapp;


public class RecipeItem {
    private String foodName;
    private String ingredients;
    private String instructions;
    private int imageResource;

    public RecipeItem(String foodName, int imageResource) {
        this.foodName = foodName;
        this.imageResource = Integer.parseInt(String.valueOf(imageResource));
    }

    public RecipeItem(String foodName, String ingredients, String instructions, String imageResource) {
        this.foodName = foodName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.imageResource = Integer.parseInt(imageResource);
    }
    public String getFoodName() {
        return foodName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getImageResource() {
        return imageResource;
    }

}
