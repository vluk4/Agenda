package br.com.alura.agenda;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by victo on 10/07/2018.
 */

public class WebClient {
    public String post(String json){

        try {
            URL url = new URL("https://www.caelum.com.br/mobile");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Accept", "aplication/json");
            connection.setRequestProperty("Content-type", "aplication/json");

            connection.setDoInput(true);
            connection.setDoOutput(true);

            PrintStream saida = new PrintStream(connection.getOutputStream());
            saida.println(json);

            connection.connect();

            return new Scanner(connection.getInputStream()).next();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
