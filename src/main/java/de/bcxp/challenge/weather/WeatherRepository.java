package de.bcxp.challenge.weather;

import java.util.List;

public interface WeatherRepository{

    public Weather getWeatherByDay(int day);
    public List<Weather> getWeatherEntries();
}
