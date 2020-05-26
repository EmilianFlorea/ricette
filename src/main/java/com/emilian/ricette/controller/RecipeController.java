package com.emilian.ricette.controller;

import com.emilian.ricette.Bin;
import com.emilian.ricette.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = "/recipes", method = RequestMethod.POST)
    public ResponseEntity<Bin> createRecipe(@RequestBody Bin postBin){
        return new ResponseEntity<>(recipeService.addRecipe(postBin), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public ResponseEntity<List<Bin>> getAllRecipes() {
        return new ResponseEntity<>(recipeService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.GET)
    public  ResponseEntity<Bin> updateRecipe(@PathVariable Long recipeId){
        Bin responseBin = recipeService.getById(recipeId);
        if (responseBin!=null)
            return new ResponseEntity<>(responseBin,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.PUT)
    public ResponseEntity<Bin> updateRecipe(@RequestBody Bin putBin, @PathVariable Long recipeId){
        Bin responseBin = recipeService.updateRecipe(recipeId, putBin);
        if (responseBin!=null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.DELETE)
    public ResponseEntity<Bin> deleteRecipe(@PathVariable Long recipeId){
        recipeService.delete(recipeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
