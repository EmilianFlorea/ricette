package com.emilian.ricette.controller;

import com.emilian.ricette.Bin;
import com.emilian.ricette.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.lang.annotation.Repeatable;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = "/recipes", method = RequestMethod.POST)
    public ResponseEntity createRecipe(@RequestBody Bin postBin){
        return new ResponseEntity (recipeService.addRecipe(postBin),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public ResponseEntity getAllRecipes() {
        return new ResponseEntity(recipeService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.PUT)
    public  ResponseEntity updateRecipe(@PathVariable Long recipeId){
        Bin responseBin = recipeService.getById(recipeId);
        if (responseBin!=null)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteRecipe(@PathVariable Long recipeId){
        recipeService.delete(recipeId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
