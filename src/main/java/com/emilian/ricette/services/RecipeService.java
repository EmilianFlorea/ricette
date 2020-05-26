package com.emilian.ricette.services;

import com.emilian.ricette.Bin;
import com.emilian.ricette.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class RecipeService {

    private final AtomicLong counter = new AtomicLong();
    private final HashMap<Long, Recipe> recipesList = new HashMap<>();

    public Bin addRecipe(Bin postBin) {
        long id = counter.incrementAndGet();
        postBin.id = id;
        Recipe recipe = new Recipe(postBin);
        recipesList.put(id, new Recipe(postBin));
        return recipe.getBin();
    }

    public Bin getById(Long id) {
        if (recipesList.containsKey(id))
            return recipesList.get(id).getBin();
        else
            return null;
    }

    public List<Bin> getAll(){
        ArrayList<Bin> allRecipes = new ArrayList<>();
        for (Map.Entry<Long, Recipe> entry : recipesList.entrySet()) {
            Recipe v = entry.getValue();
            allRecipes.add(v.getBin());
        }

        return allRecipes;
    }



    //TODO: da implementare
    public Bin updateRecipe(Long id, Bin recipe) {
        if (recipesList.containsKey(id))
            return recipesList.get(id).updateRecipe(recipe);
        else
            return null;
    }

    public void delete(Long id) {
        recipesList.remove(id);
    }
}
