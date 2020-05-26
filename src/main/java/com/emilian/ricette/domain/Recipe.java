package com.emilian.ricette.domain;

import com.emilian.ricette.Bin;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private Long recipeId;
    private String recipeName;
    private String author;
    private Integer preparationTime;
    private Integer serving;
    private List<String> ingredients;
    private String instructions;

    public Recipe(Long recipeId, String author, Integer preparationTime, Integer serving, ArrayList<String> ingredients, String instructions) {
        this.recipeId = recipeId;
        this.author = author;
        this.preparationTime = preparationTime;
        this.serving = serving;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getServing() {
        return serving;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = (ArrayList<String>) ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


}