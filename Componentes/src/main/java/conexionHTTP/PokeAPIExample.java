
package conexionHTTP;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PokeAPIExample {

    public static void leer(String nombre) throws MalformedURLException, IOException {
       
            // Crear la URL de la API
            String urlString = "https://pokeapi.co/api/v2/pokemon/";
            urlString = urlString+nombre; 
            URL url = new URL(urlString);
        //System.out.println(url);
            // Crear la conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta JSON
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // sobreescribe el fichero
            BufferedWriter fichero = new BufferedWriter(new FileWriter("pokemon.json"));
            String line;
            //StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                // response.append(line);
                fichero.write(line);
                fichero.newLine();

            }
            fichero.close();
            reader.close();

            // Imprimir la respuesta JSON
            //  System.out.println(response.toString());
    
    }
    
    public static void leer2() throws MalformedURLException, IOException {
       
            // Crear la URL de la API
            String urlString = "https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0";
            //urlString = urlString+nombre; 
            URL url = new URL(urlString);
        //System.out.println(url);
            // Crear la conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta JSON
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // sobreescribe el fichero
            BufferedWriter fichero = new BufferedWriter(new FileWriter("nombres.json"));
            String line;
            //StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                // response.append(line);
                fichero.write(line);
                fichero.newLine();

            }
            fichero.close();
            reader.close();

            // Imprimir la respuesta JSON
            //  System.out.println(response.toString());
    
    }
    
}
