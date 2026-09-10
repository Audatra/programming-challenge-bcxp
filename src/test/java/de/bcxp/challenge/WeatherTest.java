package de.bcxp.challenge;

import de.bcxp.challenge.weather.Weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
class WeatherTest {

    private Weather weather;

    @Test
    void testWeatherCreation() {
        weather = new Weather(1, 2, 3, 4.0d, 5.0d, 6, 7, 8.0d, 9, 10, 11.0d, 12, 13, 14.0d);
        assertEquals(1, weather.getDay());
        assertEquals(2, weather.getMxt());
        assertEquals(3, weather.getMnt());
        assertEquals(4.0d, weather.getAvt());
        assertEquals(5.0d, weather.getAvdp());
        assertEquals(6, weather.getTpcpn());
        assertEquals(7, weather.getPdir());
        assertEquals(8.0d, weather.getAvsp());
        assertEquals(9, weather.getDir());
        assertEquals(10, weather.getMxs());
        assertEquals(11.0d, weather.getSkyc());
        assertEquals(12, weather.getMxr());
        assertEquals(13, weather.getMnr());
        assertEquals(14.0d, weather.getAvslp());
    }

}
