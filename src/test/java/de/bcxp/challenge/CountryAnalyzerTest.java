package de.bcxp.challenge;

import de.bcxp.challenge.config.CountryConfig;
import de.bcxp.challenge.country.CountryAnalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
class CountryAnalyzerTest {

    private String correctFilePath = "/de/bcxp/challenge/countries.csv";
    private String wrongFilePath = "/de/bcxp/challenge/nonexistent.csv";
    private CountryConfig config = new CountryConfig();
    private CountryAnalyzer analyzerWithCorrectPath = config.countryAnalyzer(correctFilePath);
    private CountryAnalyzer analyzerWithWrongPath = config.countryAnalyzer(wrongFilePath);

    @Test
    void testCountryAnalyzerWithCorrectPath() {
        assertEquals("Malta", analyzerWithCorrectPath.getCountryWithHighestPopulationDensity());
    }

    @Test
    void testCountryAnalyzerWithWrongPath() {
        assertEquals(null, analyzerWithWrongPath.getCountryWithHighestPopulationDensity());
    }

}
