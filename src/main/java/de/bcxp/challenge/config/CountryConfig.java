package de.bcxp.challenge.config;

import de.bcxp.challenge.country.*;
import de.bcxp.challenge.fileHandling.*;

public class CountryConfig{
    private String filePath;
    private final char delimiter = ';';
    private final Class<? extends Enum<?>> headerEnum = CountryColumns.class;

    public CsvFileHandler csvFileHandler(){
        return new CsvFileHandler(filePath, delimiter, headerEnum);
    }

    public CountryRepository countryRepository(){
        return new CsvCountryRepository(csvFileHandler());
    }

    public CountryAnalyzer countryAnalyzer(String filePath){
        this.filePath = filePath;
        return new CountryAnalyzer(countryRepository());
    }

}
