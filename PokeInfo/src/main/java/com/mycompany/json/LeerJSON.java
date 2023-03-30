package com.mycompany.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import model.Pokemon;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LeerJSON {

    public static Pokemon leerPokemon() throws IOException{
        Pokemon pokemon = null;
        ObjectMapper objectMapper = new ObjectMapper();
  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //SI NO EXISTE ATRIBUTO QUE EN JSON SI PASA DE ELLO

        try {
        
 pokemon = objectMapper.readValue(new File("pokemon.json"), Pokemon.class);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
        return pokemon;
    } 
   
}
