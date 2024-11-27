package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Parser {
    public static WeatherApi parseApi (String response, WeatherApi weatherApi ) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.fromJson(response, WeatherApi.class);

    }
}
