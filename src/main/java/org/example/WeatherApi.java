package org.example;

public class WeatherApi {
    public String now_dt;
    public Fact fact;
    public Info info;
    public Forecasts[] forecasts;

    class Forecasts {
        public String sunrise;
        public Parts parts;
        class Parts {
            public Day day;
            class Day {
                public String temp_avg;
            }
        }
    }
    static class Info {
        public Tzinfo tzinfo;
        class Tzinfo {
            public String name;
        }
    }
    class Fact {
        public String temp;
    }
}