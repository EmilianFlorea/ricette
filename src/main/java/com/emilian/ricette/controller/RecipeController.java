package com.emilian.ricette.controller;

import com.emilian.ricette.Bin;
import com.emilian.ricette.RicetteApplication;
import com.emilian.ricette.resource.model.RicettaDettaglioResource;
import com.emilian.ricette.resource.model.RicettaResource;
import com.emilian.ricette.service.RecipeServiceInterface;
import com.emilian.ricette.services.RecipeServiceTest;
import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeServiceInterface recipeService;

    @RequestMapping(value = "/recipes", method = RequestMethod.POST)
    public ResponseEntity<RicettaDettaglioResource> createRecipe(@RequestBody RicettaDettaglioResource ricetta){
        Bin inBin = new Bin(null, ricetta, null);
        Bin outBin = recipeService.addRecipe(inBin);
        RicettaDettaglioResource responseResource = outBin.dettaglioResource;
        return new ResponseEntity<>(responseResource,HttpStatus.CREATED);
    }

    //Lista di bin oppure una lista dentro il bin?
    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public ResponseEntity<List<RicettaResource>> getAllRecipes() {
        List<Bin> binList = recipeService.getRecipeList();
        List<RicettaResource> responseResource= new ArrayList<RicettaResource>();
        for (Bin bin : binList) {
            responseResource.add(bin.ricettaResource);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.GET)
    public  ResponseEntity<RicettaDettaglioResource> updateRecipe(@PathVariable Long recipeId){

        Bin inBin = new Bin(recipeId,null,null);
        Bin outBin = recipeService.getById(inBin);
        RicettaDettaglioResource responseResource = outBin.dettaglioResource;

        if (responseResource!=null)
            return new ResponseEntity<>(responseResource, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.PUT)
    public ResponseEntity<RicettaDettaglioResource> updateRecipe(@RequestBody RicettaDettaglioResource modRicetta, @PathVariable Long recipeId){
        Bin inBin = new Bin(recipeId, modRicetta, null);
        Bin outBin = recipeService.updateRecipe(inBin);
        RicettaDettaglioResource responseResource = outBin.dettaglioResource;

        if (responseResource!=null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.DELETE)
    public ResponseEntity<Bin> deleteRecipe(@PathVariable Long recipeId){
        Bin inBin = new Bin(recipeId, null, null);
        recipeService.delete(inBin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
