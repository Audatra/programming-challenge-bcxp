package de.bcxp.challenge.config;

import de.bcxp.challenge.fileHandling.CsvFileHandler;
import de.bcxp.challenge.weather.CsvWeatherRepository;
import de.bcxp.challenge.weather.WeatherAnalyzer;
import de.bcxp.challenge.weather.WeatherColumns;
import de.bcxp.challenge.weather.WeatherRepository;

public class WeatherConfig{

    private String filePath;
    private final char delimiter = ',';
    private final Class<? extends Enum<?>> headerEnum = WeatherColumns.class;

    public CsvFileHandler csvFileHandler(){
        return new CsvFileHandler(filePath, delimiter, headerEnum);
    }

    public WeatherRepository weatherRepository(){
        return new CsvWeatherRepository(csvFileHandler());
    }

    public WeatherAnalyzer weatherAnalyzer(String filePath){
        this.filePath = filePath;
        return new WeatherAnalyzer(weatherRepository());
    }

}
