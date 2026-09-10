package de.bcxp.challenge.country;

import java.util.Comparator;
import java.util.List;

public class CountryAnalyzer{
    private CountryRepository repository;

    public CountryAnalyzer(CountryRepository repository){
        this.repository = repository;
    }

    public String getCountryWithHighestPopulationDensity(){
        List<Country> countryEntries = repository.getCountryEntries();
        Country countryWithHighestPopulationDensity = countryEntries.stream().max(Comparator.comparingDouble(entry -> entry.getPopulation() / entry.getArea())).get();
        return countryWithHighestPopulationDensity.getName();
    }
}
