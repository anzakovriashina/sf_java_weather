package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Введите Широту: (например: 43.1056 (широта Владивостока))");
            String lat = scanner.nextLine();
            System.out.println("Введите Долготу: (например: 131.874 (долгота Владивостока))");
            String lon = scanner.nextLine();
            System.out.println("Введите количество дней, за которое необходимо получить среднее арифметическое температуры: (например 5)");
            int limit = scanner.nextInt();
            Weather weather = new Weather(lat, lon, limit);
            System.out.println("Широта: " + lat + " Долгота: " + lon + " Количество дней: " + limit);
            System.out.println("Температура в населенном пункте " + weather.getLocation() + ": " + weather.getTemp() + "° по Цельсию");
            System.out.println("Средняя температура в дневное время за " + limit + " дня/дней: " + weather.getForecastsAvg() + "° по Цельсию");
        }

        catch (InputMismatchException e){
            System.out.println("Некорректный ввод. Попробуйте еще раз!");
        }

    }
}