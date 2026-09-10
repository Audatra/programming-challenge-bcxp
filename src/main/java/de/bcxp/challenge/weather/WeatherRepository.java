package de.bcxp.challenge.weather;

import java.util.List;

/**
 * Stores Objects of the type Weather
*/
public interface WeatherRepository{

    /**
     * Get the weather entry from the provided day
     * @param day the day of the entry
     * @return the weather entry
     */
    public Weather getWeatherByDay(int day);

    /**
     * Get all weather entries
     * @return a list containing the weather entries
     */
    public List<Weather> getWeatherEntries();
}
