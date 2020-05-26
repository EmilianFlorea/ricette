package com.emilian.ricette.domain;

import com.emilian.ricette.Bin;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private Long recipeId;
    private String author;
    private Integer preparationTime;
    private Integer serving;
    private ArrayList<String> ingredients;
    private String instructions;

    public Recipe(Bin recipeBin){
        this.recipeId = recipeBin.id;
        this.author = recipeBin.author;
        this.preparationTime = recipeBin.preparationTime;
        this.serving = recipeBin.serving;
        this.ingredients = new ArrayList<>(recipeBin.ingredients);
        this.instructions = recipeBin.instructions;
    }

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


    public Bin getBin() {
        Bin bin = new Bin();
        bin.id = this.getRecipeId();
        bin.author = this.getAuthor();
        bin.preparationTime = this.getPreparationTime();
        bin.serving = this.getServing();
        bin.ingredients = (ArrayList<String>) this.getIngredients();
        bin.instructions = this.getInstructions();
        return bin;
    }

    public Bin updateRecipe(Bin updateBin){
       if (updateBin.author!=null)
           this.setAuthor(updateBin.author);
       if (updateBin.preparationTime > 0)
           this.setPreparationTime(updateBin.preparationTime);
       if (updateBin.serving > 0)
           this.setServing(updateBin.serving);
        if (updateBin.ingredients.size()>0)
            this.setIngredients(updateBin.ingredients);
        if (instructions!=null)
            this.setInstructions(updateBin.instructions);

        return getBin();
    }

}