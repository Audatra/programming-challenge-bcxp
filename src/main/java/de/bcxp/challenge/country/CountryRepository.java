package de.bcxp.challenge.country;

import java.util.List;

/**
 * Stores Objects of the type Country
 */
public interface CountryRepository{

    /**
     * Get a country from its name
     * @param name the name of the country
     * @return the country
     */
    public Country getCountryByName(String name);

    /**
     * Get all the countries stores in the repository
     * @return a list containing the countries
     */
    public List<Country> getCountryEntries();
}
