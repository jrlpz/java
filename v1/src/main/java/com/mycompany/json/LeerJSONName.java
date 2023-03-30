package com.mycompany.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import model.Pokemon;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Name;
import model.Results;

public class LeerJSONName {
 //private static Pokemon pokemon;
    public static Results  leerNombres1() throws IOException{
   Results results=null;
        ObjectMapper objectMapper = new ObjectMapper();
  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //SI NO EXISTE ATRIBUTO QUE EN JSON SI PASA DE ELLO
//File file = new File("pokemon.json");
//String absolutePath = file.getAbsolutePath();
//System.out.println(absolutePath);
        try {
            // Lee el archivo JSON y lo mapea a la clase Person
 results = objectMapper.readValue(new File("C:\\Users\\javir\\Documents\\NetBeansProjects\\Componentes\\nombres.json"), Results.class);

        
//name = objectMapper.readValue(new File("C:\\Users\\javir\\Documents\\NetBeansProjects\\Componentes\\nombres.json"), Name.class);
//results = objectMapper.readValue(new File("C:\\Users\\javir\\Documents\\NetBeansProjects\\Componentes\\nombres.json"), Results.class);
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
return results;
    } 
   
}
