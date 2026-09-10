package de.bcxp.challenge;

import de.bcxp.challenge.config.CountryConfig;
import de.bcxp.challenge.config.WeatherConfig;
import de.bcxp.challenge.country.CountryAnalyzer;
import de.bcxp.challenge.weather.WeatherAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    private static final String countryFilePath = "/de/bcxp/challenge/countries.csv";
    private static final String weatherFilePath = "/de/bcxp/challenge/weather.csv";

    final static Logger logger = LoggerFactory.getLogger(App.class);

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        CountryConfig countryConfig = new CountryConfig();
        CountryAnalyzer countryAnalyzer = countryConfig.countryAnalyzer(countryFilePath);

        WeatherConfig weatherConfig = new WeatherConfig();
        WeatherAnalyzer weatherAnalyzer = weatherConfig.weatherAnalyzer(weatherFilePath);

        String dayWithSmallestTempSpread = weatherAnalyzer.getDayWithSmallestTempSpread();
        if(dayWithSmallestTempSpread == null){
            logger.warn("The day received from WeatherAnalyzer is null");
        }else{
            System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);
        }

        String countryWithHighestPopulationDensity = countryAnalyzer.getCountryWithHighestPopulationDensity();
        if(countryWithHighestPopulationDensity == null){
            logger.warn("The country received from CountryAnalyzer is null");
        }else{
            System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
        }
    }
}
