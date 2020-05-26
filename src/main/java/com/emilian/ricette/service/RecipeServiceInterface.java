package com.emilian.ricette.service;

import com.emilian.ricette.Bin;

import java.util.List;

public interface RecipeServiceInterface {

    public Bin addRecipe(Bin inBin);
    public Bin getById(Bin inBin);
    public List<Bin> getRecipeList();
    public Bin updateRecipe(Bin inBin);
    public void delete(Bin inBin);

}
