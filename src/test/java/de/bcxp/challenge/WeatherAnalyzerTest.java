package de.bcxp.challenge;

import de.bcxp.challenge.config.WeatherConfig;
import de.bcxp.challenge.weather.WeatherAnalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
class WeatherAnalyzerTest {

    private String correctFilePath = "/de/bcxp/challenge/weather.csv";
    private String wrongFilePath = "/de/bcxp/challenge/nonexistent.csv";
    private WeatherConfig config = new WeatherConfig();
    private WeatherAnalyzer analyzerWithCorrectPath = config.weatherAnalyzer(correctFilePath);
    private WeatherAnalyzer analyzerWithWrongPath = config.weatherAnalyzer(wrongFilePath);

    @Test
    void testCountryAnalyzerWithCorrectPath() {
        assertEquals("14", analyzerWithCorrectPath.getDayWithSmallestTempSpread());
    }

    @Test
    void testCountryAnalyzerWithWrongPath() {
        assertEquals(null, analyzerWithWrongPath.getDayWithSmallestTempSpread());
    }

}
