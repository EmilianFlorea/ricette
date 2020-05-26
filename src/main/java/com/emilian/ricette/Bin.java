package com.emilian.ricette;

import com.emilian.ricette.resource.model.RicettaDettaglioResource;
import com.emilian.ricette.resource.model.RicettaResource;

public class Bin {

    public Long recipeId;
    public RicettaDettaglioResource dettaglioResource;
    public RicettaResource ricettaResource;

    public Bin(Long recipeId, RicettaDettaglioResource dettaglioResource, RicettaResource ricettaResource) {
        this.recipeId = recipeId;
        this.dettaglioResource = dettaglioResource;
        this.ricettaResource = ricettaResource;
    }

}
