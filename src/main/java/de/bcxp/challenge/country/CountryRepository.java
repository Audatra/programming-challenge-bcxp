package de.bcxp.challenge.country;

import java.util.List;

public interface CountryRepository{
    public Country getCountryByName(String name);
    public List<Country> getCountryEntries();
}
