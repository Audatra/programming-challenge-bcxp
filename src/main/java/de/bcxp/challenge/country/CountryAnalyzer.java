package de.bcxp.challenge.country;

import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountryAnalyzer{

    private CountryRepository repository;

    final static Logger logger = LoggerFactory.getLogger(CountryAnalyzer.class);

    public CountryAnalyzer(CountryRepository repository){
        this.repository = repository;
    }

    public String getCountryWithHighestPopulationDensity(){
        List<Country> countryEntries = repository.getCountryEntries();
        if(countryEntries.size() == 0){
            logger.warn("The Country Repository contains no entries");
            return null;
        }
        Country countryWithHighestPopulationDensity = countryEntries.stream().max(Comparator.comparingDouble(entry -> entry.getPopulation() / entry.getArea())).get();
        return countryWithHighestPopulationDensity.getName();
    }
}
