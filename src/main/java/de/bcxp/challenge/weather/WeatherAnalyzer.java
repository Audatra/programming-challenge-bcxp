package de.bcxp.challenge.weather;

import java.util.Comparator;
import java.util.List;

public class WeatherAnalyzer{
    private WeatherRepository repository;

    public WeatherAnalyzer(WeatherRepository repository){
        this.repository = repository;
    }

    public String getDayWithSmallestTempSpread(){
        List<Weather> weatherEntries = repository.getWeatherEntries();
        if(weatherEntries == null || weatherEntries.size() == 0){
            System.out.println("Error");
            return null;
        }
        Weather entryWithSmallestSpread = weatherEntries.stream().min(Comparator.comparingInt(entry -> entry.getMxt() - entry.getMnt())).get();
        return Integer.toString(entryWithSmallestSpread.getDay());
    }
}
