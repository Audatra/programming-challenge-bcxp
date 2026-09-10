package de.bcxp.challenge;

import de.bcxp.challenge.country.Country;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
class CountryTest {

    private Country country;

    @Test
    void testCountryCreation() {
        country = new Country("Name", "Capital", "Accession", 1, 2, 3, 4.0d, 5);
        assertEquals("Name", country.getName());
        assertEquals("Capital", country.getCaptial());
        assertEquals("Accession", country.getAccession());
        assertEquals(1, country.getPopulation());
        assertEquals(2, country.getArea());
        assertEquals(3, country.getGdp());
        assertEquals(4.0d, country.getHdi());
        assertEquals(5, country.getMeps());
    }

}
