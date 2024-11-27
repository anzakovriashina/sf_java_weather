package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiKey {
    public static String getApiToken() {
        try {
            Properties property = new Properties();
            FileInputStream token = new FileInputStream("src/main/resources/config.properties");
            property.load(token);
            return property.getProperty("X_YANDEX_WEATHER_KEY");
        } catch (IOException e) {
            return "ERROR: Файл с токеном отсуствует!";
        }
    }
}
