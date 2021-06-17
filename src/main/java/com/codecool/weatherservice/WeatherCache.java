package com.codecool.weatherservice;

import com.codecool.weatherservice.modell.Quote;


public class WeatherCache {

    private static Quote quote;


    public WeatherCache(Quote quote) {
        this.quote = quote;
    }

    public static Quote getQuote() {
        return quote;
    }

    public static void setQuote(Quote quote) {
        WeatherCache.quote = quote;
    }
}
