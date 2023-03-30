package com.mycompany.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Results;

public class LeerJSONName {

    public static Results  leerNombres1() throws IOException{
   Results results=null;
        ObjectMapper objectMapper = new ObjectMapper();
  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //SI NO EXISTE ATRIBUTO QUE EN JSON SI PASA DE ELLO

        try {
        
 results = objectMapper.readValue(new File("nombres.json"), Results.class);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
return results;
    } 
   
}
