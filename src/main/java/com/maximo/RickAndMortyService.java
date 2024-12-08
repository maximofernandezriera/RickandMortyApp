package com.maximo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RickAndMortyService {

    private static final String BASE_URL = "https://rickandmortyapi.com/api/character/";

    public ApiResponse getCharacters(int page) throws IOException {
        String urlString = BASE_URL + "?page=" + page;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Error: " + conn.getResponseCode());
        }

        Scanner sc = new Scanner(url.openStream());
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(sb.toString(), ApiResponse.class);
    }
}
