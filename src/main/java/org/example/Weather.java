package org.example;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Weather {
    static String lat;
    static String lon;
    static int limit;
    String resp;
    WeatherApi weatherApi = new WeatherApi();

    public Weather(String lat, String lon, int limit) throws JsonProcessingException, JsonMappingException, JsonParseException {
        this.lat = lat;
        this.lon = lon;
        this.limit = limit;
        this.resp = sendHttpRequest();
        this.weatherApi = Parser.parseApi(resp, weatherApi);
    }
    public String sendHttpRequest() {
        HttpClient httpClient = HttpClient.newHttpClient();
        URI uri = URI.create("https://api.weather.yandex.ru/v2/forecast?lat=" + lat + "&lon=" + lon + "&limit=" + limit);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .header("X-Yandex-Weather-Key", ApiKey.getApiToken())
                .build();
        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Полный ответ от сервера: " + response.body());
            return response.body();

        } catch (Exception e) {
            return "Error occurred while sending GET request: " + e.getMessage();
        }
    }

    public String getLocation() {
        return weatherApi.info.tzinfo.name;
    }
    public String getTemp() {
        return weatherApi.fact.temp;
    }

    public Integer getForecastsAvg() {
        int days = 0;
        int sum = 0;
        for ( int i=0; i < weatherApi.forecasts.length; i++) {
            days++;
            sum += Integer.parseInt(weatherApi.forecasts[i].parts.day.temp_avg);
        }
        return sum / days;
    }
}
