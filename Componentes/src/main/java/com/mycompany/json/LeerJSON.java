package com.mycompany.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import model.Pokemon;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LeerJSON {
 //private static Pokemon pokemon;
    public static Pokemon leerPokemon() throws IOException{
        Pokemon pokemon = null;
        ObjectMapper objectMapper = new ObjectMapper();
  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //SI NO EXISTE ATRIBUTO QUE EN JSON SI PASA DE ELLO
//File file = new File("pokemon.json");
//String absolutePath = file.getAbsolutePath();
//System.out.println(absolutePath);
        try {
            // Lee el archivo JSON y lo mapea a la clase Persona
        
 pokemon = objectMapper.readValue(new File("C:\\Users\\javir\\Documents\\NetBeansProjects\\Componentes\\pokemon.json"), Pokemon.class);

 // Acceder al contenido de la clave "sprites"
//String dreamWorldDefault = pokemon.getSprites().getOther().getDream_world().getFront_default();
 //System.out.println("Creado: " + pokemon);
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
        return pokemon;
    } 
   
}
